package com.company;
import javax.swing.*;
import java.awt.*;

/**
 * this class if for simulating a calculator GUI(simple and scientific parts are both places in one frame)
 * @author maede mirzazadeh
 */
public class CalculatorGUI {
    //calculators frame
    JFrame calcFrame;
    //panel of scientific calculator
    JPanel simple;
    //panel of scientific calculator
    JPanel scientific;
    //this panel is for simple calculators keys
    JPanel simpleKeys;
    //this panel is for scientific calculators keys
    JPanel scientificKeys;
    //textarea for simple calculator
    JTextArea simpleArea;
    //textarea for scientific calculator
    JTextArea scientificArea;
    /**
     * this is the constructor of calculator gui
     */
    public CalculatorGUI(){
        createFrame();
        simple = new JPanel();
        scientific = new JPanel();
        simpleKeys = new JPanel();
        scientificKeys = new JPanel();
        simpleArea = new JTextArea(4,4);
        scientificArea = new JTextArea(4,4);
        simpleCalculator();
        scientific();
        createTabs();
        lookAndFeel();
        calcFrame.setVisible(true);
    }
    /**
     * this method creates a frame for calculator
     */
    private void createFrame(){
        //new frame
        calcFrame = new JFrame();
        //set title of frame
        calcFrame.setTitle("AUT Calculator");
        //setting size of frame
        calcFrame.setSize(500,500);
        //setting location of frame
        calcFrame.setLocation(500,100);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setResizable(false);

    }

    /**
     *add common keys between simple calculator and scientific calculator to a panel
     * @param panel panel we want to add buttons to it.
     */
    private void commonKeys(JPanel panel){
        String[] commonSigns = {"+","-","*","/"};
        for (int i=0;i<4;i++){
            JButton button = new JButton(commonSigns[i]);
            panel.add(button);
        }
        for (int i = 1; i < 4; i++) {
            JButton button = new JButton(new Integer(i).toString());
            panel.add(button);
        }
        JButton button1 = new JButton("mod");
        panel.add(button1);
        for (int i = 4; i < 7; i++) {
            JButton button = new JButton(new Integer(i).toString());
            panel.add(button);
        }
        JButton button2 = new JButton(".");
        panel.add(button2);
        for (int i = 7; i < 10; i++) {
            JButton button = new JButton(new Integer(i).toString());
            panel.add(button);
        }
        JButton button3 = new JButton("0");
        panel.add(button3);

    }

    /**
     * this method sets nimbus look and feel for GUI
     */
    public void lookAndFeel(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (Exception e){

        }
    }
    /**
     * this method creates a tabbedPane for calculator frame
     */
    public void createTabs(){
        JTabbedPane myTabbedPane = new JTabbedPane();
        myTabbedPane.setBounds(10,10,200,200);
        myTabbedPane.add("simple",simple);
        myTabbedPane.add("scientific",scientific);
        calcFrame.add(myTabbedPane);
    }

    /**
     * this method creates a simple calculator
     */
    private void simpleCalculator(){
        simple.setLayout(new BorderLayout());
        simpleArea.setEditable(false);
        simpleArea.setFont(new Font("Arial",14,14));
        simple.add(simpleArea,BorderLayout.NORTH);
        scroll(simpleArea,simple);
        simpleArea.setBackground(Color.CYAN);
        simple.add(simpleKeys,BorderLayout.CENTER);
        simpleKeys.setLayout(new GridLayout(4,4,2,2));
        commonKeys(simpleKeys);
        calcFrame.add(simple);

    }

    /**
     * this method creates a scientific calculator
     */
    private void scientific(){
        scientific.setLayout(new BorderLayout());
        scientificArea.setEditable(false);
        scientificArea.setFont(new Font("Arial",14,14));
        scientific.add(scientificArea,BorderLayout.NORTH);
        scientificArea.setBackground(Color.WHITE);
        scroll(simpleArea,simple);
        scientific.add(scientificKeys,BorderLayout.CENTER);
        scientificKeys.setLayout(new GridLayout(6,4,2,2));
        String[] scientificSigns = {"Sin/Cos","tan/cot","x!","Shift","x^y","1/x", "log/exp","e/pi"};
        for (int i=0;i<8;i++){
            JButton button = new JButton(scientificSigns[i]);
            scientificKeys.add(button);
        }
        commonKeys(scientificKeys);
        calcFrame.add(scientific);
    }

    /**
     * this method add a scroll to a text area
     * @param area text area
     * @param panel j panel that text area is in it.
     */
    private void scroll(JTextArea area , JPanel panel){
        JScrollPane scrollPane = new JScrollPane(area);
        panel.add(scrollPane, BorderLayout.NORTH);
    }
}