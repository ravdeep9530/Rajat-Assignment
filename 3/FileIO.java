import  java.io.*;
import  java.awt.*;
import  java.awt.image.*;
import  javax.imageio.*;
import java.util.*;

public class FileIO
{


public  static  int[][]  readPNG(String  fileName)
{
BufferedImage  img; File  inputFile; int[][]  image  =  null;

try
{



//  Open  the  file
inputFile  =  new  File(fileName);

//  Turn  file  into  an  Image
img  =  ImageIO.read(inputFile);

//  Construct  array  to  hold  image
image  =  new  int[img.getHeight()][img.getWidth()];

//  Loop  through  each  pixel
for  (int  y  =  0;  y  <  img.getHeight();  y++)
{
for  (int  x  =  0;  x  <  img.getWidth();  x++)
{
//  Turn  the  pixel  into  a  Color  object.
Color  pixel  =  new  Color(img.getRGB(x,  y),  true);

//  Converts  each  pixel  to  a  grayscale  equivalent
//        using  weightings  on  each  colour.
image[y][x]  =  (int)((pixel.getRed()  *  0.299)  + (pixel.getBlue()  *  0.587)  + (pixel.getGreen()  *  0.114));
}
}
}
catch(IOException  e)
{
//  Alternatively  you  could  rethrow  an  IllegalArgumentException
}
return  image;
}

public  static  void  writePNG(String  fileName,  int[][]  writeArray)
{
//  The  following  is  very  Java  specific  and  is  implemented  in  a  way  to
//  reconstruct  a  colour  image  from  a  set  of  8bit  colours.
BufferedImage  theImage;
File  outputfile;
try
{

int y=0;

//  Open  the  file
outputfile  =  new  File(fileName);

//  Construct  a  BufferedImage,  with  dimensions  and  of  type  RGB
theImage  =  new  BufferedImage(writeArray[0].length, writeArray.length, BufferedImage.TYPE_INT_RGB);

//  This  will  step  through  each  element  of  our  "writeArray" for(int  y  =  0;  y  <  writeArray.length;  y++)
{
for  (int  x  =  0;  x  <  writeArray[0].length;  x++)
{
//  This  will  ensure  that  we  are  only  putting  a  value  into
//          our  png,  between  0  and  255.  (8bit  colour  depth)
int  value  =  (writeArray[y][x]  %  256);

//  Turns  the  greyscale  pixel  to  a  "colour"  representation
Color  newColor  =  new  Color(value,  value,  value);

//  This  will  set  the  value  of  the  pixel  within  the  .png
theImage.setRGB(x,  y,  newColor.getRGB());
}
}

//  Write  the  image  to  a  .png
ImageIO.write(theImage,"png",outputfile);
}
catch(IOException  e)
{
//  Alternatively  you  could  rethrow  an  IllegalArgumentException
}
}


public static int[][] readFile(String filename) throws Exception {
int[][] matrix = {{1}, {2}};

File inFile = new File(filename);
Scanner in = new Scanner(inFile);

int intLength = 0;
String[] length = in.nextLine().trim().split("\\s+");
  for (int i = 0; i < length.length; i++) {
    intLength++;
  }

in.close();

matrix = new int[intLength][intLength];
in = new Scanner(inFile);

int lineCount = 0;
while (in.hasNextLine()) {
  String[] currentLine = in.nextLine().trim().split("\\s+"); 
     for (int i = 0; i < currentLine.length; i++) {
        matrix[lineCount][i] = Integer.parseInt(currentLine[i]);    
            }
  lineCount++;
 }                                 
 return matrix;
}

public static void writeFile(int[][] board,String filename) throws IOException
{
StringBuilder builder = new StringBuilder();
for(int i = 0; i < board.length; i++)//for each row
{
   for(int j = 0; j < board.length; j++)//for each column
   {
      builder.append(board[i][j]+"");//append to the output string
      if(j < board.length - 1)//if this is not the last row element
         builder.append(",");//then add comma (if you don't like commas you can use spaces)
   }
   builder.append("\n");//append new line at the end of the row
}
BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
writer.write(builder.toString());//save the string representation of the board
writer.close();
}
	
}
