//This class will connect this application with Database 
//through JDBC API 
package university.management.system;
import java.sql.*;
public class Conn {

       //Creating connection string
       Connection c;
       String Url = "jdbc:mysql://localhost:3306/university_management_system";
       //Statement is used to ececute mysql query
       Statement s;
    Conn() {
        //Here as database is an external entity so there could be any exception
        try {
            //loading the driver class from corresponding 
            // packages com.mysql.cj.jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");
            //mention every info of database that will be cx
            //connected
            c = DriverManager.getConnection(Url,"root","");
            s=c.createStatement();
        
        } catch (Exception e) {

            /*
            The printStackTrace() method is a part of the Throwable class in Java,
            which is the superclass of all errors and exceptions in the Java language.
            When an exception occurs and the printStackTrace() method is called, it prints 
            a detailed description of the stack trace to the standard error stream. 
            The stack trace includes information about the sequence of method calls 
            that led to the exception being thrown.
             */
            //Here, e is an instance of the Exception class or one of its subclasses.
            //e.printStackTrace() to print the stack trace of the exception object e.
            /*
            A stack trace is a report that provides information about the active stack 
            frames at the time of an exceptional condition, such as an error or an exception, 
            in a software program. The stack frames represent the sequence of method calls that
            were active at the point when the exceptional condition occurred.
            */
            
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        new Conn();
    }

}
