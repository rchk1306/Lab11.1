import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Form2 extends JFrame implements ActionListener {
    Container cp ;
    JButton left,right,up,down,box ;
    
    public Form2(){
        Initial();
        setComponent();
        Finally();
    }
    public void Initial(){
        cp = this.getContentPane();
        cp.setLayout(null);
    }
    public void setComponent(){

        left = new JButton("A");
        right = new JButton("D");
        up = new JButton("W");
        down = new JButton("S");
        box = new JButton();
        box.setBackground(Color.black);
        box.setBounds(0, 0, 50, 50);

        left.addActionListener(this);
        right.addActionListener(this);
        up.addActionListener(this);
        down.addActionListener(this);

        

        left.setBounds(25, 230, 47, 30);
        down.setBounds(70, 230, 47, 30);
        right.setBounds(115, 230, 47, 30);
        up.setBounds(70, 200, 47, 30);

        cp.add(left);cp.add(right);
        cp.add(up);cp.add(down);
        cp.add(box);

        up.addActionListener(this);
        down.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);
    }
    public void Finally(){
        this.setSize(200, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    
    int x = 0;
    int y = 0;
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == right && x < cp.getWidth()-50) {
            x = x+5;
            box.setBounds(x,y,50,50);
        }
        else if (e.getSource() == left && x > 0) {
            x = x-5;
            box.setBounds(x,y,50,50);
        }
        else if (e.getSource() == down && y < cp.getHeight()-115) {
            y = y+5;
            box.setBounds(x,y,50,50);
        }
        else if (e.getSource() == up && y > 0) {
            y = y-5;
            box.setBounds(x,y,50,50);
        }
    }
    
   
}