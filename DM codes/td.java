import java.util.*;
import java.io.*;
public class TWeight_DWeight
{
public static List<Integer> getDweight(List<Integer>l,int sum)
{
List t=new ArrayList();
for(int i=0;i<l.size();i++)
{
float f=(float)l.get(i)/sum;
t.add(String.format("%.3f",f));
}
return t;
}
public static void getTweight(List<Integer>l,List<Integer>l2)
{
List D1=new ArrayList();
List D2=new ArrayList();
int sum=0;
for(int i=0;i<l.size();i++)
{
sum=(int)l.get(i)+(int)l2.get(i);
float f=(float)((int)l.get(i))/sum;
float f1=(float)((int)l2.get(i))/sum;
D1.add(String.format("%.3f",f));
D2.add(String.format("%.3f",f1));
}
System.out.println("TweightB:\t"+D1);
System.out.println("TweightG:\t"+D2);
}
public static void main(String args[])
{
try{
Scanner sc=new Scanner(new File("TDweight.csv"));
List<Integer> Boys=new ArrayList();
List<Integer>girls=new ArrayList();
int i=0;
int sumBoy=0;int sumgirl=0;
while(sc.hasNext())
{
if(i==0)
{
sc.nextLine();
i++;
continue;
}
String s[]=(sc.nextLine()).split("\\,");
Boys.add(Integer.parseInt(s[1]));
girls.add(Integer.parseInt(s[2]));
}
int sum=Boys.stream().mapToInt(Integer::intValue).sum();
System.out.println(sum);
int sum1=girls.stream().mapToInt(Integer::intValue).sum();
System.out.println(sum1);
List dweightb=getDweight(Boys,sum);
List dweightg=getDweight(girls,sum1);
System.out.println("DweightB:\t"+dweightb);
System.out.println("DweightG:\t"+dweightg);
getTweight(Boys,girls);
}catch(Exception e){}
}
}