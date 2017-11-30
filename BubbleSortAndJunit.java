/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesortandjunit;

//import java.;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author warpe
 */
public class BubbleSortAndJunit {

    /**
     * @param args the command line arguments
     */
      public static String[] sortStringBubble( String  x [ ] )
      {
            int j;
            boolean flag = true;  // will determine when the sort is finished
            String temp;

            while ( flag )
            {
                  flag = false;
                  for ( j = 0;  j < x.length-1;  j++ )
                  {
                          if ( x[ j ].compareToIgnoreCase( x[ j+1 ] ) > 0 )
                          {                                             // ascending sort
                                      temp = x[ j ];
                                      x[ j ] = x[ j+1];     // swapping
                                      x[ j+1] = temp; 
                                      flag = true;
                           } 
                   } 
            } 
            return x;
      } 
    public static int[] bubbleSort(int [] StudentID)
    {
    
        int counter;
        boolean flag = true;
        int temp;
        
        while (flag)
        {
            flag = false;
                for( counter=0; counter < StudentID.length -1; counter++ )
                {
                    if (StudentID[counter] < StudentID[counter+1])
                    {
                    
                        temp = StudentID[ counter ];
                        StudentID[ counter ] = StudentID[ counter+1 ];
                        StudentID[ counter+1 ] = temp;
                        flag=true;
                        
                    }
                }
        }
        return StudentID;
    }
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        StudentID StudentID = new StudentID();
        int Count = -1;

//        File StudentData = new File("resources/StudentDATA.txt");
//        BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
//        String line = null;
//        StringBuilder stringBuilder = new StringBuilder();
//        try {
//            while((line = reader.readLine()) != null) {
//                
//            }
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(BubbleSortAndJunit.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally {
//            
//        }
      
 
        StudentID[] StudentInformaition = new StudentID[10];
        BufferedReader reader = new BufferedReader(new FileReader ("StudentDATA.txt"));
        String line = null;
        StringBuilder  stringBuilder = new StringBuilder(); 
        try 
        {
            while((line = reader.readLine()) != null) 
            {
                
                Count++; 
                if(Count < 10) {
                    stringBuilder.append(line);
                    String[] segment = line.split(",");
                    StudentID StudentIDInformaition = new StudentID();
                    StudentIDInformaition.StudentNumber = Integer.parseInt(segment[0]);
                    StudentIDInformaition.StudentLastName = segment[1];
                    StudentIDInformaition.StudentMiddleName = segment[2]; 
                    StudentIDInformaition.StudentFirstName = (segment[3]);
                    StudentIDInformaition.StudentCourseCost = Double.parseDouble(segment[4]);
                    StudentIDInformaition.StudentAge = Integer.parseInt(segment[5]);
                    StudentIDInformaition.StudentGender = (segment[6]);
                    StudentIDInformaition.StudentEnjoysJava = Boolean.parseBoolean(segment[7]);
                    StudentIDInformaition.StundentCourse = Boolean.parseBoolean(segment[8]);
                    StudentIDInformaition.StudentPayment = (segment[9]);  
                    StudentInformaition[Count] = StudentIDInformaition;
                    //System.out.println(StudentInformaition[Count].StudentNumber);
                }
            }
        //change the name of studentid for the array is confusing
        //System.out.println(studentid2[1]);
        int[] StudentNumberArray = new int[10];
        String[] StudentNameArray = new String[10];
        for(int i=0;i<10;i++)
            {
                StudentNumberArray[i] = StudentInformaition[i].StudentNumber;
            }
        for(int i=0;i<10;i++) {
            StudentNameArray[i] = StudentInformaition[i].StudentMiddleName;
        }
        int[] BubbleSorted = bubbleSort(StudentNumberArray);
        PrintWriter SortedInt = new PrintWriter("SortedIntFile.txt");
        String[] BubbleSortedString = sortStringBubble(StudentNameArray);
        PrintWriter SortedString = new PrintWriter("SortedStringFile.txt");
        for(int i=0;i<10;i++) {
            System.out.println(BubbleSorted[i]);
            SortedInt.println((int)BubbleSorted[i]);
        }
        SortedInt.close();
        
        for(int i=0;i<10;i++) {
            System.out.println(BubbleSortedString[i]);
            SortedString.println(BubbleSortedString[i]);
        }
        SortedString.close();
        } 
        finally 
        {
            reader.close();
        }    
    }
    
}
