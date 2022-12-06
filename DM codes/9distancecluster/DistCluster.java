import java.io.*;
import java.util.*;


class DistCluster
{

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("C:\\Users\\Manoj\\OneDrive\\Desktop\\DMLab\\AFTER DIWALI\\9distancecluster\\center.csv"));
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        int i = 0;
        while(sc.hasNext()){

            String s[]=(sc.nextLine()).split("\\,");
            x.add(Integer.parseInt(s[0]));
            y.add(Integer.parseInt(s[1]));

            
        }
       
        System.out.println(x);
        System.out.println(y);

        int sumx = 0;
        int sumy = 0;
        for( i = 0 ; i < x.size();i++){

            sumx = sumx+x.get(i);
            sumy = sumy+y.get(i);

        }
        int Cx = sumx/3;
        int Cy = sumy/3;

        System.out.println("Center pts ("+Cx+","+Cy+")");

        double distance[] = new double[4];

        for( i = 0 ; i < 3 ;i++)
        {
          // distance[i]=Math.sqrt((x.get(i)-Cx * x.get(i)-Cx) + (y.get(i)-Cy * y.get(i)-Cy));
         //  System.out.println(Math.sqrt((Cx-x.get(i)) * (Cx-x.get(i))) + (Cy-y.get(i)) * (Cy)-y.get(i));
       
         distance[i] = (Math.sqrt(( Cx- x.get(i)) * (Cx - x.get(i)) + (Cy - y.get(i)) * (Cy - y.get(i))));
       


        }

        for( i = 0 ; i < 3 ; i++){

            System.out.println(String.format("%.2f",distance[i]));

        }
        System.out.println("Lower Triangular matrix ");
        //LOWER TRIANGULAR MATRIX
        double a[][] = {

                {distance[0],distance[1]},
                {distance[2],distance[3]}

        };

        int rows = 2;
        int cols = 2;


        for( i = 0; i < rows; i++){    
            for(int j = 0; j < cols; j++){    
              if(j > i)    
                System.out.print("0 ");    
              else    
                System.out.print(String.format("%.2f",a[i][j]) + " ");    
          }  
          System.out.println();      }
    }}
