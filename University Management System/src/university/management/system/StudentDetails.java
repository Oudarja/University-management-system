
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

public class StudentDetails extends JFrame implements ActionListener
{
    Choice crollno;
    
    JTable table;
    
    JButton search,print,update,add,cancel;
    
    StudentDetails(){
        
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
            ResultSet rs=c.s.executeQuery("Select * from student");
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
        
        add=new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add (add);
        
        update=new JButton("update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add (update);
        
        cancel=new JButton("cancel");
        cancel.setBounds(420,70,80,20);
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
        else if(ae.getSource()==add)
        {
            setVisible(false);
            new AddStudent();
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new UpdateStudent();
        }
        else{
            
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        
        new StudentDetails();
    }
    
}
