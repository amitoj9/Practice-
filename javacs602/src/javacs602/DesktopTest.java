// Fig. 22.12: DesktopTest.java
package javacs602;
// Demonstrating JDesktopPane.
import javax.swing.JFrame;

public class DesktopTest 
{
   public static void main(String[] args)
   { 
      DesktopFrame desktopFrame = new DesktopFrame();  
      desktopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      desktopFrame.setSize(600, 480); 
      desktopFrame.setVisible(true); 
   } 
} // end class DesktopTest
