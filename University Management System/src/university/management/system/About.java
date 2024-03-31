
package university.management.system;


import java.awt.*;
import javax.swing.*;

import java.sql.*;
import net.proteanit.sql.DbUtils;
public class About extends JFrame
{
    About()
    {
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.white);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT );
        i1=new ImageIcon(i2);
        JLabel image=new JLabel(i1);
        image.setBounds(350,0,300 , 200);
        add(image);
        
        
        JLabel heading =new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        
         JLabel name =new JLabel("Developed By Oudarja Barman Tanmoy");
         name.setBounds(70,220,500,40);
         name.setFont(new Font("Tahoma",Font.BOLD,20));
        add( name);
        
        
         JLabel contact =new JLabel("Email: oudarja360@gmail.com");
         contact.setBounds(70,250,500,40);
         contact.setFont(new Font("Tahoma",Font.PLAIN,20));
         add( contact);
         
         JLabel phone =new JLabel("Phone: 01753320034");
         phone.setBounds(70,280,500,40);
         phone.setFont(new Font("Tahoma",Font.PLAIN,20));
         add( phone);
        
        setLayout(null);        
        setVisible(true);
    }
    
    
    public static void main(String[] args)
    {
        new  About();
    }
    

}
