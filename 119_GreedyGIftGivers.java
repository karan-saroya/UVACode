package GreedyGiftGivers;
import java.io.*;
import java.util.*;
class Main 
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader buf_read = new BufferedReader(new InputStreamReader(System.in));
		String temp="";
		int counter=0;
		while((temp=buf_read.readLine())!= null)
		{
			if(counter  == 0)
			{
				counter++;
			}
			else
				System.out.println("");
			int num_cases= Integer.parseInt(temp);
			temp= buf_read.readLine();
			LinkedHashMap<String,Integer> hset= new LinkedHashMap<String,Integer>();
			StringTokenizer st = new StringTokenizer(temp);
			while(st.hasMoreElements())
				hset.put(st.nextToken(),0);
			for(int i=0;i<hset.size();i++)
			{
				temp=buf_read.readLine();
				st= new StringTokenizer(temp);
				int count=0;
				String giver="";
				int amount=0;
				int people=0;
				TreeSet<String> recv= new TreeSet<String>();
				while(st.hasMoreElements())
				{
					if(count == 0)
						{
							giver=st.nextToken();
							count++;
						}
					else if(count == 1)
					{
						amount=Integer.parseInt(st.nextToken());
						count++;
					}
					else if(count == 2)
					{
						people =Integer.parseInt(st.nextToken());
						count++;
					}
					else
					{
						recv.add(st.nextToken());
					}
					
				}
				if(recv.size() != people)
				{
					people =recv.size();
				}
				int share =0;
				if(people != 0)
				{
					share=amount/people;
				}
				int prev=hset.get(giver);
				hset.put(giver,prev-share*people );
				Iterator r_iter= recv.iterator();
				
				while(r_iter.hasNext())
				{
					String rec=(String)r_iter.next();
					int orig=hset.get(rec);
					hset.put(rec,orig+share);
				}
			}
			
			Set set=hset.entrySet();
			Iterator h_iter=set.iterator();
			while(h_iter.hasNext())
			{
				Map.Entry<String, Integer> obj=(Map.Entry<String, Integer>)h_iter.next();
				System.out.println(obj.getKey()+" "+obj.getValue());
			}
		}
	}

}
