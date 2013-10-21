import java.io.*;
import java.util.*;
class Main
{
	static ArrayList<Integer> grid;
	static int memo[];
	static String path[];

	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		buf.readLine();
		for(int i=1;i<=num_cases;i++)
		{
			String line="";
			grid = new ArrayList<Integer>();
			while((line = buf.readLine())!= null && !line.equals("") && line!= null)
			{
				grid.add(Integer.parseInt(line));
			}
			memo = new int[grid.size()];
			path = new String[grid.size()];
			for(int j=0;j<memo.length;j++)
				{
					memo[j]=-1;
					path[j]="";
				}
			int max=0;
			int pos=0;
			for(int j=grid.size()-1;j>=0;j--)
			{
				int temp=lis(j,grid.size()-1);
				if(temp > max)
					{
						max=temp;
						pos=j;
					}
			}
			if(i!= 1)
				System.out.println("");
			System.out.println("Max hits: "+max);
			StringTokenizer tok = new StringTokenizer(path[pos]);
			while(tok.hasMoreTokens())
				System.out.println(tok.nextToken());

		}
	}
	static int lis(int curr, int size)
	{
		if(curr == size)
		{
			if(memo[curr] == -1)
			{
				memo[curr]=1;
				path[curr] = grid.get(curr)+"";

			}
			return memo[curr];
		}
		else
		{
			if(memo[curr] != -1)
				return memo[curr];
			int max=0;
			int pos=0;
			for(int i=curr+1;i<=size;i++)
			{
				int temp= lis(i,size);
				if(temp > max && grid.get(curr) < grid.get(i))
				{
					max=temp;
					pos=i;
				}
			}

			memo[curr] = max+1;
			path[curr] = grid.get(curr)+" "+path[pos];
			return memo[curr];
		}

	}
}

