
/**
    * @author Justin Schreiber
    * This will read dates from file and call Date212 to make int value and String and check for validity
    * The program will then put them in an unsorted Linked list and a treeMap
    * Both will then be put in a GUI and display it
    * The user will choose a file from the open option in the file menu
    *
    *
    */
public class sortedDates {


   protected static DateGUI dateGUI;
   /*
    *initializes createGUI on DateGUI and initializes readTheDates
    *Also opens specified file
    */
   public static void main(String[] args) {

      dateGUI = new DateGUI();


   }//main




   /*
    * Checks if line is a valid date
    *
    */
    public static boolean checkDate(String s) {

       if (s.length() != 8) {

          return (false);
       }//if
       for (int i = 0; i < s.length(); i++)
          if (!Character.isDigit(s.charAt(i))) {

             return (false);
          }//if
       int month = Integer.parseInt(s.substring(4, 6));
       if (month <= 0 || month > 12) {

          return (false);
       }//if
       int day = Integer.parseInt(s.substring(6, 8));
       if (day <= 0 || day > 31) {

          return (false);
       }//if
          return true;
    }// checkDate

}//sortedDates
