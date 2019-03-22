import java.util.Comparator;

/**
 * @author Justin Schreiber
 * Is a Comparator to be used by the TreeMap in FileMenuHandler
 */
public class SortedDateList implements Comparator<Date212> {
   public int compare(Date212 a, Date212 b) {
      return a.compareTo(b);
   }


}
