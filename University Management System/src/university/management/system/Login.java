
package university.management.system;
//import java.awt.Color;
import javax.swing.*;
import java.awt.*;
//actionlistener is in the java.awt.event package 
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    //globally declared as actionPerformed function have to identify 
    JButton login,cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        //After setting layout null explicitly the component of the layout have to be 
        //placed
        
        //To write any thing over frame JLabel class is used
        JLabel lblusername = new JLabel("Username");
        //Explicitly now compomnent is made as default layout is made null
        lblusername.setBounds(40,20,100,20);
        //It will placed at the middle of frame but it is not required we have to off the by default layout system so 
        //setLayout(null) has been done
        add(lblusername);
        
        //Now input field
        
         tfusername= new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
//        setSize(600,300);
//        setLocation(500,250);
//        setVisible(true);
        
        //Now Password
        //To write any thing over frame JLabel class is used
        JLabel lblpassword = new JLabel("Password");
        //Explicitly now compomnent is made as default layout is made null
        lblpassword.setBounds(40,70,100,20);
        //It will placed at the middle of frame but it is not required we have to off the by default layout system so 
        //setLayout(null) has been done
        add(lblpassword);
        
        //Now input field as input is password here so JPasswordField class should be used for disappearing of the given password by admin
        
        tfpassword= new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        
        //Now 2 button need to added
        login=new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.setFont(new Font("serif",Font.BOLD,16));
        add(login);
        login.addActionListener(this);
        
        //Cancel
         cancel=new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        add(cancel);
        //This addActionListener will call the actionPerformed function internally which is a abstract method of 
        //ActionListener class 
        cancel.addActionListener(this);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT );
        i1=new ImageIcon(i2);
        JLabel image=new JLabel(i1);
        //as here layout is null so extra setbound is needed 
        image.setBounds(350,0,200,200);
        add(image);
        
        
        
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    
    //for differention of login or cancel ActionEvent class is used 
    //which finds the source of action 
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            String username=tfusername.getText();
            String password=tfpassword.getText();
            //DDL command
            String query="select * from login where username='"+username+"'and password='"+password+"'";
            
            
            try
            {
                Conn c=new Conn();
                //In object of ResultSet class the result
                //of mysql query will be stored this class is in
                //sql package
                ResultSet rs = c.s.executeQuery(query);
                
                
                if(rs.next())
                {
                    setVisible(false);
                    new Project();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
                    
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Login();
    }
}
