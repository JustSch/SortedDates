import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author Justin Schreiber Lab 1
 * This Creates the FileMenuHandler and File Chooser that will allow the user
 * to choose a txt file.  Puts contents of txt file in Linked List and TreeMap if valid
 * It Creates exceptions if a date is invalid. with edits to use setText instead of append
 *
 *
 */
public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   protected static TextFileInput inFile;
   /*
    * Receives JFrame and puts to variable
    */
   public FileMenuHandler(JFrame jf) {
      jframe = jf;
   }
   /*
    * Sets Action Performed when user clicks an item in the Menu
    */
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      if (menuName.equals("Open")) { // Implements File chooser

         openFile();

      } else if (menuName.equals("Quit"))
         System.exit(0);
   } // actionPerformed
   /*
    * Creates FileChooser so user can choose a textfile
    */
   public void openFile() {
      JFileChooser chooser;
      int status;
      FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");// sets filter so user can
                                                                                                // easily choose txt file
      chooser = new JFileChooser();
      chooser.setFileFilter(filter);
      status = chooser.showOpenDialog(null);



      if (status == JFileChooser.APPROVE_OPTION)
         readDates(chooser.getSelectedFile());
      else
         JOptionPane.showMessageDialog(null, "Open File Dialog Canceled!!");
   }//openFile()
   /*
    * Reads the text from the file and uses Try/ Catch methods to display exceptions
    * if date is invalid
    */
   public void readDates(File inFile) {
      String dateFilePath = inFile.getPath();
      TextFileInput dateFile = new TextFileInput(dateFilePath);
      String line;
      line = dateFile.readLine();
      StringTokenizer Tokens = new StringTokenizer(line, ",");
      DateList unsortedDateList = new UnsortedDateList();

      TreeMap<Date212, String> dateTreeMap = new TreeMap<>(new SortedDateList());//This creates a treeMap
                                                                                 // SortedDateList compares Date212

      while (line != null) {


         Tokens = new StringTokenizer(line, ",");
         while (Tokens.hasMoreTokens()) {

            String k = Tokens.nextToken();

            try {
               Date212 date = new Date212(k);
               unsortedDateList.add(date);
               dateTreeMap.put(date, ""); // Puts date key and empty string value in dateTreeMap


            }// try

            catch (IllegalDate212Exception e) {

               for (int i = 0; i < k.length(); i++) {
                  if (!Character.isDigit(k.charAt(i))) {
                     System.out.println(e + " Does Not Contain All Digits! Please Check Input File!");
                     break;
                  }//if
               }//for
               if (k.length() != 8) {
                  System.out.println(e + " Does Not Have A Valid Length! Please Check Input File!");
               }//if

               else if (Integer.parseInt(k.substring(4, 6)) <= 0 || Integer.parseInt(k.substring(4, 6)) > 12) {
                System.out.println(e + " Does Not Have A Valid Month! Please Check Input File!");
               }//if
               else if (Integer.parseInt(k.substring(6, 8)) <= 0 || Integer.parseInt(k.substring(6, 8)) > 31) {
                System.out.println(e + " Does Not HaveAa Valid Day! Please Check Input File!");
               }//if

            }// catch

            catch (NumberFormatException e){
               System.out.println(e +" Is Not A Valid Date!!!");
            }// catch
            catch (Exception e) {
               System.out.println(e + " Is Not A Valid Date");
            }// catch


         } // while
         line = dateFile.readLine();
      } // while

      DateGUI.dates.setText(unsortedDateList.toString()); // appends unsorted to
                                                         // dates of GUI
      for(Map.Entry me : dateTreeMap.entrySet()) {
         DateGUI.sortedDates.setText(me.getKey().toString() + "\n"); // appends keys of dateTreeMap to dates
                                                                    // of GUI
      }

   }
}
