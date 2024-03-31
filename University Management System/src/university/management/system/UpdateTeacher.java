package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField tfcourse, tfaddress, tfphone, tfemail,tfbranch;
    JLabel labelEmpId;

    JButton submit, cancel;
    Choice cEmpId;
    

    UpdateTeacher() {
        setSize(900, 650);
        setLocation(350, 50);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 30));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select  Employee Id");
        //here setbounds of heading is relative to frame that has been created
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollnumber);
        
        cEmpId=new Choice();
        cEmpId.setBounds(250,100,200,20);
        add(cEmpId);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from teacher");
            while(rs.next())
            {
                cEmpId.add(rs.getString("Employee Id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
          labelfname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelfname);
        

        JLabel lblrollno = new JLabel("Employee Id");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelEmpId = new JLabel();
        labelEmpId.setBounds(200, 200, 200, 30);
        labelEmpId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelEmpId);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));;
        add(lbldob);

        //For attaching calander a jar file has to be added  in libraries
        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labeldob);
        

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        tfaddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        tfemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfemail);

        JLabel lblx = new JLabel("S.S.C GPA:");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        JLabel labelx = new JLabel();
        labelx.setBounds(600, 300, 150, 30);
        labelx.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelx);

        JLabel lblxii = new JLabel("H.S.C GPA:");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        JLabel labelxii  = new JLabel();
        labelxii.setBounds(200, 350, 150, 30);
        labelxii.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelxii);

        JLabel NID = new JLabel("NID:");
        NID.setBounds(400, 350, 200, 30);
        NID.setFont(new Font("serif", Font.BOLD, 20));
        add(NID);

        JLabel labelnid =  new JLabel();
        labelnid .setBounds(600, 350, 150, 30);
        labelnid.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelnid);

        JLabel lblcourse = new JLabel("Education");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        tfcourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        //String branch[] = {"CSE", "EEE", "MECHA", "CIVIL"};
        tfbranch = new JTextField();
        tfbranch.setBounds(600, 400, 150, 30);
        tfbranch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfbranch.setBackground(Color.white);
        add(tfbranch);
        
        
        //Here a hit into database is required because existing info should be 
        //taken from db by roll number
        try
        {
            Conn c=new Conn();
            String query="select * from teacher where `Employee Id` = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("Name"));
                 labelfname.setText(rs.getString("Father Name"));
                 labeldob.setText(rs.getString("Date of Birth"));
                  tfaddress.setText(rs.getString("Address"));
                 tfphone.setText(rs.getString("Phone"));
            
                 tfemail.setText(rs.getString("email"));
                  labelx.setText(rs.getString("SSC GPA"));
                   labelxii.setText(rs.getString("HSC GPA"));
                    labelnid.setText(rs.getString("NID"));
                     labelEmpId.setText(rs.getString("Employee Id"));
                 tfcourse.setText(rs.getString("Qualification"));
                  tfbranch.setText(rs.getString("Department"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        cEmpId.addItemListener(new ItemListener(){
        
             //method has been overridded
              public void itemStateChanged(ItemEvent io)
              {
                  try
        {
            Conn c=new Conn();
            String query="select * from teacher where `Employee Id` = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("Name"));
                 labelfname.setText(rs.getString("Father Name"));
                 labeldob.setText(rs.getString("Date of Birth"));
                  tfaddress.setText(rs.getString("Address"));
                 tfphone.setText(rs.getString("Phone"));
            
                 tfemail.setText(rs.getString("email"));
                  labelx.setText(rs.getString("SSC GPA"));
                   labelxii.setText(rs.getString("HSC GPA"));
                    labelnid.setText(rs.getString("NID"));
                     labelEmpId.setText(rs.getString("Employee Id"));
                 tfcourse.setText(rs.getString("Qualification"));
                  tfbranch.setText(rs.getString("Department"));
                 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                  
              }
        });
        
        
        

        //Button
        submit = new JButton("Update");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) 
        {
            String EmployeeId = labelEmpId.getText();

            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            String qualification=tfcourse.getText();
                    
            String Dept=tfbranch.getText();

            //as mysql is an external entity so there could be error
            try {
            //Kind of DML command 
            String query = "update teacher set Address='"+ address +"',Phone='"+phone+"',email='" + email+"',Qualification='" +qualification+"',Department='"+Dept+"' where `Employee Id`='"+ EmployeeId+"'";
            Conn con=new Conn();
            //As it is a DML command so executeUpdate otherwise executequery
            con.s.executeUpdate(query);
            //Pop up message
            JOptionPane.showMessageDialog(null,"Teacher details updated successfully");
            setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else 
        {
            setVisible(false);
        }
       
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }

}
