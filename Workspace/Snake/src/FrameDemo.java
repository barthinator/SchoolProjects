import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FrameDemo{
    public static void main(String args[]){
        JFrame myFrame = new JFrame("Sample Frame");
        myFrame.setSize(300,400);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}