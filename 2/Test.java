import java.util.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
boolean exit=false;
		
		String fileName = "./student.csv";
		
		List<Student> students;
		
		//System.out.println("Write CSV file:");
		//CsvFileWriter.writeCsvFile(fileName);
		
		

		
		do{

 		Scanner ss=new Scanner(System.in);

               System.out.println("1.  Import  Student’s\n2.  Calculate  assessment  average\n3.  View  all  Student’s\n0.  Exit");
		
		switch(ss.nextInt())
{
			case 1:
			{
				System.out.println("\nRead CSV file:");
				CsvFileReader.readCsvFile(fileName);
					break;

			}
			case 2:
			{
				students=CsvFileReader.readCsvFile(fileName);
				for (Student student : students) {
				System.out.println(student.toString());
			}
					break;
			}
			case 3:
			{
				System.out.println("\nRead CSV file:");
				CsvFileReader.readCsvFile(fileName);
					break;
			}
			case 0:
			{
				exit=true;
					break;
			}
			

}

}while(!exit);

	}

}
