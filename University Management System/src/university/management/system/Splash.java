
package university.management.system;
//awt package contains Image class 
import java.awt.Image;
import javax.swing.*;
//This Jframe class is under swing package and this swing package is under 
//Javax[java extended] package
//in Java you can achieve multithreading by either extending the Thread class or implementing the Runnable interface. 
//But here Splash class has been already extended by JFrame so the second concept should have to be used 
public class Splash  extends JFrame implements Runnable
{
    
    
    Splash()
    {
        //Image icon class is used to add image over frame so 
        //Here image is loaded from corresponding path
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT );
        i1=new ImageIcon(i2);
        JLabel image=new JLabel(i1);
        add(image);
        Thread t=new Thread(this);
        //Here new thread is starting
        t.start();
        //By default visibilty is hidden and that should be made true
        setVisible(true);
        int x=1;
        
        for(int i=2;i<=600;i+=4,x++)
        {
            setLocation(650-((x+i)/2),420-(i/2));
            setSize(i+3*x,i+x/2);
            //Making slow
            try{
                Thread.sleep(10);
            }
            catch(Exception e)
                    {
                        
                    }
        }
    }
    
    //This is a method of multi threading
    public void run()
    {
        try{
            Thread.sleep(7000);
            setVisible(false);
            //Next Frame
            new Login();
        }
        catch(Exception e)
        {
            
        }
    }
    
    public static void main(String[]args )
    {
        //It is a default object. Ehen clas object is built then construtor 
        //runs automatically
        new Splash();
    }
    
    
}
