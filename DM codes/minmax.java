import java.util.*;  
class minmax{
 public static void main(String args[]){
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter the size of the Data Set: ");
   int size = sc.nextInt();
   System.out.println("Enter the values of the Data Set: ");
   float set[] = new float[size];
   for(int i = 0; i<size; i++) set[i] = sc.nextFloat();
   System.out.println("Enter the new minimum: ");
   int new_min = sc.nextInt();
   System.out.println("Enter the new maximum: ");
   int new_max = sc.nextInt();
  
   normalize(new_min, new_max, set);
 }
  // Method to find minimum value from the data set
 static float minValue(float arr[]){
   float min = arr[0];
   for(int i = 1; i<arr.length; i++)
     if(arr[i]<min) min = arr[i];
   return min;
 }
  // Method to find maximum value from the data set
 static float maxValue(float arr[]){
   float max = arr[0];
   for(int i = 1; i<arr.length; i++)
     if(arr[i]>max) max = arr[i];
   return max;
 }
  // Method to find the normalized values of the data set
 static void normalize(int new_min, int new_max, float arr[]){
   System.out.println("The Data Set after Normalization: ");
   for(int i = 0 ; i<arr.length ; i++){
     float v = ((arr[i] - minValue(arr))/(maxValue(arr) - minValue(arr)))*(new_max - new_min) + new_min;
     System.out.printf("%.3f ",v);
   }}}

