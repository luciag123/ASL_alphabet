import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class ASLPanel extends JPanel
{
   private JPanel mainPanel;
   private JTextField username, password;
   public ASLPanel()
   {
      setBackground(new Color(0,150,173));
      setLayout(new GridLayout(2,1));
      /**Title of Homepage*/
      JLabel header = new JLabel("Learn the Alphabet in ASL!");
      header.setFont(new Font("Serif", Font.BOLD, 100));
      header.setForeground(Color.WHITE);
      header.setHorizontalAlignment(SwingConstants.CENTER);
      add(header);
      /**Subtitle of Homepage*/
      
      JPanel south = new JPanel();
      south.setLayout(new GridLayout(2,1));
      south.setBackground(new Color(123,218,232));
      add(south);
      
      JLabel subheader = new JLabel("Master the alphabet in American Sign Language through a series of fun games.");
      subheader.setFont(new Font("Serif", Font.ITALIC, 40));
      subheader.setForeground(Color.WHITE);
      subheader.setHorizontalAlignment(SwingConstants.CENTER);
      south.add(subheader);
      
      JButton enter = new JButton("Go!");
      enter.addActionListener(new SignInListener());
      enter.setFont(new Font("Serif", Font.ITALIC, 80));
      enter.setForeground(new Color(123,218,232));
      enter.setHorizontalAlignment(SwingConstants.CENTER);
      south.add(enter);
      }
      private class SignInListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         JFrame frame = new JFrame("Choose a level");
         frame.setSize(1500, 1000);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new HomePagePanel());
         frame.setVisible(true);
      }
   }
   }
