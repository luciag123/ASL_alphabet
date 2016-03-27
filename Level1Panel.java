import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class Level1Panel extends JPanel
{
   private JPanel mainPanel;
   private JLabel answer, sign1, score;
   private JTextField field;
   private String letter;
   private JButton check, next, back;
   private ASLAlphabet asl;
   private int count;
   public Level1Panel()
   {
      count = 0;
      setBackground(new Color(0,150,173));
      setLayout(new BorderLayout());
      /**Title of Homepage*/
      JLabel header = new JLabel("Ready to learn?");
      header.setFont(new Font("Serif", Font.BOLD, 155));
      header.setForeground(Color.WHITE);
      header.setHorizontalAlignment(SwingConstants.CENTER);
      add(header, BorderLayout.NORTH);
      
      JPanel center = new JPanel();
      center.setLayout(new FlowLayout());
      center.setBackground(new Color(123,218,232));
      add(center, BorderLayout.CENTER);
      
      JPanel south = new JPanel();
      south.setBackground(new Color(0,150,173));
      south.setLayout(new FlowLayout());
      add(south, BorderLayout.SOUTH);
   
      
      letter = (char)(Math.random()*26+65) + "";
      
      asl = new ASLAlphabet();
      sign1 = new JLabel();
             
      ImageIcon imageIcon = resizeImage(asl.display(letter));
      sign1.setIcon(imageIcon);
      center.add(sign1, BorderLayout.CENTER);
      
      JLabel imtired = new JLabel("What letter is this?");
      imtired.setFont(new Font("Serif", Font.BOLD, 50));
      south.add(imtired, BorderLayout.SOUTH);
      
      
      
      answer = new JLabel("");
      answer.setFont(new Font("Serif", Font.BOLD, 60));
      answer.setForeground(Color.GREEN);
      south.add(answer);
      
      score = new JLabel("0");
      score.setFont(new Font("Serif", Font.BOLD, 60));
      score.setForeground(Color.WHITE);
      south.add(score);
      
      field = new JTextField(20);
      south.add(field, BorderLayout.SOUTH);
      
      JPanel buttons = new JPanel();
      buttons.setLayout(new GridLayout(2,1));
      check = new JButton("Check answer");
      check.addActionListener( new checkHandler() );
      buttons.add(check);      
      
      back = new JButton("Back to home page");
      back.addActionListener(new BackListener());
      back.setVisible(false);
      buttons.add(back);
      
      south.add(buttons, BorderLayout.SOUTH);
   } 
   
   public ImageIcon resizeImage(String file)
   {
      int height, width;      
      switch(file.charAt(0))
      {
         case 'A': height = 300; width = 350; 
            break;
         case 'B': height = 300; width = 400; 
            break;
         case 'D': height = 250; width = 400; 
            break;
         case 'E': height = 300; width = 350; 
            break;
         case 'F': height = 250; width = 350; 
            break;
         case 'G': height = 450; width = 300; 
            break;
         case 'H': height = 450; width = 300; 
            break;
         case 'J': height = 350; width = 400; 
            break;
         case 'K': height = 200; width = 350; 
            break;
         case 'N': height = 350; width = 350; 
            break;
         case 'P': height = 450; width = 350; 
            break;
         case 'R': height = 250; width = 400; 
            break;
         case 'U': height = 200; width = 350;
            break;
         case 'V': height = 300; width = 450;
            break;
         case 'W': height = 200; width = 350;
            break;
         case 'Y': height = 350; width = 350;
            break;
         default: height = 300; width = 350;
            break;
      } 
      ImageIcon imageIcon = new ImageIcon(file);
      Image image = imageIcon.getImage();
      Image newimg = image.getScaledInstance(height, width,  java.awt.Image.SCALE_SMOOTH);
      imageIcon = new ImageIcon(newimg);
   
      return imageIcon;
   }
   
   public void next()
   {
      field.setText("");
      letter = (char)(Math.random()*26+65) + "";          
      sign1.setIcon(resizeImage(asl.display(letter)));
   }
   private class checkHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(field.getText().equalsIgnoreCase(letter))
         {
            count++;
            if(count<20)
            {
            answer.setForeground(Color.GREEN);
            answer.setText("Good job!");
            int current = Integer.parseInt(score.getText());
            score.setText(current+1+"");
            }
            else
            {
            answer.setForeground(Color.GREEN);
            answer.setText("Level complete!");
            int current = Integer.parseInt(score.getText());
            score.setText(current+1+"");
            check.setVisible(true);
            back.setVisible(true);
            }
         }
         else
         {
            answer.setForeground(Color.RED);
            answer.setText("Nope. That was "+letter+".");
            check.setVisible(true);
         }
         next();
      }
   } 
   private class BackListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JFrame frame = new JFrame("Learn the Alphabet in ASL!");
      frame.setSize(1500, 1000);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new ASLPanel());
      frame.setVisible(true);
      }
   }
}
