package Whatsapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.*;
import java.io.*;
public class Client extends JFrame implements ActionListener{
    JPanel p1;
    JTextField textField;
    JButton button;
    static JTextArea textArea;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    public Client(){
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,81));
        p1.setBounds(0,0,450,70);
        add(p1);
        
        ImageIcon i1=new ImageIcon("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\3.png");
        
        Image i2=i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel();
        label.setBounds(5, 17, 30, 30);
        label.setIcon(i3);
        p1.add(label);
        
        label.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });
        
        ImageIcon logo=new ImageIcon("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\Myimg_1.png");
        Image logo1=logo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon logo2=new ImageIcon(logo1);
        JLabel label2=new JLabel();
        label2.setBounds(40, 10, 50, 50);
        label2.setIcon(logo2);
        p1.add(label2);
        
          JLabel l1=new JLabel("Vikky");
        l1.setBounds(110,15,120,20);
        l1.setFont(new Font("Serif",Font.BOLD,18));
        l1.setForeground(new Color(255,255,255));
        p1.add(l1);
        
          JLabel l2=new JLabel("Active Now");
        l2.setBounds(110,45,120,15);
        l2.setFont(new Font("Serif",Font.BOLD,9));
        l2.setForeground(new Color(255,255,255));
        p1.add(l2);
        
        
         ImageIcon tol1=new ImageIcon("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\video.png");
        Image tol2=tol1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon tol3=new ImageIcon(tol2);
        JLabel l3=new JLabel();
        l3.setBounds(300, 22, 25, 25);
        l3.setIcon(tol3);
        p1.add(l3);
        
        
         ImageIcon tol21=new ImageIcon("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\phone.png");
        Image tol22=tol21.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon tol23=new ImageIcon(tol22);
        JLabel l4=new JLabel();
        l4.setBounds(350, 22, 25, 25);
        l4.setIcon(tol23);
        p1.add(l4);
        
         ImageIcon tol31=new ImageIcon("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\3icon.png");
        Image tol32=tol31.getImage().getScaledInstance(8, 20, Image.SCALE_DEFAULT);
        ImageIcon tol33=new ImageIcon(tol32);
        JLabel l5=new JLabel();
        l5.setBounds(400, 25, 8, 20);
        l5.setIcon(tol33);
        p1.add(l5);
        
        textArea=new JTextArea();
        textArea.setBounds(5,75,440,420);
        textArea.setFont(new Font("Arial",Font.PLAIN,16));
        textArea.setBackground(Color.white);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(textArea);
        
        textField=new JTextField();
        textField.setFont(new Font("Arial",Font.PLAIN,16));
        textField.setBounds(5,505,340,40);
        add(textField);
        
        button=new JButton("Send");
        button.setFont(new Font("Arial",Font.PLAIN,18));
        button.setForeground(Color.white);
        button.setBackground(new Color(7,94,84));
        button.setBounds(345,505,100,40);
        add(button);
        
        button.addActionListener(this);
        
        Image icon=Toolkit.getDefaultToolkit().getImage("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\Ai.png");
        setIconImage(icon);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WELCOME TO MY CHAT");
        setBounds(750,100,450,550);
        setLayout(null);
        setUndecorated(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String out=textField.getText();
        
        textArea.setText(textArea.getText()+"\n\t\t"+out);
        dout.writeUTF(out);
        textField.setText("");
        }catch(Exception e){
            
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Client().setVisible(true);
        
         String msginput="";
        try{
            //Server is In waiting State
      
            s=new Socket("localhost",3345);
            din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            msginput=din.readUTF();
            textArea.setText(textArea.getText()+"\n"+msginput);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
