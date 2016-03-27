import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.URL;
import java.net.MalformedURLException;
public class Level3Panel extends JPanel 
{
   private JLabel answer, sign1, score, imtired, spell;
   private JTextField field;
   private String word;
   private int wrongNum;
   private JButton check, next;
   private ASLAlphabet asl = new ASLAlphabet();
   private JPanel center, place;
   private JButton[] buttons = new JButton[26];
   private JLabel[] signs = new JLabel[5];
   private String[] words = {"POWER","SLEEP","TIRED","LEMON","PEACH","PLANE","KITTY","PHONE","PEPSI","HACKS","PANDA","QUACK", "TABLE", "SHOES", "HELLO", "HOUSE", "CHIPS", "SHIRT", "PANTS", "CODES"};
   private boolean[] used = new boolean[words.length];
   public Level3Panel()  throws MalformedURLException
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
      center.setLayout(new GridLayout(2,1));
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
      
      /*JLabel english = new JLabel(word);
      english.setFont(new Font("Serif", Font.BOLD, 80));
      english.setForeground(Color.WHITE);
      english.setHorizontalAlignment(SwingConstants.CENTER);
      center.add(english);*/
      
      place = new JPanel();
      place.setLayout(new GridLayout(1,5));
      place.setBackground(new Color(123,218,232));
      center.add(place);
      
      JPanel grid = new JPanel();
      grid.setLayout(new GridLayout(2,13));
      grid.setBackground(new Color(123,218,232));
      center.add(grid);
      
      int i = 65;
      for(int x = 0; x < 26; x++)
      {
         ImageIcon img = resizeImage(asl.display((char)(i)+""));
         JButton button = new JButton(img);
         button.addActionListener( new buttonHandler((char)(i)+"") );
         buttons[x] = button;
         i++;
         grid.add(button);
      }
   
      
         /*ImageIcon imageIcon = resizeImage(asl.display(words[wordNum]+""));
         JLabel temp = new JLabel("");
         temp.setIcon(imageIcon);
         signs[0] = temp;
         center.add(signs[0], BorderLayout.CENTER);*/
      
      
      imtired = new JLabel("Spell: ");
      imtired.setFont(new Font("Serif", Font.BOLD, 30));
      south.add(imtired, BorderLayout.SOUTH);     
      
      spell = new JLabel(word+ "      ");
      spell.setFont(new Font("Serif", Font.BOLD, 50));
      spell.setForeground(Color.WHITE);
      south.add(spell, BorderLayout.SOUTH);
      
      answer = new JLabel("");
      answer.setFont(new Font("Serif", Font.BOLD, 50));
      answer.setForeground(Color.GREEN);
      south.add(answer);
      
      score = new JLabel("0");
      score.setFont(new Font("Serif", Font.BOLD, 60));
      score.setForeground(Color.WHITE);
      south.add(score);
            
      check = new JButton("Check answer");
      check.addActionListener( new checkHandler() );
      south.add(check, BorderLayout.SOUTH);      
   } 
   
   private class buttonHandler implements ActionListener
   {
      private String letter;
      public buttonHandler(String s)
      {
         letter = s;
      }
      public void actionPerformed(ActionEvent e)
      {
         JLabel label = new JLabel("",20);
         ImageIcon img = resizeImage(asl.display(letter));
         label.setIcon(img);
         addTo(label);
      }
   }
   
   public void addTo(JLabel label)
   {
      place.add(label);
      place.repaint();
   }
   
   public ImageIcon resizeImage(String file)
   {
      int height, width;      
      switch(file.charAt(0))
      {
         case 'A': height = 75; width = 80; 
            break;
         case 'B': height = 75; width = 100; 
            break;
         case 'D': height = 75; width = 100; 
            break;
         case 'E': height = 75; width = 90; 
            break;
         case 'F': height = 70; width = 80; 
            break;
         case 'G': height = 105; width = 75; 
            break;
         case 'H': height = 105; width = 75; 
            break;
         case 'J': height = 90; width = 100; 
            break;
         case 'K': height = 50; width = 80; 
            break;
         case 'N': height = 80; width = 80; 
            break;
         case 'P': height = 105; width = 80; 
            break;
         case 'R': height = 60; width = 100; 
            break;
         case 'U': height = 50; width = 90;
            break;
         case 'V': height = 75; width = 105;
            break;
         case 'W': height = 50; width = 90;
            break;
         case 'Y': height = 80; width = 80;
            break;
         default: height = 75; width = 90;
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
      
              
            //signs[0].setIcon(resizeImage(asl.display(word+"")));
      }
      else
      {
         check.setVisible(false);
         for(int i = 0; i < signs.length; i++)
            signs[i].setIcon(null);
         answer.setText("Level complete!");
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
}
