import java.util.*;


public class Student 
{   
  int studentdID;
  String studentName,studentMajor;
  float marks;


  Student(int s1,String n1,String b1,float a1) 
  {
    studentdID=s1;studentName=n1;studentMajor=b1;marks=a1;
  }

  public void display() 
  {
    System.out.println(this.studentdID+" "+this.studentName+" "+this.studentMajor+" "+this.marks+" "+" Grade:"+this.getGrade(this.marks));
  }
  public String getGrade(float n)
  {
      if(n>=80)
        {
            return "A";
        }
        else if(n>=60 && n<80)
        {
          return "B";
        } 
        else if(n>=40 && n<60)
        {
            return "C";
        }
        else
        {
            return "D";
        }
  }
  public String toFileString()
  {
        return "";
  }

  
public static void main(String[] args) 
{
 int s;
 float m=0;
 String n,g="",k="";
 char ch;
 int num;


 Scanner ss=new Scanner(System.in);
 System.out.println("HOW MANY STUDENT");
 num=ss.nextInt();

 Student[]a=new Student[num];
 for(int i=0;i<a.length;i++) 
 {
    do{
  System.out.println("ENTER STUDENT ID OF STUEDNT"+(i+1));
  s=ss.nextInt();
}while(!new StudentValidation().validateID(s));
  //again:

  do
  {
      System.out.println("ENTER STUDENT NAME OF STUDENT"+(i+1));
  n=ss.next();
  }while(!new StudentValidation().validateName(n));
 
 do
  {
       System.out.println("ENTER STUDENT Marks OF STUDENT"+(i+1));
  m=ss.nextFloat();
  }while(!new StudentValidation().validateMarks(m));
  a[i]=new Student(s,n,k,m);
}
for (int i=0;i<a.length;i++) 
{
 a[i].display();         
}

}
}

