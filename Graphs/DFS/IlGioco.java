import java.io.*;
class Main
{
	static char grid[][]=  new char[200][200];
	static boolean visited[][]= new boolean[200][200];
	static int n=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int cases=1;
		while(true)
		{
				n = Integer.parseInt(buf.readLine());
				if(n==0)
					break;
				for(int i=0;i<n;i++)
				{
					String line=buf.readLine();
					for(int j=0;j<line.length();j++)
						{
							grid[i][j]= line.charAt(j);
							visited[i][j] = false;
						}
				}
				boolean found=false;
				for(int i=0;i<n;i++)
				{
					if(grid[i][n-1] =='w')
					{
						if(dfs(i,n-1) == 0)
						{
							System.out.println(cases+" W");
							found=true;
							break;
						}
					}
				}
				if(!found)
				{
					System.out.println(cases+" B");
				}
				cases++;


		}

	}
	static int dfs(int x, int y)
	{
		if(y==0)
		{
			return 0;
		}
		else
		{
			int ans=1;
			visited[x][y]=true;
			if(x-1 >=0 &&y-1 >=0 && visited[x-1][y-1] == false && grid[x-1][y-1] == 'w')
			{
				int ret= dfs(x-1,y-1);
				if(ret == 0)
					return 0;
			}
			if(x-1>=0 && visited[x-1][y] == false && grid[x-1][y] == 'w')
			{
				int ret= dfs(x-1,y);
				if(ret == 0)
					return 0;

			}
			if(y-1>=0 && visited[x][y-1] == false && grid[x][y-1] =='w')
			{
				int ret= dfs(x,y-1);
				if(ret == 0)
					return 0;

			}

			if(y+1<n && visited[x][y+1] == false && grid[x][y+1] =='w')
			{
				int ret= dfs(x,y+1);
				if(ret == 0)
					return 0;

			}
			if(x+1<n&&y+1<n && visited[x+1][y+1] == false && grid[x+1][y+1] =='w')
			{
				int ret= dfs(x+1,y+1);
				if(ret == 0)
					return 0;


			}
			if(x+1<n && visited[x+1][y] == false && grid[x+1][y] =='w')
			{
				int ret= dfs(x+1,y);
				if(ret == 0)
					return 0;

			}
			return 1;

		}

	}

}
