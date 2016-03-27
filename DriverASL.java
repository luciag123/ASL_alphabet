import javax.swing.*;
import java.awt.image.*;
public class DriverASL
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Learn the Alphabet in ASL!");
      frame.setSize(1500, 1000);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new ASLPanel());
      frame.setVisible(true);
   }
}