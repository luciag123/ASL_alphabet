import java.util.*;
import javax.swing.*;

public class ASLAlphabet
{
   private static HashMap<String, String> myDictionary;
   public ASLAlphabet()
   {
      makeDictionary();
   }
   public static void makeDictionary()
   {
      myDictionary = new HashMap<String, String>();
      for(int i = 65; i < 91; i++)
      {
         myDictionary.put((char)(i)+"", (char)(i)+".png");
      }
   }
   public static String display(String letter)
   {
      String s = myDictionary.get(letter);
      return s;
   }
}