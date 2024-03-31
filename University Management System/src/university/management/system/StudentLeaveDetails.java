
package university.management.system;

import javax.swing.*;
import java.awt.*;
//Result set is in class sql
import java.sql.*;

//this import is necessary for printing the database to Jframe
//in library rs2xml.jar file all of these component are availble
/*
The DbUtils class is a part of the Protean SQL library, which is a Java library for working with SQL databases. 
*/
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame implements ActionListener
{
    Choice crollno;
    
    JTable table;
    
    JButton search,print,cancel;
    
   StudentLeaveDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        //here setbounds of heading is relative to frame that has been created
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno=new Choice();
        crollno.setBounds(180,20,150,20);
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
        
        table=new JTable();
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from studentleave");
            //In DbUtils class there is one method named resultSetToTableModel which 
            //is used and passed as argument rs [result set]
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add (search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add (print);
        
        
        cancel=new JButton("cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add (cancel);
       
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
            //As Roll no is not one string so it has to be secified by giving backtick or apostrophe
            String query="select * from student where `Roll No` = '"+crollno.getSelectedItem()+"'";
             
            try
            {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print)
        {
            //print command is an external entity 
            //so try catch block is required
            try
            {
                table.print();
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
        
        new StudentLeaveDetails();
    }
    
}
