import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf  = new BufferedReader(new InputStreamReader(System.in));
		int num_cases=Integer.parseInt(buf.readLine());
		for(int i=1;i<=num_cases;i++)
		{
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int m = Integer.parseInt(tok.nextToken());
			int l = Integer.parseInt(tok.nextToken());
			TreeSet<kv> res= new TreeSet<kv>(new cust());
			for(int j=0;j<l;j++)
			{
				String read= buf.readLine();

				String name =read.substring(0,read.indexOf(":"));
				tok = new StringTokenizer(read.substring(read.indexOf(":")+1),",");

				double single = Double.parseDouble(tok.nextToken());
				double half = Double.parseDouble(tok.nextToken());
				int job= n;
				int cost=0;
				if(single == 0)
				{
					res.add(new kv(name,cost));
					continue;
				}
				else if(half == 0)
				{

					while(true)
					{
						if((job/2) >=m)
							job=job/2;
						else if(job == m)
							break;
						else if(job/2 < m)
							break;


					}
					if(job != m)
					{
						res.add(new kv(name,(int)((job-m)*single)));
					}
					else
						res.add(new kv(name,cost));
					continue;
				}
				while(job > m)
				{
					double sing_rate=single;
					double half_rate=0;
					if(job/2 >= m)
						half_rate = 2*half/job;
					else
						half_rate = Integer.MAX_VALUE;
					if(half_rate < sing_rate)
					{
						job=job/2;
						cost+=half;
					}
					else
					{
						cost+=single*(job-m);

						break;
					}

				}
				res.add(new kv(name,cost));
			}

			Iterator iter= res.iterator();
			System.out.println("Case "+i);
			while(iter.hasNext())
			{
				kv obj=(kv)iter.next();
				System.out.println(obj.name+" "+obj.cost);
			}

		}

	}

}
class kv
{
	String name;
	int cost=0;
	kv(String c_name, int c_cost)
	{
		name=c_name;
		cost=c_cost;
	}
}
class cust implements Comparator
{


	public int compare(Object arg0, Object arg1)
	{
		kv obj1 = (kv) arg0;
		kv obj2 = (kv) arg1;
		if(obj1.cost < obj2.cost)
			return -1;
		else if(obj1.cost == obj2.cost)
		{
			return obj1.name.compareTo(obj2.name);
		}
		else
		{
			return 1;
		}
	}

}

