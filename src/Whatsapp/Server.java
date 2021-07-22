
package Whatsapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class Server extends JFrame implements ActionListener{
    JPanel p1;
    JTextField textField;
    JButton button;
   static JTextArea textArea;
     static Socket s;
      static ServerSocket ss;
     static DataInputStream dis;
      static DataOutputStream dout;
    public Server(){
        
        
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,81));
        p1.setBounds(0,0,450,70);
        add(p1);
        
        ImageIcon i1=new ImageIcon("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\3.png");
       //To Scale the Image
        Image i2=i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        //Again Convert in Imageicon
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel();
        label.setIcon(i3);
        label.setBounds(5,17, 30, 30);
        p1.add(label);
        
        label.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });
        
        ImageIcon logo=new ImageIcon("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\a_1.png");
       //To Scale the Image
        Image logo1=logo.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        //Again Convert in Imageicon
        ImageIcon logo2=new ImageIcon(logo1);
        JLabel label2=new JLabel();
        label2.setIcon(logo2);
        label2.setBounds(40,5, 60, 60);
        p1.add(label2);
        
        
        JLabel l1=new JLabel("Smarty");
        l1.setBounds(110,10,120,30);
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
        getContentPane().setBackground(Color.white);
        
Image icon1 = Toolkit.getDefaultToolkit().getImage("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\Ai.png");    
setIconImage(icon1);


/*
  JButton b=new JButton(new ImageIcon("D:\\DPT\\Desktop\\Networking_Project\\src\\Whatsapp\\icon\\Tech_smart4.jpg"));
        b.setBounds(100,100,70, 40);
        add(b);*/


        setBounds(130,100,450,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    public static void main(String[] arg){
        new Server().setVisible(true);
        String msginput="";
        try{
            //Server is In waiting State
           ss=new ServerSocket(3345);
            s=ss.accept();//Connection is Stablised
            dis=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            msginput=dis.readUTF();
            textArea.setText(textArea.getText()+"\n"+msginput);
            ss.close();
            s.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
