import java.awt.*;

import javax.swing.*;

/**
 *
 * @author Justin Schreiber Reads dates from a file and displays them
 *         sorted and unsorted. This part makes the GUI.
 *
 */
public class DateGUI extends JFrame {

   static Container cPane;
   static TextArea dates, sortedDates;

   /*
    * create GUI that will display dates
    */
   public DateGUI() {
      initialize();
      setLayout(new GridLayout(1, 2));
      setTitle("Dates and Sorted Dates");
      cPane = getContentPane();
      cPane.add(dates);
      cPane.add(sortedDates);
      setVisible(true);
   }// createGUI
   /*
    * Initializes values for GUI
    */
   public void initialize() {

      dates = new TextArea();
      dates.setEditable(false); // the user will be unable to edit the values in
                                // the GUI  (Cause it annoyed me)
      sortedDates = new TextArea();
      sortedDates.setEditable(false); // the user will be unable to edit the
                                      // files in the GUI (Cause it annoyed me)

      setSize(400, 400);
      setLocation(200, 200);
      createMenu();
      setTitle("");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }// initialize
   /*
    * Creates Menu to put in GUI
    */
   private void createMenu() {
      JMenuItem item;
      JMenuBar menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");

      FileMenuHandler fmh = new FileMenuHandler(this);

      item = new JMenuItem("Open");
      item.addActionListener(fmh);
      fileMenu.add(item);

      fileMenu.addSeparator();

      item = new JMenuItem("Quit");
      item.addActionListener(fmh);
      fileMenu.add(item);

      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
   }

}
