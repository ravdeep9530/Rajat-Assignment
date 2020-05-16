

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvFileReader {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	//Student attributes index
	private static final int STUDENT_ID_IDX = 0;
	private static final int STUDENT_NAME_IDX = 1; 
	private static final int STUDENT_MARKS = 2;
	
	public static List<Student> readCsvFile(String fileName) {

		BufferedReader fileReader = null;
     
        try {
        	
        	//Create a new list of student to be filled by CSV file data 
        	List<Student> students = new ArrayList<Student>();
        	
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                	//Create a new student object and fill his  data
					Student student = new Student(Long.parseLong(tokens[STUDENT_ID_IDX]), tokens[STUDENT_NAME_IDX], Float.parseFloat(tokens[STUDENT_MARKS]));
					students.add(student);
				}
            }
            
            //Print the new student list
            for (Student student : students) {
				System.out.println(student.toString());
			}
            return students;
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                return null;
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return null;

	}

}
