package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author  maede mirzazadeh
 * @version 1
 * this class is for simulating a simple and scientific gui calculator !
 * keyListener is not implemented:(((
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
    handler calculatorHandler = new handler();
    JTabbedPane myTabbedPane;
    //show if shift is enabled or not
    int shiftCounter = 0;
    //GUI event handler
    handler handler = new handler();
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
     * this class is for actionHandling
     */
    private class handler  implements ActionListener {
        //an array list to hold inputs of calculator
        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<String> historySimple = new ArrayList<>();
        ArrayList<String> historyScientific = new ArrayList<>();
        String simpleInput = "";
        String scientificInput = "";
        String input = "";
        String string = "";
        @Override
        public void actionPerformed(ActionEvent e) {
            //simple calc
            if (myTabbedPane.getSelectedIndex() == 0){
                switch (e.getActionCommand()){
                    case "=":{
                        String save = simpleInput;
                        simpleInput = calculate(inputs);
                        save = save + "=" + simpleInput;
                        historySimple.add(save);
                        break;
                    }
                    case "AC":{
                        remove(inputs);
                        simpleInput = "";
                        //updates the simple input to be shown in the calculator
                        for (String str : inputs){
                            simpleInput = simpleInput + str;
                        }
                        break;
                    }
                    //numbers and * - / +
                    default:{
                        inputs.add(e.getActionCommand());
                        simpleInput = simpleInput+ e.getActionCommand();
                    }
                }
                simpleArea.setText(simpleInput);
            }
            //scientific calc
            if(myTabbedPane.getSelectedIndex() == 1){

                switch (e.getActionCommand()){
                    case "=":{
                        String countainer = scientificInput;
                        scientificInput = calculate(inputs);
                        countainer =countainer + "=" + scientificInput;
                        historyScientific.add(countainer);
                        break;
                    }
                    case "AC":{
                        remove(inputs);
                        scientificInput= "";
                        for (String s : inputs){
                            scientificInput= scientificInput+ s;
                        }
                        break;
                    }
                    case "Shift":{
                        shiftCounter++;
                        break;
                    }
                    default:{
                        String add = e.getActionCommand();
                        if(e.getActionCommand().equals("Sin/Cos")){
                            if (shiftCounter%2==0){
                                add = "Sin";
                            }
                            else {
                                add = "Cos";
                            }
                        }
                        if (e.getActionCommand().equals("tan/cot")){
                            if (shiftCounter%2==0){
                                add = "tan";
                            }
                            else {
                                add = "cot";
                            }
                        }
                        if(e.getActionCommand().equals("log/exp")){
                            if (shiftCounter%2==0){
                                add = "log";
                            }
                            else {
                                add = "exp";
                            }
                        }
                        if (e.getActionCommand().equals("!")){
                            add = "!";
                        }
                        inputs.add(add);
                        scientificInput = scientificInput + add;
                    }
                }
                scientificArea.setText(scientificInput);
            }
        }
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
        JMenuBar menuBar = new JMenuBar();
        JMenu copy = new JMenu("Copy");
        JMenu exit = new JMenu("Exit");
        JMenuItem data = new JMenuItem("Copy history");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setActionCommand("Exit");
        copy.setMnemonic(KeyEvent.VK_C);
        copy.add(data);
        copy.setActionCommand("Copy");
        data.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));

        menuBar.add(exit);
        menuBar.add(copy);

        calcFrame.setJMenuBar(menuBar);

    }

    /**
     *add common keys between simple calculator and scientific calculator to a panel
     * @param panel panel we want to add buttons to it.
     */
    private void commonKeys(JPanel panel){
        String[] commonSigns = {"+","-","*","/"};
        String[] toolTip = {"plus","minus", "multiply", "division"};
        for (int i=0;i<4;i++){
            JButton button = new JButton(commonSigns[i]);
            button.addActionListener(handler);
            button.setToolTipText(toolTip[i]);
            panel.add(button);
        }
        for (int i = 1; i < 4; i++) {
            JButton button = new JButton(new Integer(i).toString());
            button.addActionListener(handler);
            panel.add(button);
        }
        JButton button1 = new JButton("=");
        button1.addActionListener(handler);
        button1.setToolTipText("equals to");
        panel.add(button1);
        for (int i = 4; i < 7; i++) {
            JButton button = new JButton(new Integer(i).toString());
            button.addActionListener(handler);
            panel.add(button);
        }
        JButton button2 = new JButton("AC");
        button2.setToolTipText("delete");
        button2.addActionListener(handler);
        panel.add(button2);
        for (int i = 7; i < 10; i++) {
            JButton button = new JButton(new Integer(i).toString());
            button.addActionListener(handler);
            panel.add(button);
        }
        JButton button3 = new JButton("0");
        button3.addActionListener(handler);
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
        myTabbedPane = new JTabbedPane();
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
        simpleArea.setLineWrap(true);
        simpleArea.setFocusable(true);
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
        scientificArea.setLineWrap(true);
        scientificArea.setFocusable(true);
        scroll(simpleArea,simple);
        scientific.add(scientificKeys,BorderLayout.CENTER);
        scientificKeys.setLayout(new GridLayout(6,4,2,2));
        String[] scientificSigns = {"Sin/Cos","tan/cot","!","Shift","^","sqrt", "log/exp","e/pi"};
        String[] toolTips = { "sin and cos","tan and cot","factorial","change operations(sin->cos) ","power","sqrt" , "logarithm and exponential","Neper and pi number"};
        for (int i=0;i<8;i++){
            JButton button = new JButton(scientificSigns[i]);
            button.addActionListener(handler);
            button.setToolTipText(toolTips[i]);
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

    /**
     * this method do mathematics based on inputs and return a string result;
     * @param inputs arraylist of inputs
     * @return string result
     */
    private String calculate(ArrayList<String> inputs){
        String result = "";
        if(inputs.get(0).equals("e")){
            result = "2.71";
            return result;
        }
        if (inputs.get(0).equals("pi")){
            result = "3.14";
            return result;
        }
        if (inputs.get(0).equals("Sin")){
            int temp;
            if(inputs.get(1).equals("-")){
                temp = makeNumber(inputs,2);
                result =String.valueOf(Math.sin(-temp));
                return result;
            }
            temp = makeNumber(inputs,1);
            result = String.valueOf(Math.sin(temp));
            return result;
        }

        if (inputs.get(0).equals("Cos")){
            int temp;
            if(inputs.get(1).equals("-")){
                temp = makeNumber(inputs,2);
                result = String.valueOf(Math.cos(-temp));
                return result;
            }
            temp = makeNumber(inputs,1);
            result = String.valueOf(Math.cos(temp));
            return result;

        }

        if(inputs.get(0).equals("tan")){
            int temp;
            if(inputs.get(1).equals("-")){
                temp = makeNumber(inputs,2);
                result = String.valueOf(Math.tan(-temp));
                return result;
            }
            temp = makeNumber(inputs,1);
            result = String.valueOf(Math.tan(temp));
            return result;

        }

        if (inputs.get(0).equals("cot")){
            int temp;
            if(inputs.get(1).equals("-")){
                temp = makeNumber(inputs,2);
                result = String.valueOf(Math.atan(-temp));
                return result;
            }
            temp = makeNumber(inputs,1);
            result = String.valueOf(Math.atan(temp));
            return result;

        }

        if (inputs.get(0).equals("log")){
            int temp;
            if(inputs.get(1).equals("-")){
                temp = makeNumber(inputs,2);
                result = String.valueOf(Math.log(-temp));
                return result;
            }
            temp = makeNumber(inputs,1);
            result = String.valueOf(Math.log(temp));
            return result;
        }

        if (inputs.get(0).equals("exp")){
            int temp;
            if(inputs.get(1).equals("-")){
                temp = makeNumber(inputs,2);
                result = String.valueOf(Math.exp(-temp));
                return result;
            }
            temp = makeNumber(inputs,1);
            result = String.valueOf(Math.exp(temp));
            return result;
        }
        if (inputs.get(0).equals("sqrt")){
            int temp;
            if(inputs.get(1).equals("-")){
                return "error";
            }
            temp = makeNumber(inputs,1);
            result = String.valueOf(Math.sqrt(temp));
            return result;
        }
        //two operand calculations(except for !)
        if(inputs.size()>1){
            int firstInput = makeNumber(inputs,0);
            if (inputs.get(1).equals("!")){
                int fact =1;
               for(int i = 1; i<=firstInput ; i++){
                  fact=fact*i;
               }
               result = String.valueOf(fact);
                return result;
            }
            int seccondInput = makeNumber(inputs,2);
            if(inputs.get(1).equals("+")){
                result = String.valueOf(firstInput+seccondInput);
            }
            if (inputs.get(1).equals("-")){
                result = String.valueOf(firstInput-seccondInput);
            }
            if (inputs.get(1).equals("*")){
                result = String.valueOf(firstInput*seccondInput);
            }
            if (inputs.get(1).equals("/")){
                if(seccondInput==0)
                    return "error , division by zero";
                result = String.valueOf(firstInput/(float)seccondInput);
            }
            if (inputs.get(1).equals("^")){
                result = String.valueOf(Math.pow(firstInput,seccondInput));
            }
            for (int i=0,j=0; j<3; j++){
                inputs.remove(i);
            }
            inputs.add(0,result);
        }
        return result;
    }

    /**
     * this method turn a string to a integer
     * @param inputs array list of inputs
     * @param index index of string we wanna turn into number
     * @return integer correspondent number
     */
    private int makeNumber(ArrayList<String> inputs, int index){
        String number = "";
        int temp = index;
        int size = inputs.size();
        while (check(inputs.get(index))){
            number = number + inputs.get(index);
            index++;
            if(index>=size){
                break;
            }
        }
        for (int i=temp,j=temp; j<index; j++){
            inputs.remove(i);
        }
        inputs.add(temp,number);
        return Integer.parseInt(number);
    }
    /**
     * checks if an input string is one of operands or not!
     * @param input an input string
     * @return false if this input is operator
     */
    private boolean check(String input){
        String arr[] = {"Shift","pi/e","log/exp","Sin/Cos","tan/cot","Sqrt","AC","/","*","+","-","=","!","^"};
        for (int i=0; i<arr.length; i++){
            if (input.equals(arr[i])){
                return false;
            }
        }
        return true;
    }
    /**
     * this method is used to simulate ac key . everytime you click on ac button , one of the strings on the text area will be removed
     * it removes the last element of array list;
     * @param inputs array list of inputs(string)
     */
    private void remove(ArrayList<String> inputs){
        if (inputs.size()>0){
            inputs.remove(inputs.size()-1);
        }

    }
}
