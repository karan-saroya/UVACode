import java.io.*;
import java.util.*;
class Main
{
	static int grid[][];
	static int memo[][];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int k=0;k<num_cases;k++)
		{
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			String name = tok.nextToken();
			int rows = Integer.parseInt(tok.nextToken());
			int cols = Integer.parseInt(tok.nextToken());
			grid = new int[rows][cols];
			memo = new int[rows][cols];
			for(int i=0;i<rows;i++)
			{
				tok = new StringTokenizer(buf.readLine());
				for(int j=0;j<cols;j++)
					{
						grid[i][j] = Integer.parseInt(tok.nextToken());
						memo[i][j] = -1;
					}
			}
			int max=0;
			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					int temp=ls(i,j);
					if(temp > max)
						max=temp;
				}
			}
			System.out.println(name+": "+max);
		}

	}
	static int ls(int curr_x, int curr_y)
	{
		if(curr_x >= grid.length || curr_x < 0 || curr_y >= grid[0].length || curr_y < 0 )
			return 0;
		else
		{
			if(memo[curr_x][curr_y] != -1)
				return memo[curr_x][curr_y];
			int max=0;
			int temp=0;
			if(curr_x -1 < grid.length && curr_x-1 >=0  && curr_y < grid[0].length && curr_y >= 0  && grid[curr_x][curr_y] > grid[curr_x-1][curr_y])
				{

					temp=ls(curr_x-1,curr_y);
					if(temp > max)
						max=temp;
				}
			if(curr_x +1 < grid.length && curr_x + 1>=0  && curr_y < grid[0].length && curr_y >= 0  && grid[curr_x][curr_y] > grid[curr_x+1][curr_y])
			{
				temp=ls(curr_x+1,curr_y);
				if(temp > max)
					max=temp;
			}

			if(curr_x  < grid.length && curr_x >=0  && curr_y +1 < grid[0].length && curr_y +1 >= 0  && grid[curr_x][curr_y] > grid[curr_x][curr_y + 1])
			{
				temp=ls(curr_x,curr_y + 1);
				if(temp > max)
					max=temp;
			}

			if(curr_x  < grid.length && curr_x >=0  && curr_y - 1< grid[0].length && curr_y -1  >= 0  && grid[curr_x][curr_y] > grid[curr_x][curr_y-1])
			{
				temp=ls(curr_x,curr_y-1);
				if(temp > max)
					max=temp;
			}

			max++;
			memo[curr_x][curr_y] = max;
			return max;
		}
	}
}