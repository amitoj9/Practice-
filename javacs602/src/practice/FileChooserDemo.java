package practice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
 
/*
 * FileChooserDemo.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */
public class FileChooserDemo {
   
    private static File file;
    public static File getFile()
    {
    	
    	 JFrame.setDefaultLookAndFeelDecorated(true);
    	    JDialog.setDefaultLookAndFeelDecorated(true);
    	    JFrame frame = new JFrame("JComboBox Test");
    	    frame.setLayout(new FlowLayout());
    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    JButton button = new JButton("Select File");
    	    button.addActionListener(new ActionListener() {
    	      public void actionPerformed(ActionEvent ae) {
    	        JFileChooser fileChooser = new JFileChooser();
    	        int returnValue = fileChooser.showOpenDialog(null);
    	        if (returnValue == JFileChooser.APPROVE_OPTION) {
    	          File selectedFile = fileChooser.getSelectedFile();
    	          System.out.println(selectedFile.getName());
    	        }
    	      }
    	    });
    	    frame.add(button);
    	    frame.pack();
    	    frame.setVisible(true);
    	  
    	
    	return file;
    
    }
}