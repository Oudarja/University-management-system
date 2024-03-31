
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import net.proteanit.sql.DbUtils;
        
public class ExaminationDetails extends JFrame implements ActionListener
{
    
    
    JTextField search;
    
    JButton submit,cancel;
    
    JTable table;
    
    
    ExaminationDetails()
    {
       
         setSize(1000,500);
         setLocation(300,150);
         
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
       
          
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        
        search=new JTextField();
        
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(search);
        
       
        submit = new JButton("Result");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);
        
        
        table = new JTable();
        
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        
        add(jsp);
        try
        {
               Conn c=new Conn();
               ResultSet rs=c.s.executeQuery("Select * from student");
             table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        //Mouse adapter is an interface 
        table.addMouseListener(new MouseAdapter(){
               
              //mouse clicked is an abstract function and it 's overridden 
                public void mouseClicked(MouseEvent me)
                {    
                 int row=table.getSelectedRow();
                 //table.getModel() as value has been retrieved from the table not value is set to 
                 //table ,not like previous one where setModel() was used
                 search.setText(table.getModel().getValueAt(row, 2).toString());
                }
    
    });
        
     
       setVisible(true);
    
     }   
    
    
     public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==submit)
        {
            setVisible(false);
            new Marks(search.getText());       
        }
        else
        {
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args)
    {
        new ExaminationDetails();
    }
    
}
