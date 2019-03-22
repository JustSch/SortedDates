/**
 * @author Justin Schreiber
 * Makes a Linked List using the Dates obtained from the file
 */
public abstract class  DateList {

   protected DateNode first = new DateNode(null);

   protected DateNode last = first;

   protected int length = 0;

   public int getLength() {
      return length;
   }// getLength
   /*
    * Creates empty abstract add to be overrided by sorted and unsorted Datelists
    */
   public abstract void add(Date212 d);


   /*
    * Puts DateList to String to put in GUI
    *
    */
   public String toString() {
      DateNode p = this.first.next;
      String returnString = "";
      while (p != null) {
         returnString += p.dates.toString() + "\n";// makes into String
         p = p.next;
      } // while
      return returnString;
   }// toString



}
