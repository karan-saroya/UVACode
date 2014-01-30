import java.io.*;
import java.util.*;
class Main
{
	static int w=0,h=0;
	static char[][] grid = new char[50][50];
	static boolean[][] visited = new boolean[50][50];
	static int[] num=new int[2500];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int cases=1;
		while(true)
		{
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			w = Integer.parseInt(tok.nextToken());
			h = Integer.parseInt(tok.nextToken());
			if(w == 0)
				break;
			for(int i=0;i<h;i++)
			{
				for(int j=0;j<w;j++)
				{
					grid[i][j] =0;
					visited[i][j]=false;

				}
			}
			for(int i=0;i<h*w;i++)
				num[i]=0;


			for(int i=0;i<h;i++)
			{
				String line=buf.readLine();
				for(int j=0;j<w;j++)
				{
					grid[i][j] =line.charAt(j);
					visited[i][j]=false;

				}
			}

			int num_comp=1;
			for(int i=0;i<h;i++)
			{
				for(int j=0;j<w;j++)
				{
					if(visited[i][j] == false && grid[i][j] != '.')
					{

							dfs(i,j,num_comp);

							num_comp++;

					}

				}
			}

			Arrays.sort(num, 1, num_comp);
			System.out.println("Throw "+cases);
			cases++;
			if(num_comp == 1)
				System.out.println(0);
			for(int i=1;i<num_comp;i++)
			{
				if(i == 1)
					System.out.print(num[i]);
				else
					System.out.print(" "+num[i]);
			}

			System.out.println("");
			System.out.println("");
		}


	}
	static void dfs(int x, int y, int comp_num)
	{
		visited[x][y] = true;

		if(grid[x][y]=='X')
			{

				num[comp_num]++;
				dfs_x(x,y,comp_num);
				visited[x][y]=true;
			}
		if(x-1 >=0 && visited[x-1][y] == false && grid[x-1][y] != '.')
		{

				dfs(x-1,y,comp_num);
		}
		if(x+1 <h && visited[x+1][y] == false&& grid[x+1][y] != '.' )
		{
				dfs(x+1,y,comp_num);
		}
		if(y-1 >=0 && visited[x][y-1] == false && grid[x][y-1] != '.' )
		{
				dfs(x,y-1,comp_num);
		}
		if(y+1 <w && visited[x][y+1] == false&& grid[x][y+1] != '.' )
		{
			dfs(x,y+1,comp_num);
		}
	}
	static void dfs_x(int x, int y,int c)
	{
		visited[x][y] = true;
		grid[x][y]='*';

		if(x-1 >=0 && visited[x-1][y] == false  )
		{
			if(grid[x-1][y] == 'X')
				dfs_x(x-1,y,c);


		}

		if(x+1 <h && visited[x+1][y] == false )
		{
			if( grid[x+1][y] == 'X')
				dfs_x(x+1,y,c);

		}
		if(y-1 >=0 && visited[x][y-1] == false  )
		{
			if(grid[x][y-1] == 'X')
				dfs_x(x,y-1,c);

		}
		if(y+1 <w && visited[x][y+1] == false )
		{
			if(grid[x][y+1] == 'X')
				dfs_x(x,y+1,c);

		}
		visited[x][y]=false;
	}

}
