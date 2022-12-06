import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
class GiniIndex {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("ginni1.csv"));
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        String[] dt = br.readLine().trim().split(",");
       
       
        int n=dt.length;
        while (true) {
            String str[] = new String[n];
            try {
                str = br.readLine().trim().split(",");
        
            } catch (NullPointerException e) {
                break;
            }
            ArrayList<String> temp = new ArrayList<>();
            for (String s : str)
                temp.add(s);
                
            data.add(temp);
           
            

        }
       // System.out.println(data);
        int C0 = 0, C1 = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).get(4).equals("C0"))  C0++;
            else
                C1++;
        }
        System.out.println("Total Possiblity of C0 : "+C0  +  "  Total Possiblity of C1 : "+C1);
        double totRecord = data.size();
        double GineIndex = 1.0-Math.pow((C0 / totRecord),2)  - Math.pow( (C1 / totRecord),2)  ;
        System.out.println("Gine Index of C0 :"+GineIndex);
        System.out.println("=========================================================");
        for(int i=1;i<data.get(0).size()-1;i++){
            System.out.println("GineIndex Of "+ dt[i]+" :"+ String.format("%.5f",findAllGineIndex(i,GineIndex,data,dt)));
            System.out.println("=========================================================");
        }
    }

    private static double findAllGineIndex(int i, double GineIndex, ArrayList<ArrayList<String>> data, String[] dt) {
        Set<String> attribute=new HashSet<>();
        for(ArrayList<String>x:data)
            attribute.add(x.get(i));
        Map<String,double[]>total=new HashMap<>();
        for(String x:attribute){
            total.put(x,new double[2]);


        }
        Iterator<String> ii=attribute.iterator();  
        while(ii.hasNext())  
        {  
        System.out.println(ii.next());  
        }  
        for(ArrayList<String> x:data){
            //System.out.println("+++"+x);
            if(x.get(4).equals(("C0")))
                total.get(x.get(i))[0]++;
            else
                total.get(x.get(i))[1]++;

        }
        double totalE=0.0;
        System.out.println("Count Table for  :"+dt[i]);
        System.out.println(dt[i]+" C0   C1 ");
        for(Map.Entry<String,double[]> x:total.entrySet()){
            double total1=x.getValue()[0]+x.getValue()[1];
            System.out.println(x.getKey()+"  "+x.getValue()[0]+"  "+x.getValue()[1]);
            if(x.getValue()[0]==0||x.getValue()[1]==0)
                continue;
            double temp= 1-Math.pow((x.getValue()[0] / total1),2) - Math.pow((x.getValue()[1]/ total1),2);
            //System.out.println(temp);
            totalE+=(total1/ data.size())*temp;


        }

       // double finalE=GineIndex-totalE;
        return (totalE);
    }


}
