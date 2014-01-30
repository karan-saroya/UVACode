import java.io.*;
import java.util.*;
class Main
{
	static int grid[][] = new int[100][100];
	static boolean visited[][] = new boolean[100][100];
	static int dim1=0,dim2=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		while(true)
		{
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			dim1 = Integer.parseInt(tok.nextToken());
			dim2 = Integer.parseInt(tok.nextToken());
			if(dim1 == 0)
				break;
			for(int i=0;i<dim1;i++)
			{
				for(int j=0;j<dim2;j++)
				{
					grid[i][j] = 0;
					visited[i][j] = false;
				}
			}

			for(int i=0;i<dim1;i++)
			{
				String temp=buf.readLine();
				for(int j=0;j<temp.length();j++)
				{
					if(temp.charAt(j) == '@')
						grid[i][j]=1;
					else
						grid[i][j]=0;
				}
			}
			int comp=0;
			for(int i=0;i<dim1;i++)
			{
				for(int j=0;j<dim2;j++)
				{
					if(grid[i][j] == 1 && visited[i][j] == false )
						{
							dfs(i,j);
							comp++;
						}
				}
			}

			System.out.println(comp);


		}
	}
	static void dfs(int x, int y)
	{
		visited[x][y] =true;
		if(x-1 >=0 && visited[x-1][y] == false && grid[x-1][y] == 1)
		{
			dfs(x-1,y);
		}
		if(x+1 <dim1 && visited[x+1][y] == false&& grid[x+1][y] == 1)
		{
			dfs(x+1,y);
		}
		if(y-1 >=0 && visited[x][y-1] == false && grid[x][y-1] == 1)
		{
			dfs(x,y-1);
		}
		if(y+1 <dim2 && visited[x][y+1] == false&& grid[x][y+1] == 1)
		{
			dfs(x,y+1);
		}
		if(x-1 >=0 && y-1 >=0&&visited[x-1][y-1] == false && grid[x-1][y-1] == 1)
		{
			dfs(x-1,y-1);
		}
		if(x-1 >=0 && y+1 <dim2&&visited[x-1][y+1] == false&& grid[x-1][y+1] == 1)
		{
			dfs(x-1,y+1);
		}
		if(x+1 < dim1 && y-1 >=0&&visited[x+1][y-1] == false&& grid[x+1][y-1] == 1)
		{
			dfs(x+1,y-1);
		}
		if(x+1 <dim1 &&y+1 <dim2 &&visited[x+1][y+1] == false&& grid[x+1][y+1] == 1)
		{
			dfs(x+1,y+1);
		}
	}

}
