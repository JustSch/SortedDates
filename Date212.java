/**
 *
 * @author Justin Schreiber
 * Get String from file and put in DateList
 * Also puts int to String in MM/DD/YYYY
 * Put the resulting String in DateGUI
 *
 *
 *
 */
public class Date212 implements Comparable<Date212>{

   private  int month;


   private  int day;



   private  int year;




/*
 * Takes the received String and uses subString to put in int month, day, year
 */
   public Date212(String date) {


      if (Project4.checkDate(date)) {
          this.year = Integer.parseInt(date.substring(0, 4));

          this.month = Integer.parseInt(date.substring(4, 6));

          this.day = Integer.parseInt(date.substring(6, 8));

      }//if
      else
         throw new IllegalDate212Exception(date); //throws exception


   }//Date212
   public Date212(int month, int day, int year) {
      this.year = year;
      this.month = month;
      this.day = day;


   }//Date212
   @Override
   public int compareTo(Date212 other) {
       if (this.year < other.year) {
           return -1;
       } else if (this.year > other.year) {
           return 1;
       }
       if (this.month < other.month) {
           return -1;
       } else if (this.month > other.month) {
           return 1;
       }
       if (this.day < other.day) {
           return -1;
       } else if (this.day > other.day) {
           return 1;
       }
       return 0;
   }


   /*
    * Creates String in MM/DD/YYYY format
    */

   public String toString() {
      String result = "";
      result += this.month < 10 ? "0" + this.month : this.month;
      result += "/" + (this.day < 10 ? "0" + this.day : this.day);
      result += "/" + this.year;
      return result;
  }//toString








}
