
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
//Result set is in class sql
import java.sql.*;


public class StudentFeeForm extends JFrame implements ActionListener
{
    
    Choice crollno;
    
    JComboBox cbcourse, cbbranch,cbsemester;
    JLabel labeltotal;
    
    
    JButton back,pay,submit;
    
    
    StudentFeeForm()
    {
        setSize(900,500);
        setLayout(null);
        setLocation(300,100);
        getContentPane().setBackground(Color.white);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT );
        i1=new ImageIcon(i2);
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        
        
        JLabel lblrollnumber = new JLabel("Select Roll No");
        //here setbounds of heading is relative to frame that has been created
        lblrollnumber.setBounds(40,60,150,20);
        lblrollnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrollnumber);
        
        crollno=new Choice();
        crollno.setBounds(200,60,150,20);
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

        

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 100, 150, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 140, 150, 20);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(200, 140, 150, 20);
          labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfname);
        
        
        try
        {
            Conn c=new Conn();
            String query="select * from student where `Roll No` = '"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("Name"));
                 labelfname.setText(rs.getString("Father Name"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
         crollno.addItemListener(new ItemListener(){
        
             //method has been overridded
              public void itemStateChanged(ItemEvent io)
              {
                  try
        {
            Conn c=new Conn();
            String query="select * from student where `Roll No` = '"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("Name"));
                 labelfname.setText(rs.getString("Father Name"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                  
              }
        });
        
         
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 180, 150, 20);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);

        String course[] = {"B.s.c", "MBa", "MCom", "BCom","Masters"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 180, 150, 30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 220, 150, 20);
        lblbranch.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblbranch);

        String branch[] = {"CSE", "EEE", "MECHA", "CIVIL"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200, 220, 150, 30);
        cbbranch.setBackground(Color.white);
        add(cbbranch);

        
         
        JLabel lblsemester = new JLabel("Semester");
        //here setbounds of heading is relative to frame that has been created
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblsemester);
        
        
        String semester[]={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
        cbsemester=new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.WHITE);
        
        add(cbsemester);
        
        
         JLabel lbltotal = new JLabel("Total Payabale");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);

        
        labeltotal = new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labeltotal);
        
        
        
        //Button
        submit = new JButton("Update");
        submit.setBounds(30, 380, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);

        pay = new JButton("Pay fee");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.white);
        pay.setFont(new Font("serif", Font.BOLD, 16));
        pay.addActionListener(this);
        add(pay);
        
        
        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("serif", Font.BOLD, 16));
        back.addActionListener(this);
        add(back);

        
       
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==submit)
        {
            String course=(String)cbcourse.getSelectedItem();
            
            String semester=(String)cbsemester.getSelectedItem();
            
            try
            {
                Conn c=new Conn();
                
                ResultSet rs=c.s.executeQuery("Select * from fee where course='"+course+"'");
                
                while(rs.next())
                {    
                    labeltotal.setText(rs.getString(semester));   
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==pay)
        {
            String rollno=crollno.getSelectedItem();
            String course=(String)cbcourse.getSelectedItem();
            String semester=(String)cbsemester.getSelectedItem();
            String branch=(String)cbbranch.getSelectedItem();
            String total=labeltotal.getText();
            
            try
            {
                
                Conn c=new Conn();
                
                String query="Insert into university_fee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                
                c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"University fee submitted successfully");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
            setVisible(false);
    }
    
     public static void main(String[] args)
     {   
        new StudentFeeForm();
     }
}
