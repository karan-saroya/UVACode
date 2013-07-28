import java.util.*;
import java.io.*;
class Main
{
	public static void main(String args[]) throws Exception
	{


		 BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		 String line="";

		 while((line=buf.readLine())!= null && Integer.parseInt(line)!=0)
		 {
			 LinkedHashMap<String,Integer> ans= new LinkedHashMap<String,Integer>();
			 ans.put("i",0);
			 ans.put("v",0);
			 ans.put("x",0);
			 ans.put("l",0);
			 ans.put("c",0);
			 int num= Integer.parseInt(line);
			 for(int i=1;i<=num;i++)
			 {
				 int temp=i;
				 while(temp != 0)
				 {
					 if(temp <5 && temp >=1)
					 {
						 if(temp == 4)
						 {
							 ans.put("i",ans.get("i")+1);
							 ans.put("v",ans.get("v")+1);
							 temp=0;
						 }
						 else
						 {
							 ans.put("i",ans.get("i")+temp);
							 temp=0;
						 }

					 }
					 else if(temp >=5 && temp <10)
					 {
						 if(temp == 9)
						 {
							 ans.put("i",ans.get("i")+1);
							 ans.put("x",ans.get("x")+1);
							 temp=0;
						 }
						 else
						 {
							 ans.put("v",ans.get("v")+1);
							 temp=temp%5;
						 }

					 }
					 else if(temp >=10 && temp <50)
					 {
						  if(temp == 40)
						 {
							 ans.put("l",ans.get("l")+1);
							 ans.put("x",ans.get("x")+1);
							 temp=0;
						 }
						  else if(temp >40)
						  {
							  	ans.put("l",ans.get("l")+1);
								 ans.put("x",ans.get("x")+1);
								temp=temp%40;
						  }
						 else
						 {
							 ans.put("x",ans.get("x")+temp/10);
							 temp=temp%10;
						 }
					 }
					 else if(temp >=50 && temp <100)
					 {
						 if(temp == 90)
						 {
							 ans.put("c",ans.get("c")+1);
							 ans.put("x",ans.get("x")+1);
							 temp=0;
						 }
						 else if(temp >90)
						 {
							 ans.put("c",ans.get("c")+1);
							 ans.put("x",ans.get("x")+1);
							 temp=temp%90;
						 }
						 else
						 {
							 ans.put("l",ans.get("l")+temp/50);
							 temp=temp%50;
						 }
					 }
					 else
					 {
						 ans.put("c",ans.get("c")+1);
						 temp=0;
					 }
				 }

			 }

			 String print=num+": ";
			 Set set=ans.entrySet();
			 Iterator iter=set.iterator();
			 while(iter.hasNext())
			 {
				 Map.Entry<String, Integer> entry =(Map.Entry<String, Integer>)iter.next();
				 String value=""+entry.getValue();
				 print+=value+" "+entry.getKey()+", ";
			 }
			 print=print.substring(0,print.lastIndexOf(","));
			 System.out.println(print);
		 }


	}

}
