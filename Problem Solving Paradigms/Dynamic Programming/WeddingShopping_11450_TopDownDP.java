import java.io.*;
import java.util.*;
 class Main
{
	static int grid[][];
	static int memo[][];
	static int num_gar;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		grid = new int[20][];
		memo= new int[201][20];

		for(int j=1;j<=num_cases;j++)
		{
			for(int i=0;i<memo.length;i++)
			{
				for(int k=0;k<memo[i].length;k++)
					memo[i][k]=-1;
			}
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			int m = Integer.parseInt(tok.nextToken());
			int c= Integer.parseInt(tok.nextToken());
			num_gar=c;
			min=Integer.MAX_VALUE;
			for(int i=0;i<c;i++)
			{
				tok = new StringTokenizer(buf.readLine());
				int size = Integer.parseInt(tok.nextToken());
				grid[i]= new int[size];
				for(int k=0;k<size;k++)
				{
					grid[i][k]=Integer.parseInt(tok.nextToken());

				}
			}
			wed_shop(m,0);
			if(min == Integer.MAX_VALUE)
			{
				System.out.println("no solution");
			}
			else
			{
				System.out.println(m-min);
			}



		}
	}
	static int wed_shop( int money_left,int curr_gar)
	{
		if(curr_gar == num_gar)
		{
			if(money_left < min && money_left >=0)
			{
				min=money_left;
				return money_left;
			}
			else
				return Integer.MAX_VALUE;


		}
		else if(money_left==0 || money_left <0 )
				{

					return Integer.MAX_VALUE;
				}

		else
		{
			if(memo[money_left][curr_gar] != -1)
				{
					return memo[money_left][curr_gar];

				}
			int ret=Integer.MAX_VALUE;
			for(int i=0;i<grid[curr_gar].length;i++)
			{
				 ret=wed_shop(money_left-grid[curr_gar][i],curr_gar+1);
				if(ret < min && ret >=0)
					min=ret;
			}
			memo[money_left][curr_gar]=ret;
			return memo[money_left][curr_gar];

		}



	}

}
