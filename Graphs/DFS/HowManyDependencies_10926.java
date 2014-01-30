import java.io.*;
import java.util.*;
class Main
{
	static boolean grid[][] = new boolean[100][100];
	static boolean visited[] = new boolean[100];
	static int num_comp[]=  new int[100];
	static int n=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			n = Integer.parseInt(buf.readLine());
			if(n == 0)
				break;
			for(int i=0;i<n;i++)
				{

					num_comp[i]=-1;
					visited[i]=false;
					for(int j=0;j<n;j++)
						grid[i][j] = false;
				}
			for(int i=0;i<n;i++)
			{
				StringTokenizer tok = new StringTokenizer(buf.readLine());
				tok.nextToken();
				while(tok.hasMoreTokens())
				{
					int col=Integer.parseInt(tok.nextToken())-1;
					if(i != col)
						grid[i][col]=true;
				}
			}
			int max=0,pos=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
					visited[j]=false;
				if(visited[i] == false)
					{
						int temp=dfs(i);
						if(temp > max)
							{
								max=temp;
								pos=i;
							}
					}
			}

			System.out.println(pos+1);

		}

	}
	static int dfs(int x)
	{

			visited[x]=true;
			int ways=0;
			for(int i=0;i<n;i++)
			{

				if(grid[x][i] == true && visited[i] == false)
				{
						ways+=dfs(i);
					}
			}
			return ways+1;

	}
}
