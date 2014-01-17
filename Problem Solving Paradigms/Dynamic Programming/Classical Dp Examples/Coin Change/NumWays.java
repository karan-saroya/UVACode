import java.io.*;
import java.util.*;
class NumWays
{
	static int value[];
	static long memo[][];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_coins = Integer.parseInt(buf.readLine());
		int bal = Integer.parseInt(buf.readLine());
		value= new int[num_coins];
		memo = new long[num_coins][bal+1];
		memo[0][0]=1;
		for(int i=0;i<value.length;i++)
			value[i] = Integer.parseInt(buf.readLine());
		for(int i=0;i<num_coins;i++)
		{
			for(int j=0;j<=bal;j++)
				memo[i][j] = -1;
		}
		num_ways(bal,0);
		System.out.println(memo[0][bal]);
		for(int i=0;i<num_coins;i++)
		{
			for(int j=0;j<=bal;j++)
				{
					if(memo[i][j] < -1)
						System.out.println(memo[i][j]);
				}
		}


	}
	static long  num_ways(int bal, int curr_pos)
	{
		if(bal == 0)
			return 1;
		else if(bal < 0)
			return 0;
		else
		{
			if(memo[curr_pos][bal] != -1)
				return memo[curr_pos][bal];
			long ways=0;
			for(int i=curr_pos;i<value.length;i++)
			{
				ways+=num_ways(bal-value[i],i);

			}
			memo[curr_pos][bal] = ways;
			return ways;
		}

	}

}
