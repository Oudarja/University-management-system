
package university.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Project extends JFrame implements ActionListener
{
    private ImageIcon[] images;
    private int currentImageIndex;
    private Timer timer;
    Project()
    {
        setSize(1540,850);
        // Load images
        images = new ImageIcon[3];
        images[0] = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        images[1] = new ImageIcon(ClassLoader.getSystemResource("icons/third2.jpg"));
        images[2] = new ImageIcon(ClassLoader.getSystemResource("icons/third3.jpg"));
        // Set up initial image
        setInitialImage();

        // Set up a timer to switch images every 5 seconds (5000 milliseconds)
        timer = new Timer(5000, this);
        timer.start();
        
        /*
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1540,850,Image.SCALE_DEFAULT );
        i1=new ImageIcon(i2);
        JLabel image=new JLabel(i1);
        add(image);
        */
        
        //Creating menubar
        JMenuBar mb=new JMenuBar();
        
        //This is a one of  menu in menubar
        //NEW INFORMATION
        JMenu newInformation=new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        //adding menu item in a menu of menubar
        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        //adding another menu item
        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        //Details
        JMenu details=new JMenu("View Details");
        details.setForeground(Color.GRAY);
        mb.add(details);
        //adding menu item in a menu of menubar
        JMenuItem facultydetails=new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        //adding another menu item
         JMenuItem studentdetails=new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);
        
        
        
        //Leave
        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        //adding menu item in a menu of menubar
        JMenuItem facultyleave=new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        //adding another menu item
         JMenuItem studentleave=new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        
        
        //Leave Details
        JMenu leaveDetails=new JMenu("leave Details");
        leaveDetails.setForeground(Color.GRAY);
        mb.add(leaveDetails);
        //adding menu item in a menu of menubar
        JMenuItem facultyleavedetails=new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);
        
        //adding another menu item
        JMenuItem studentleavedetails=new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);
        
        
        
        //Exams
        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        //adding menu item in a menu of menubar
        JMenuItem examinationdetails=new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        
        //adding another menu item
         JMenuItem entermarks=new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        //UpdateInfo
         JMenu updateInfo=new JMenu("Update Details");
        updateInfo.setForeground(Color.GRAY);
        mb.add(updateInfo);
        //adding menu item in a menu of menubar
        JMenuItem updateFacultyinfo=new JMenuItem("Update Faculty Details");
        updateFacultyinfo.setBackground(Color.WHITE);
        updateFacultyinfo.addActionListener(this);
        updateInfo.add(updateFacultyinfo);
        
        //adding another menu item
         JMenuItem updateStudentinfo=new JMenuItem("Update Student Details");
        updateStudentinfo.setBackground(Color.WHITE);
        updateStudentinfo.addActionListener(this);
        updateInfo.add(updateStudentinfo);
        
        
        //Fee
        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        //adding menu item in a menu of menubar
        JMenuItem feestructure=new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        //adding another menu item
        JMenuItem feeform=new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);
        
        //Utility function
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.GRAY);
        mb.add(utility);
        
        //adding menu item in a menu of menubar
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        //adding another menu item
         JMenuItem calc=new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
        //about
        
        JMenu about=new JMenu("About");
        about.setForeground(Color.blue);
        mb.add(about);
        JMenuItem ab=new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
        //exit
        
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.GRAY);
        mb.add(exit);
        JMenuItem ex=new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        
        
        setJMenuBar(mb);
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new Project();
    }
    // Helper method to set the current image
    private void setInitialImage()
    {
        Image scaledImage = images[currentImageIndex].getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
        images[currentImageIndex] = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(images[currentImageIndex]);
        add(imageLabel);
    }
    //abstract method has been overridden
     public void actionPerformed(ActionEvent ae)
    {
        
        // If the source is the timer, switch to the next image
        if (ae.getSource() == timer) {
            currentImageIndex = (currentImageIndex + 1) % images.length;
            Image scaledImage = images[currentImageIndex].getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
            images[currentImageIndex] = new ImageIcon(scaledImage);
           //dynamically change the image being shown based on the currentImageIndex.
            ((JLabel) getContentPane().getComponent(0)).setIcon(images[currentImageIndex]);
        } 
        else
        {
        //As here is no butten so the string has to be fetched
        //on which click has been pressed
        String msg=ae.getActionCommand();
         if(msg.equals("Exit"))
         {
             setVisible(false);
         }
         else if(msg.equals("Calculator"))
         {
             //if there is no calculator then error 
             //will be raised so try and catch 
             try
             {
                 //"Runtime" is a class and "getRuntime()" is a static method
                 //the single instance of the "Runtime" class by calling the
                 //static method "getRuntime()" on the Runtime class itself.
                 // "exec()" method, which is used to execute an external process.
                Runtime.getRuntime().exec("Calc.exe");
             }
             catch(Exception e)
             {
                 
             }
             
         }
         else if(msg.equals("Notepad"))
         {
             
              try{
                  Runtime.getRuntime().exec("notepad.exe");
             }
             catch(Exception e)
             {
                 
             }
         }
         else if(msg.equals("New Faculty Information"))
         {
             new AddTeacher();
         }
         else if(msg.equals("New Student Information"))
         {
             new AddStudent();
         }
          else if(msg.equals("View Faculty Details"))
         {
             new TeacherDetails();
         }
         else if(msg.equals("View Student Details"))
         {
             new StudentDetails();
         }
         else if(msg.equals("Faculty Leave"))
         {
             new TeacherLeave();
         }
         else if(msg.equals("Student Leave"))
         {
             new StudentLeave();
         }
          else if(msg.equals("Faculty Leave Details"))
         {
             new TeacherLeaveDetails();
         }
         else if(msg.equals("Student Leave Details"))
         {
             new StudentLeaveDetails();
         }
         else if(msg.equals("Update Faculty Details"))
         {
             new UpdateTeacher();
         }
         else if(msg.equals("Update Student Details"))
         {
             new UpdateStudent();
         }
         else if(msg.equals("Enter Marks"))
         {
             new EnterMarks();
         }
         else if(msg.equals("Examination Results"))
         {
             
             new ExaminationDetails();
         }
         else if(msg.equals("Fee Structure"))
         {
             new FeeStructure();
         }
         else if(msg.equals("About"))
         {
             new About();
         }
         else if(msg.equals("Student Fee Form"))
         {
             new StudentFeeForm();
         }
         
    }
        
    }
    
}
