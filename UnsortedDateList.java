/**
 * @author Justin Schreiber
 * Makes a Linked List of unsorted Dates by appending dates obtained from the file
 */
public class UnsortedDateList extends DateList{
   @Override
   public void add (Date212 d) {
      DateNode temp = new DateNode(d);
      this.last.next = temp;
      this.last = temp;
      this.length++;
   }

}
