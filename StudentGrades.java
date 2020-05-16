
import java.util.Scanner;

/**
 * StudentGrades class
 *
 * Keeps data on students.
 * Allows functionality to compute average of all student grades. 
 * Allows searching for grade given name.
 * Can display all the students, or only students with grades above the average.
 * Can display all the students with grades above the avg.
 */

public class StudentGrades {

   private static final int MAXSIZE = 100;   // maximum number of students
   private Student theStudents[];            // collection of student objects
   private int avg;                          // average of all student grades
   private int size;                         // actual number of students
   private boolean avgUpToDate;       // whether to update avg (students added)

   /**-----------------------------------------------------------------------
    * constructor
    * Takes no parameters, initializes class vars
    */
   public StudentGrades() {
      // allocate memory for Student class variable
      theStudents = new Student[MAXSIZE];
      for (int i = 0; i < MAXSIZE; i++) {
          theStudents[i] = null;
      }
      avg = 0;
      size = 0;
      avgUpToDate = true;
   }

   /**-----------------------------------------------------------------------
    * setData
    * Fill object with data from given data file,
    */
   public void setData(Scanner file) {
      boolean eof = false;
      while (size < MAXSIZE && !eof) {
         theStudents[size] = new Student();
         eof = theStudents[size].setData(file); 
         if (!eof) {
            size++;
         }
      }
      avgUpToDate = false;
   }

   /**-----------------------------------------------------------------------
    * insert
    * insert student into collection 
    */
   public void insert(Student oneStudent) {
      if (oneStudent != null && size < MAXSIZE) {
         theStudents[size] = oneStudent;
         size++;
         avgUpToDate = false;
      }
   }

   /**-----------------------------------------------------------------------
    * displayValid
    * Display all the valid student data
    */
   public void displayValid() {
      for (int i = 0; i < size; i++) {
         if (theStudents[i].getGrade() >= 0) {
            System.out.println(theStudents[i]);
         }
      }
   }

   /**-----------------------------------------------------------------------
    * displayAll
    * Display all student data
    */
   public void displayAll() {
      for (int i = 0; i < size; i++) {
         System.out.println(theStudents[i]);
      }
   }

   /**-----------------------------------------------------------------------
    * computeAvg
    * Computes an integer average of student grades
    */
   private void computeAvg() {
      int sum = 0, count = 0;
      for (int i = 0; i < size; i++) {
         if (theStudents[i].getGrade() >= 0) {
            sum += theStudents[i].getGrade();
            count++;
         }
      }

      // avg is zero if there are no students stored
      avg = (count != 0 ?  sum/count : 0);

      avgUpToDate = true;
   }

   /**-----------------------------------------------------------------------
    * getAvg
    * Returns average of all the students
    */
   public int getAvg() {
      // if new students have been added, then need to compute updated avg
      if (!avgUpToDate) {  
         computeAvg();      
      }
      return avg;
   }

   /**-----------------------------------------------------------------------
    * displayHighGrades
    * Displays grades of all students who got higher than the average
    */
   public void displayHighGrades() {
      // if new students have been added, then need to compute updated avg
      if (!avgUpToDate) {  
         computeAvg();      
      }

      System.out.println();
      System.out.println("All students with grades higher than the average:");
      for (int i = 0; i < size; i++) {
         if (theStudents[i].getGrade() > avg) {
            System.out.println(theStudents[i]);
         }
      }
   }

   /**-----------------------------------------------------------------------
    * getGrade 
    * Given a name, find their grade.
    * If the name is not found, return -99.
    */
    public int getGrade(String oneName) {
      for (int i = 0; i < size; i++) {
         if (oneName.equals(theStudents[i].getName())) {
            return theStudents[i].getGrade();
         }
      }
      return -99;
    }
}

