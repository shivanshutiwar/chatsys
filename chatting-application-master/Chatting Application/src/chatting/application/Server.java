package chatting.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Server implements ActionListener{
    
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JPanel a1;
    static JFrame f1 = new JFrame();
    
    static Box vertical = Box.createVerticalBox();
    
    static ServerSocket skt;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    Boolean typing;
    
    Server(){
        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7, 8, 84));
        p1.setBounds(0, 0, 250, 700);//y h blue color wala box
        f1.add(p1);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
       Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l1 = new JLabel(i3);
       l1.setBounds(0, 17, 30, 30);
       p1.add(l1);
       
       l1.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent ae){
               System.exit(0);
           }
       });
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/1.png"));
       Image i5 = i4.getImage().getScaledInstance(99, 95, Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel l2 = new JLabel(i6);
       l2.setBounds(32, 5, 55, 55);
       p1.add(l2);
       
       ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
       Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
       ImageIcon i9 = new ImageIcon(i8);
       JLabel l5 = new JLabel(i9);
       l5.setBounds(290, 20, 30, 30);
       p1.add(l5);
       
       ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
       Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
       ImageIcon i13 = new ImageIcon(i12);
       JLabel l6 = new JLabel(i13);
       l6.setBounds(350, 20, 35, 30);
       p1.add(l6);
       
       ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
       Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
       ImageIcon i16 = new ImageIcon(i15);
       JLabel l7 = new JLabel(i16);
       l7.setBounds(1020, 20, 800, 25);
       p1.add(l7);
       
       //y h priyanka ki image
       ImageIcon i77 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/pk.png"));
       Image i211 = i77.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
       ImageIcon i322 = new ImageIcon(i211);
       JLabel l122 = new JLabel(i322);
       l122.setBounds(35, 67, 55, 50);
       p1.add(l122);
//y h uske aage name print hone k liye
       JLabel l33 = new JLabel("priyanka");
       l33.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
       l33.setForeground(Color.WHITE);
       l33.setBounds(110, 75, 100, 18);
       p1.add(l33);
       
       //y h active status k liye
       JLabel l44 = new JLabel("last seen 7;01");
       l44.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
       l44.setForeground(Color.WHITE);
       l44.setBounds(120, 95, 100, 20);
       p1.add(l44);  
       
       
       
       // y h 3rd image jo adi ki h
       ImageIcon i43 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/ay.png"));
       Image i54 = i43.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
       ImageIcon i65 = new ImageIcon(i54);
       JLabel l21 = new JLabel(i65);
       l21.setBounds(32, 135, 55, 55);
       p1.add(l21);
       
       
       //y label h ayushi ka name print karne k liye
       JLabel l32 = new JLabel("ayushi");
       l32.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
       l32.setForeground(Color.WHITE);
       l32.setBounds(110, 135, 100, 18);
       p1.add(l32);   
       
       
       JLabel l43 = new JLabel("Active Now");
       l43.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
       l43.setForeground(Color.WHITE);
       l43.setBounds(110, 155, 100, 20);
       p1.add(l43);  
        
       
       
       // y h devsh ki photo
       ImageIcon i433 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/d.png"));
       Image i544 = i433.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
       ImageIcon i655 = new ImageIcon(i544);
       JLabel l211 = new JLabel(i655);
       l211.setBounds(32, 203, 55, 55);
       p1.add(l211);
       
       
       //y label h devesh ka name print karne k liye
       JLabel l322 = new JLabel("devesh");
       l322.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
       l322.setForeground(Color.WHITE);
       l322.setBounds(110, 195, 100, 18);
       p1.add(l322);   
       
       
       JLabel l433 = new JLabel("Active Now");
       l433.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
       l433.setForeground(Color.WHITE);
       l433.setBounds(110, 215, 100, 20);
       p1.add(l433);  
        
       
       // prashant ki photo
       ImageIcon i4333 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/p.png"));
       Image i5444 = i4333.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
       ImageIcon i6555 = new ImageIcon(i5444);
       JLabel l2111 = new JLabel(i6555);
       l2111.setBounds(32, 271, 55, 55);
       p1.add(l2111);
       
       
       //y label h prashant ka name print karne k liye
       JLabel l3222 = new JLabel("prashant");
       l3222.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
       l3222.setForeground(Color.WHITE);
       l3222.setBounds(110, 265, 100, 18);
       p1.add(l3222);   
       
       
       JLabel l4333 = new JLabel("Active Now");
       l4333.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
       l4333.setForeground(Color.WHITE);
       l4333.setBounds(110, 285, 100, 20);
       p1.add(l4333);  
       
       //soop ki phito
       ImageIcon i44333 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/s.png"));
       Image i55444 = i44333.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
       ImageIcon i66555 = new ImageIcon(i55444);
       JLabel l22111 = new JLabel(i66555);
       l22111.setBounds(32, 341, 55, 55);
       p1.add(l22111);
       
       
       //y label h soop ka name print karne k liye
       JLabel l33222 = new JLabel("priya");
       l33222.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
       l33222.setForeground(Color.WHITE);
       l33222.setBounds(110, 335, 100, 18);
       p1.add(l33222);   
       
       
       JLabel l44333 = new JLabel("Active Now");
       l44333.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
       l44333.setForeground(Color.WHITE);
       l44333.setBounds(110, 355, 100, 20);
       p1.add(l44333);  
       
       
        
       
       
       
       
       //y label h somya ka name print karne k liye
       JLabel l3 = new JLabel("somya");
       l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
       l3.setForeground(Color.WHITE);
       l3.setBounds(110, 15, 100, 18);
       p1.add(l3);   
       
       
       JLabel l4 = new JLabel("Active Now");
       l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
       l4.setForeground(Color.WHITE);
       l4.setBounds(110, 35, 100, 20);
       p1.add(l4);  
       
       Timer t = new Timer(1, new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               if(!typing){
                   l4.setText("Active Now");
               }
           }
       });
       
       t.setInitialDelay(2000);
       
       
       a1 = new JPanel();
       a1.setBounds(255, 55, 830, 500);//text area jah text aayenge
       a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       f1.add(a1);
       
       JScrollPane sp=new JScrollPane(a1);
       sp.setBounds(255, 55, 830, 500);
       f1.add(sp);
             
       
       t1 = new JTextField();
       t1.setBounds(255, 655,750, 40);//y h text jaha type iye jayenge
       t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       f1.add(t1);
       
       t1.addKeyListener(new KeyAdapter(){
           public void keyPressed(KeyEvent ke){
               l4.setText("typing...");
               
               t.stop();
               
               typing = true;
           }
           
           public void keyReleased(KeyEvent ke){
               typing = false;
               
               if(!t.isRunning()){
                   t.start();
               }
           }
       });
       
       b1 = new JButton("Send");
       b1.setBounds(1000, 655, 123, 40);
       b1.setBackground(new Color(7, 94, 84));
       b1.setForeground(Color.WHITE);
       b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       b1.addActionListener(this);
       f1.add(b1);
        
       f1.getContentPane().setBackground(Color.WHITE);
       f1.setLayout(null);
       f1.setSize(1100, 700);
       f1.setLocation(400, 30); 
       f1.setUndecorated(true);
       f1.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String out = t1.getText();
            
            JPanel p2 = formatLabel(out);
            
            a1.setLayout(new BorderLayout());
            
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            
            a1.add(vertical, BorderLayout.PAGE_START);
            
            //a1.add(p2);
            dout.writeUTF(out);
            t1.setText("");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static JPanel formatLabel(String out){
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        
        JLabel l1 = new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setBackground(new Color(37, 111, 102));
        l1.setOpaque(true);
        l1.setBorder(new EmptyBorder(15,15,15,50));
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel l2 = new JLabel();
        l2.setText(sdf.format(cal.getTime()));
        
        p3.add(l1);
        p3.add(l2);
        return p3;
    }
    
    public static void main(String[] args){
    	
        new Server().f1.setVisible(true);
        
        String msginput = "";
        try{
           
            while(true){ skt = new ServerSocket(6001);
                s = skt.accept();
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
            
	        while(true){
	                msginput = din.readUTF();
                        JPanel p2 = formatLabel(msginput);
                        
                        JPanel left = new JPanel(new BorderLayout());
                        left.add(p2, BorderLayout.LINE_START);
                        vertical.add(left);
                        f1.validate();
            	}
                
            }
            
        }catch(Exception e){}
    }    
}
