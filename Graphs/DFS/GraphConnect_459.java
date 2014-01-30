import java.io.*;
import java.util.*;
class Main
{
	static boolean visited[]= new boolean[26];
	static int grid[][]= new int[26][26];
	static int size=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int i=0;i<num_cases;i++)
		{
			if(i == 0)
				buf.readLine();
			if(i!=0)
				System.out.println("");
			size = buf.readLine().charAt(0)-65+1;
			for(int j=0;j<size;j++)
			{
				visited[j]=false;
				for(int k=0;k<size;k++)
				{

						grid[j][k]=0;
				}

			}
			String line="";
			while((line = buf.readLine())!= null && !line.equals(""))
			{
				grid[line.charAt(0)-65][line.charAt(1)-65]=1;
				grid[line.charAt(1)-65][line.charAt(0)-65]=1;
			}
			int num_comp=0;
			for(int j=0;j<size;j++)
			{
				if(visited[j] == false)
					{
						dfs(j);
						num_comp++;
					}
			}

			System.out.println(num_comp);

		}

	}
	static void dfs(int curr_vertex)
	{
		visited[curr_vertex]=true;
		for(int i=0;i<size;i++)
		{
			if(grid[curr_vertex][i] == 1)
				{
					if(visited[i] == false)
						dfs(i);
				}
		}
	}

}
