
package university.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentLeave  extends JFrame implements ActionListener
{
    
    Choice crollno,ctime;
    
    JDateChooser dcdate;
    
    JButton submit,cancel;
    
    
    StudentLeave()
    {
       setSize(500,550);
       setLocation(550,150);
       setLayout(null);
       getContentPane().setBackground(Color.white);
         JLabel heading = new JLabel("Apply Leave (Student)");
        //here setbounds of heading is relative to frame that has been created
        heading.setBounds(40,50,300,30);
        
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        
         JLabel lblrollno = new JLabel("Search by Roll Number");
        //here setbounds of heading is relative to frame that has been created
        lblrollno.setBounds(60,100,150,20);
        add(lblrollno);
        
        crollno=new Choice();
        crollno.setBounds(60,130,200,20);
        add(crollno);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from student");
            while(rs.next())
            {
                crollno.add(rs.getString("Roll No"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
         JLabel lbldate = new JLabel("Date");
        //here setbounds of heading is relative to frame that has been created
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18 ));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 150, 25);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        //here setbounds of heading is relative to frame that has been created
        lbltime.setBounds(60,260,200,20);
        add(lbltime);
        
        ctime=new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        
        //Button
        
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);
        
        
      setVisible(true);
       
    }
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==submit)
         {
             String rollno=crollno.getSelectedItem();
             String date=((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();
            
            String query="insert into studentleave values('"+rollno+"','"+date+"','"+duration+"')";
            
            
            try
            {
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
              
         }
         else
         {
             setVisible(false);
         }
         
     }
    
    
    public static void main(String[] args)
    {    
        new StudentLeave();   
    }
}
