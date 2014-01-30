import java.io.*;
import java.util.*;
class Main
{
	static int grid[][] = new int[25][25];
	static boolean visited[][] = new boolean[25][25];
	static int dim=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		 int cases=1;
		while((line = buf.readLine())!= null && !(line.equals("")))
		{
			dim = Integer.parseInt(line);
			if(dim == 0)
				continue;
			for(int i=0;i<dim;i++)
			{
				for(int j=0;j<dim;j++)
				{
					grid[i][j] = 0;
					visited[i][j] = false;
				}
			}

			for(int i=0;i<dim;i++)
			{
				String temp=buf.readLine();
				for(int j=0;j<temp.length();j++)
				{
					grid[i][j] = temp.charAt(j)-48;
				}
			}
			int comp=0;
			for(int i=0;i<dim;i++)
			{
				for(int j=0;j<dim;j++)
				{
					if(grid[i][j] == 1 && visited[i][j] == false )
						{
							dfs(i,j);
							comp++;
						}
				}
			}

			System.out.println("Image number "+(cases)+" contains "+comp+" war eagles.");
			cases++;

		}
	}
	static void dfs(int x, int y)
	{
		visited[x][y] =true;
		if(x-1 >=0 && visited[x-1][y] == false && grid[x-1][y] == 1)
		{
			dfs(x-1,y);
		}
		if(x+1 <dim && visited[x+1][y] == false&& grid[x+1][y] == 1)
		{
			dfs(x+1,y);
		}
		if(y-1 >=0 && visited[x][y-1] == false && grid[x][y-1] == 1)
		{
			dfs(x,y-1);
		}
		if(y+1 <dim && visited[x][y+1] == false&& grid[x][y+1] == 1)
		{
			dfs(x,y+1);
		}
		if(x-1 >=0 && y-1 >=0&&visited[x-1][y-1] == false && grid[x-1][y-1] == 1)
		{
			dfs(x-1,y-1);
		}
		if(x-1 >=0 && y+1 <dim&&visited[x-1][y+1] == false&& grid[x-1][y+1] == 1)
		{
			dfs(x-1,y+1);
		}
		if(x+1 < dim && y-1 >=0&&visited[x+1][y-1] == false&& grid[x+1][y-1] == 1)
		{
			dfs(x+1,y-1);
		}
		if(x+1 <dim &&y+1 <dim &&visited[x+1][y+1] == false&& grid[x+1][y+1] == 1)
		{
			dfs(x+1,y+1);
		}
	}

}
