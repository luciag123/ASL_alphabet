import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class Level2Panel extends JPanel
{
   private JLabel answer, sign1, score, imtired;
   private JTextField field;
   private String word;
   private int wrongNum;
   private JButton check, next, back;
   private ASLAlphabet asl;
   private JPanel center;
   private JLabel[] signs = new JLabel[5];
   private String[] words = {"POWER","SLEEP","TIRED","LEMON","PEACH","PLANE","KITTY","PHONE","PEPSI","HACKS","PANDA","QUACK", "TABLE", "SHOES", "HELLO", "HOUSE", "CHIPS", "SHIRT", "PANTS", "CODES"};
   private boolean[] used = new boolean[words.length];
   public Level2Panel()
   {
      setBackground(new Color(0,150,173));
      setLayout(new BorderLayout());
      /**Title of Homepage*/
      JLabel header = new JLabel("Ready to learn?");
      header.setFont(new Font("Serif", Font.BOLD, 155));
      header.setForeground(Color.WHITE);
      header.setHorizontalAlignment(SwingConstants.CENTER);
      add(header, BorderLayout.NORTH);
      
      center = new JPanel();
      center.setLayout(new GridLayout(1,5));
      center.setBackground(new Color(123,218,232));
      add(center, BorderLayout.CENTER);
      
      JPanel south = new JPanel();
      south.setBackground(new Color(0,150,173));
      south.setLayout(new FlowLayout());
      add(south, BorderLayout.SOUTH);
         
      for(int j = 0; j < used.length; j++)
         used[j] = false;   
         
      asl = new ASLAlphabet();
      int wordNum = (int)(Math.random()*words.length);
      word =  words[wordNum];
      wrongNum = wordNum;
      used[wordNum] = true;
      
      for(int i = 0; i < word.length(); i++)
      {
         ImageIcon imageIcon = resizeImage(asl.display(words[wordNum].charAt(i)+""));
         JLabel temp = new JLabel("");
         temp.setIcon(imageIcon);
         signs[i] = temp;
         center.add(signs[i], BorderLayout.CENTER);
      }
      
      imtired = new JLabel("What word is this?");
      imtired.setFont(new Font("Serif", Font.BOLD, 30));
      south.add(imtired, BorderLayout.SOUTH);     
      
      answer = new JLabel("");
      answer.setFont(new Font("Serif", Font.BOLD, 30));
      answer.setForeground(Color.GREEN);
      south.add(answer);
      
      score = new JLabel("0");
      score.setFont(new Font("Serif", Font.BOLD, 60));
      score.setForeground(Color.WHITE);
      south.add(score);
      
      field = new JTextField(20);
      south.add(field, BorderLayout.SOUTH);
      
      JPanel grid = new JPanel();
      grid.setLayout(new GridLayout(2, 1));
      
      check = new JButton("Check answer");
      check.addActionListener( new checkHandler() );
      grid.add(check);  
      
      back = new JButton("Back to home page");
      back.addActionListener(new BackListener());
      back.setVisible(false);
      grid.add(back);    
      
      south.add(grid, BorderLayout.SOUTH);
   } 
   
   public ImageIcon resizeImage(String file)
   {
      int height, width;      
      switch(file.charAt(0))
      {
         case 'A': height = 150; width = 175; 
            break;
         case 'B': height = 150; width = 200; 
            break;
         case 'D': height = 125; width = 200; 
            break;
         case 'E': height = 150; width = 175; 
            break;
         case 'F': height = 125; width = 175; 
            break;
         case 'G': height = 225; width = 150; 
            break;
         case 'H': height = 225; width = 150; 
            break;
         case 'J': height = 175; width = 200; 
            break;
         case 'K': height = 100; width = 175; 
            break;
         case 'N': height = 175; width = 175; 
            break;
         case 'P': height = 225; width = 175; 
            break;
         case 'R': height = 125; width = 200; 
            break;
         case 'U': height = 100; width = 175;
            break;
         case 'V': height = 150; width = 225;
            break;
         case 'W': height = 100; width = 175;
            break;
         case 'Y': height = 175; width = 175;
            break;
         default: height = 150; width = 175;
            break;
      } 
      ImageIcon imageIcon = new ImageIcon(file);
      Image image = imageIcon.getImage();
      Image newimg = image.getScaledInstance(height, width,  java.awt.Image.SCALE_SMOOTH);
      imageIcon = new ImageIcon(newimg);
   
      return imageIcon;
   }
   
   public void next(boolean correct)
   {
      if(correct == false)
         used[wrongNum] = false;
      boolean done = true;
      for(boolean x: used)
      {
         if(x == false)
            done = false;
      }
      if(done == false)
      {
         field.setText("");
         int num = (int)(Math.random()*words.length);
         while(used[num] == true)
            num = (int)(Math.random()*words.length);
         word = words[num];
         wrongNum = num;
         used[num] = true;
      
         for(int i = 0; i < word.length(); i++)        
            signs[i].setIcon(resizeImage(asl.display(word.charAt(i)+"")));
      }
      else
      {
         check.setVisible(false);
         for(int i = 0; i < signs.length; i++)
            signs[i].setIcon(null);
         answer.setText("Level complete!");
         back.setVisible(true);
         imtired.setText("");
      }
   }
   private class checkHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(field.getText().equalsIgnoreCase(word))
         {
            answer.setForeground(Color.GREEN);
            answer.setText("Good job!");
            int current = Integer.parseInt(score.getText());
            score.setText(current+1+"");
            next(true);
         }
         else
         {
            answer.setForeground(Color.RED);
            answer.setText("Nope :( It was "+word+".");
            next(false);
         }
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
