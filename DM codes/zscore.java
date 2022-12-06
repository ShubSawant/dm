import java.io.*;
import java.util.*;

public class zscore
{
       public static void main(String args[])
       {      
               double mean = 0.0;
               double sum = 0.0;
               double sd = 0.0;

               Scanner sc = new Scanner(System.in);
               System.out.println("Enter dataset size");
               int n = sc.nextInt();
               int[] myarr = new int[n];
               System.out.println("Enter values ");
               for(int i = 0 ; i < n ; i++){

                       myarr[i] =  sc.nextInt();

                      
                       sum = sum + myarr[i];

               }
               // mean calculation
               mean = sum/n;






               // Standard Deviation calculation
               sum = 0.0;
               for(int i = 0 ; i < n ; i++){

                       sum = sum + Math.pow(myarr[i]-mean, 2);

               }

               sd = Math.sqrt(sum/4);


               // Z-Score Calculation

               for(int i = 0 ; i < n ; i++){

                       System.out.println("Z Score for "+ myarr[i] + " : " + String.format("%.2f",((myarr[i]-mean)/sd)));

               }



              
       }
}











