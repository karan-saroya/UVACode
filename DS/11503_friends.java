import java.io.*;
import java.util.*;
class Main
{
	static int p[];
	static int size[];
	public static void main(String[] rags) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		p = new int[100001];
		size = new int[100001];
		int num_cases=Integer.parseInt(buf.readLine());
		for(int i=1;i<=num_cases;i++)
		{
			for(int j=1;j<p.length;j++)
				make_set(j);

			int count=1;
			HashMap<String,Integer> hmap = new HashMap<String,Integer>();
			int friends=Integer.parseInt(buf.readLine());
			for(int j=1;j<=friends;j++)
			{
				String line=buf.readLine();
				StringTokenizer tok = new StringTokenizer(line);
				String name1=tok.nextToken();
				String name2= tok.nextToken();

				if(hmap.get(name1) == null)
				{
					hmap.put(name1, count);
					count++;
				}
				if(hmap.get(name2) ==  null)
				{
					hmap.put(name2, count);
					count++;

				}
				union(hmap.get(name1),hmap.get(name2));
				System.out.println(size[find(hmap.get(name1))]);


			}
		}


	}
	static void make_set(int j)
	{
		p[j]=j;
		size[j]=1;
	}
	static int find(int x)
	{

		while(p[x]!= x)
		{
			x=p[x];
		}
		return x;
	}
	static void union(int x, int y)
	{

		int par_x=find(x);
		int par_y=find(y);
		if(par_x  != par_y)
		{
			if(size[par_x] >= size[par_y])
			{
				p[par_y] =par_x;
				size[par_x]+=size[par_y];

			}
			else
			{
				p[par_x]=par_y;
				size[par_y]+=size[par_x];
			}

		}

	}
}
