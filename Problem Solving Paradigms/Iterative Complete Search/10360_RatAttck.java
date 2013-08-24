import java.io.*;
import java.util.*;
class Main
{
	static int grid[][];
	public static void main(String[] args) throws Exception
	{

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		grid = new int[1025][1025];
		for(int i=0;i<num_cases;i++)
		{
			for(int j=0;j<grid.length;j++)
			{
				for(int k=0;k<grid[j].length;k++)
					grid[j][k]=0;
			}
			int d=Integer.parseInt(buf.readLine());
			HashMap<String,Integer> hmap = new HashMap<String,Integer>();
			int n = Integer.parseInt(buf.readLine());
			for(int j=0;j<n;j++)
			{
				StringTokenizer tok = new StringTokenizer(buf.readLine());
				hmap.put(tok.nextToken() +" "+tok.nextToken(),Integer.parseInt(tok.nextToken()));
			}

			Set set = hmap.entrySet();
			Iterator iter=set.iterator();
			while(iter.hasNext())
			{
				Map.Entry<String, Integer> entry = (Map.Entry<String,Integer>) iter.next();
				StringTokenizer tok = new StringTokenizer(entry.getKey());
				int x=Integer.parseInt(tok.nextToken());
				int y = Integer.parseInt(tok.nextToken());
				int pop = entry.getValue();

				for(int j=x-d;j<=x+d;j++)
				{
					for(int k=y-d;k<=y+d;k++)
					{
							if(j <= 1024  && k <=1024  && j>=0 && k>=0)
							{
								grid[j][k]+=pop;
							}


					}
				}


			}


			int max=0;
			int x=0,y=0;
			for(int j=0;j<grid.length;j++)
			{
				for(int k=0;k<grid[j].length;k++)
				{
					if(grid[j][k] > max)
						{
							x=j;
							y=k;
							max=grid[j][k];
						}
				}
			}
			System.out.println(x+" "+y+" "+max);

		}
	}

}
