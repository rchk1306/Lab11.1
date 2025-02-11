import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Form1 extends JFrame implements ActionListener{
    Container cp ;
    JLabel name , id ;
    JTextField t1 ,t2 ;
    JButton b1,b2 ;
    public Form1(){
        Initial();
        setComponent();
        Finally();
    }
    public void Initial(){
        cp = this.getContentPane();
        cp.setLayout(null);
    }
    public void setComponent(){
        id = new JLabel("ID : ");
        name = new JLabel("Name : ");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        b1 = new JButton("Add");
        b2 = new JButton("Clear");  

        b1.addActionListener(this);
        b2.addActionListener(this);
        
        id.setBounds(32, 10, 60, 25);
        name.setBounds(10, 40, 60, 25);
        t1.setBounds(60, 10, 120, 25);
        t2.setBounds(60, 40, 180, 25);
        b1.setBounds(30, 80, 70, 25);
        b2.setBounds(120, 80, 70, 25);
        
        cp.add(id); cp.add(t1);
        cp.add(name); cp.add(t2);
        cp.add(b1) ; cp.add(b2);
    }
    public void Finally(){
        this.setSize(270, 160);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b2){
            t1.setText("");
            t2.setText("");

        }
        if(e.getSource() == b1){
            boolean error ;
            error = false ;
            String errorstring = "";
            String temp = t1.getText();
            for (int i = 0; i < temp.length() ; i++) {
                if ( !Character.isDigit(temp.charAt(i))) {
                    error = true ;
                    errorstring += "ID must be a number\n";
                    break;
                }
            }
            temp = t2.getText();
            for (int i = 0; i < temp.length() ; i++) {
                if (!(Character.isAlphabetic(temp.charAt(i)) || temp.charAt(i) == ' ' )) {
                    error = true ;
                    errorstring += "Name must be a string and blankspace\n";
                    break;
                }
            }
            if (error) {
                dialog(errorstring);
                
            } else {
                csv(t1.getText(),t2.getText());
                dialog("Complete.");
            }
        }
    }
    public void csv(String id , String name){
        File f = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
                try {
                        f = new File("STD.csv");
                        fw = new FileWriter(f,true);
                        bw = new BufferedWriter(fw);
                        bw.write(id + "," + name + "\n");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally{ 
                        try {
                        bw.close();
                        fw.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
        
                }
    }
    public void dialog(String s){
        JDialog d = new JDialog();
        JLabel l = new JLabel(s);
        d.getContentPane().add(l);
        d.setSize(200, 70);
        d.setVisible(true);
        d.setLocationRelativeTo(null);
        d.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
    }
}