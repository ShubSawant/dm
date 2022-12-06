
import java.lang.*;
import java.util.*;
import java.io.*;
 class FiveNoSummary{
  public static void main(String[] args)throws Exception {
       int size;
       Scanner sc = new Scanner(new File("FiveNoSummary.csv"));
       sc.useDelimiter(",");
       ArrayList<Float> nums = new ArrayList<>();
       int k = 0;
      
       while(sc.hasNext()){

            nums.add(Float.parseFloat(sc.next()));
        
         }
       
       System.out.println();
       Collections.sort(nums);
       size = nums.size();
       System.out.println(" MAX " + nums.get(size-1));
       System.out.println(" MIN " + nums.get(0));
       
       // even values median
       if(size % 2 == 0){
            float median;
            median = even_median(nums,size," Median ");
            first_quartile(nums,size,median);
            third_quartile(nums,size,median);

         }
       // odd values median
     

  else
       {odd_median(nums,size," Median ");
       }
    }

static  float even_median(ArrayList<Float> nums, int size,String str){
        
    int x = (size/2)-1;
    int y = size/2;
    float median = (nums.get(x)+nums.get(y))/2;
    System.out.println(str + median);
    return median;

 }
static float odd_median(ArrayList<Float> nums, int size, String str){

    System.out.println(str+  nums.get(size/2));
    return nums.get(size/2);
}

static void first_quartile(ArrayList<Float> nums, int size, float median){
    ArrayList<Float> list1 = new ArrayList<>();
    int k = 0;
    while(nums.get(k++) < median){

        list1.add(nums.get(k-1));

    }

    if(list1.size() %2 == 0 ){
        float dummy;
        
       dummy= even_median(list1,list1.size()," First quartile ");

    }
    else
    { 
        float dummy;
        dummy = odd_median(list1,list1.size()," First quartile ");

    }
}




static void third_quartile(ArrayList<Float> nums, int size, float median){

    ArrayList<Float> list2 = new ArrayList<>();
    int k = size-1 ; 
    while(nums.get(k--) > median){
        list2.add(nums.get(k+1));

    }
    
 if(list2.size() %2 == 0 ){
        float dummy;
        
       dummy= even_median(list2,list2.size()," Third quartile ");

    }
    else
    { 
        float dummy;
        dummy = odd_median(list2,list2.size()," Third quartile ");

    }

}

}
