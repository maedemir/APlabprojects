package ceit.aut.ac.ir.gui;

import ceit.aut.ac.ir.model.Note;
import ceit.aut.ac.ir.utils.FileUtils;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this class is for making main panel
 */
public class CMainPanel extends JPanel {
    private JTabbedPane tabbedPane;
    private JList<File> directoryList;
    public CMainPanel() {
        setLayout(new BorderLayout());
        initDirectoryList(); // add JList to main Panel
        initTabbedPane(); // add TabbedPane to main panel
        addNewTab(); // open new empty tab when user open the application

    }

    /**
     * this method is for initializing tabbed pane and adding it to main panel
     */
    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * this method is for adding all files to directory list so that user can see a list of files and click
     * on each to be opened.
     */
    private void initDirectoryList() {
        File[] files = FileUtils.getFilesInDirectory();
        directoryList = new JList<>(files);
        directoryList.setBackground(new Color(211, 211, 211));
        directoryList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        directoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        directoryList.setVisibleRowCount(-1);
        directoryList.setMinimumSize(new Dimension(130, 100));
        directoryList.setMaximumSize(new Dimension(130, 100));
        directoryList.setFixedCellWidth(130);
        directoryList.setCellRenderer(new MyCellRenderer());
        directoryList.addMouseListener(new MyMouseAdapter());
        add(new JScrollPane(directoryList), BorderLayout.WEST);
    }

    /**
     * this method add a new tab to tabbed pane
     */
    public void addNewTab() {
        JTextArea textPanel = createTextPanel();
        textPanel.setText("Write Something here...");
        tabbedPane.addTab("Tab " + (tabbedPane.getTabCount() + 1), textPanel);
    }

    /**
     * this method opens an existing file when you double click on the file and add i
     * @param content
     */
    public void openExistingNote(String content) {
        JTextArea existPanel = createTextPanel();
        existPanel.setText(content);
        int tabIndex = tabbedPane.getTabCount() + 1;
        tabbedPane.addTab("Tab " + tabIndex, existPanel);
        tabbedPane.setSelectedIndex(tabIndex - 1);
    }
    /**
     * this method is for saving notes in files when you click on item "save"
     * this method works with fileOutputSteam method and fileWriter method of fileUtils class
     */
    public void saveNote() {
        JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
        String note = textPanel.getText();
        if (!note.isEmpty()) {
            //FileUtils.fileWriter(note);
            //FileUtils.fileOutputStream(note);
            FileUtils.serializing(note);
        }
        updateListGUI();
    }

    /**
     * this method creates a new JTextArea and return it
     * @return a new JTextArea
     */
    private JTextArea createTextPanel() {
        JTextArea textPanel = new JTextArea();
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return textPanel;
    }

    /**
     * this method update directory list when you save a new note
     */
    private void updateListGUI() {
        File[] newFiles = FileUtils.getFilesInDirectory();
        directoryList.setListData(newFiles);
    }

    /**
     * this method is for saving all existing files automatically when you click on "exit" item.
     * commented lines are for different types of saving a file(buffering and serializing)
     */
    public void saveOnExit(){
        for (int i=0 ;i<tabbedPane.getTabCount();i++) {
            JTextArea area = (JTextArea)tabbedPane.getComponent(i);
            String note = area.getText();
            if (!note.isEmpty()) {
                //FileUtils.fileOutputStream(note);
                //FileUtils.fileWriter(note);
                FileUtils.serializing(note);
            }
        }

    }

    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent eve) {
            // Double-click detected
            if (eve.getClickCount() == 2) {
                int index = directoryList.locationToIndex(eve.getPoint());
                System.out.println("Item " + index + " is clicked...");
                //TODO: Phase1: Click on file is handled... Just load content into JTextArea
                File curr[] = FileUtils.getFilesInDirectory();

                //opening a file with buffering
                /*String content = FileUtils.fileReader(curr[index]);
                openExistingNote(content);*/

                //these two commented codes are for opening a file with fileInputStream
                /*String content = FileUtils.fileInputStream(curr[index]);
                openExistingNote(content);*/

                // opening a file with deserialization
                String content = FileUtils.deserializing(curr[index]);
                openExistingNote(content);
            }
        }
    }


    private class MyCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean cellHasFocus) {
            if (object instanceof File) {
                File file = (File) object;
                // this two next lines are used for text files
                /*setText(file.getName());
                setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));*/

                //this commented code is for showing all serialized files in the left side of mainframe
                // when program is started

                Note note = FileUtils.getNote(file);
                String labelText="<html>"+note.getTitle()+"<br/>"+note.getDate();
                setText(labelText);
                setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setEnabled(list.isEnabled());
            }
            return this;
        }
    }
}
