import java.util.*;

public class DefectEdges
{

public static void main(String[] args) throws Exception{
boolean exit=false;
		
		String fileName = "./student.csv";
		String fileName2 = "";	
		int[][] file = null;	

		
	
		
		//System.out.println("Write CSV file:");
		//CsvFileWriter.writeCsvFile(fileName);
		
		

		
		do{

 		Scanner ss=new Scanner(System.in);
			FileIO f=new FileIO();
               System.out.println("1. For kernel:\n 2.  Would  you  like  to  perform  on  (C)SV  or  (P)NG:\n 0.  Exit");
		
		switch(ss.nextInt())
{
			case 1:
			{
				System.out.println("Please  enter  the  filename  of  the  kernel:");
				fileName=ss.next();
				
				file=f.readFile(fileName);
					break;

			}
			case 2:
			{

				System.out.println("(C)SV  or  (P)NG");
				String pc= ss.next();
System.out.println(pc);
				if(pc.equals("P")){
				  System.out.println("enter  the  filename  of  the  PNG:");
				  fileName2=ss.next();
				  file=f.readPNG(fileName2);
				  f.writePNG(fileName2+"_Converted.png",file);
				  System.out.println(fileName2 +"_Converted.png");
				}
				if(pc.equals("C")){
					 System.out.println("enter  the  filename  of  the  CVS:");
				  fileName2=ss.next();
				file=f.readFile(fileName2);
				f.writeFile(file,fileName2+"_Converted.png");
				}

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
