package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfid;
    JLabel labelempid;

    JDateChooser dcdob;

    //For justing option in field
    JComboBox cbcourse, cbbranch;

    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs(ran.nextLong() % 100000) + 1000;

    AddTeacher() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel lblempId = new JLabel("Employee Id");
        lblempId.setBounds(50, 200, 200, 30);
        lblempId.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempId);

         labelempid = new JLabel("101" + first4);
         labelempid.setBounds(200, 200, 200, 30);
         labelempid.setFont(new Font("serif", Font.BOLD, 20));
        add( labelempid);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        //For attaching calander a jar file has to be added  in libraries
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblx = new JLabel("S.S.C GPA:");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);

        JLabel lblxii = new JLabel("H.S.C GPA:");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);

        JLabel NID = new JLabel("NID:");
        NID.setBounds(400, 350, 200, 30);
        NID.setFont(new Font("serif", Font.BOLD, 20));
        add(NID);

        tfid = new JTextField();
        tfid.setBounds(600, 350, 150, 30);
        add(tfid);

        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        String course[] = {"BSc", "MBa", "MCom", "BCom"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        String branch[] = {"CSE", "EEE", "MECHA", "CIVIL"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.white);
        add(cbbranch);

        //Button
        submit = new JButton("Submit");
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
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String empid = labelempid.getText();
            //After converting into JTextField getText() function has been used to retrieve
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();

            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String nid = tfid.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            //as mysql is an external entity so there could be error
            try {
            //Kind of DML command 
            String query = "insert into teacher value('" + name + "','" + fname + "','" + empid + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + x + "','" + xii + "','" + nid + "','" + course + "','" + branch + "')";
            Conn con=new Conn();
            //As it is a DML command so executeUpdate otherwise executequery
            con.s.executeUpdate(query);
            //Pop up message
            JOptionPane.showMessageDialog(null,"Teacher details inserted successfully");
            setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddTeacher();
    }

}
