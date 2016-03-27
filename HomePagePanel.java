import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class HomePagePanel extends JPanel
{
   private JPanel mainPanel;
   private JTextField username, password;
   public HomePagePanel()
   {
      setBackground(new Color(123,218,232));
      setLayout(new BorderLayout());
      JPanel grid = new JPanel();
      grid.setLayout(new GridLayout(3,2));
      grid.setBackground(new Color(123, 218, 232));
      /**Title of Homepage*/
      
      JPanel titlegrid = new JPanel();
      titlegrid.setLayout(new GridLayout(2, 1));
      titlegrid.setBackground(new Color(0, 150, 173));
      
      JLabel header = new JLabel("Ready to learn?");
      header.setFont(new Font("Serif", Font.BOLD, 100));
      header.setForeground(Color.WHITE);
      header.setHorizontalAlignment(SwingConstants.CENTER);
      titlegrid.add(header);
      /**Subtitle of Homepage*/
      JLabel subheader = new JLabel("Choose a game:");
      subheader.setFont(new Font("Serif", Font.ITALIC, 80));
      subheader.setForeground(Color.WHITE);
      subheader.setHorizontalAlignment(SwingConstants.CENTER);
      titlegrid.add(subheader);
      
      add(titlegrid, BorderLayout.NORTH);
      /**Login*/
      
      JPanel grid1 = new JPanel();
      grid1.setBackground(new Color(123, 218, 232));
      grid1.setLayout(new GridLayout(2, 1));
      JLabel l1 = new JLabel("Level 1");
      l1.setFont(new Font("Serif", Font.ITALIC, 100));
      l1.setForeground(Color.WHITE);
      l1.setHorizontalAlignment(SwingConstants.CENTER);
      grid1.add(l1);
      JLabel ll1 = new JLabel("Match the sign that appears to the correct letter.");
      ll1.setFont(new Font("Serif", Font.ITALIC, 30));
      ll1.setForeground(Color.WHITE);
      ll1.setHorizontalAlignment(SwingConstants.CENTER);
      grid1.add(ll1);
      grid.add(grid1);
      
      
      JButton level1 = new JButton("Play");
      level1.addActionListener(new L1());
      level1.setFont(new Font("Serif", Font.ITALIC, 100));
      level1.setForeground(Color.WHITE);
      level1.setHorizontalAlignment(SwingConstants.CENTER);
      grid.add(level1);
      
      
      JPanel grid2 = new JPanel();
      grid2.setBackground(new Color(123, 218, 232));
      grid2.setLayout(new GridLayout(2, 1));
      JLabel l2 = new JLabel("Level 2");
      l2.setFont(new Font("Serif", Font.ITALIC, 100));
      l2.setForeground(Color.WHITE);
      l2.setHorizontalAlignment(SwingConstants.CENTER);
      grid2.add(l2);
      JLabel ll2 = new JLabel("Translate the signs into a word.");
      ll2.setFont(new Font("Serif", Font.ITALIC, 30));
      ll2.setForeground(Color.WHITE);
      ll2.setHorizontalAlignment(SwingConstants.CENTER);
      grid2.add(ll2);
      grid.add(grid2);
      
      
      JButton level2 = new JButton("Play");
      level2.addActionListener(new L2());
      level2.setFont(new Font("Serif", Font.ITALIC, 100));
      level2.setForeground(Color.WHITE);
      level2.setHorizontalAlignment(SwingConstants.CENTER);
      grid.add(level2);
      
      JPanel grid3 = new JPanel();
      grid3.setBackground(new Color(123, 218, 232));
      grid3.setLayout(new GridLayout(2, 1));
      JLabel l3 = new JLabel("Level 3");
      l3.setFont(new Font("Serif", Font.ITALIC, 100));
      l3.setForeground(Color.WHITE);
      l3.setHorizontalAlignment(SwingConstants.CENTER);
      grid3.add(l3);
      JLabel ll3 = new JLabel("Name the word that corresponds to the sign.");
      ll3.setFont(new Font("Serif", Font.ITALIC, 30));
      ll3.setForeground(Color.WHITE);
      ll3.setHorizontalAlignment(SwingConstants.CENTER);
      grid3.add(ll3);
      grid.add(grid3);
      
      JButton level3 = new JButton("Play");
      level3.addActionListener(new L3());
      level3.setFont(new Font("Serif", Font.ITALIC, 100));
      level3.setForeground(Color.WHITE);
      level3.setHorizontalAlignment(SwingConstants.CENTER);
      grid.add(level3);
      
      add(grid);
   }
   private class L1 implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         JFrame frame = new JFrame("Level 1");
         frame.setSize(1500, 1000);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Level1Panel());
         frame.setVisible(true);
      }
   }
   private class L2 implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         JFrame frame = new JFrame("Level 2");
         frame.setSize(1500, 1000);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Level2Panel());
         frame.setVisible(true);
      }
   }
   private class L3 implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         JFrame frame = new JFrame("Level 3");
         frame.setSize(1500, 1000);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Level3Panel());
         frame.setVisible(true);
      }
   }
}