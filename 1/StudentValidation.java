public class StudentValidation
{
     public boolean validateName(String name)
  {
        boolean t= (name!="" && name!=null)?true:false;
        if(!t)
     System.out.println("ENTER STUDENT Name is invalid");
     return t;
  }

    public boolean validateID(int id)
  {
     boolean t= (id<99999999 && id>1000000)?true:false;
     if(!t)
     System.out.println("ENTER STUDENT ID is invalid");
     return t;
  }

      public boolean validateMarks(float id)
  {
     boolean t= (id>=0.00 && id<=100.00)?true:false;
     if(!t)
     System.out.println("ENTER STUDENT Marks is invalid");
     return t;
  }

}