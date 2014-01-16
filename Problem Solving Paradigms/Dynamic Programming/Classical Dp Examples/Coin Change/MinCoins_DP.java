import java.io.*;
import java.util.*;
class MinCoins_DP
{
	static int value[];
	static int memo[];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_items = Integer.parseInt(buf.readLine());
		value = new int[num_items];
		int bal = Integer.parseInt(buf.readLine());
		memo = new int[bal+1];
		for(int i=0;i<memo.length;i++)
			 memo[i]=-1;
		memo[0]=0;
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<value.length;i++)
			value[i] = Integer.parseInt(tok.nextToken());
		System.out.println(MinCoins(bal));


	}
	static int MinCoins(int bal)
	{
		if(bal == 0)
			return 0;
		else if(bal < 0)
			return Integer.MAX_VALUE;
		else
		{
			if(memo[bal] != -1)
				return memo[bal];
			int min = Integer.MAX_VALUE;
			for(int i=0;i<value.length;i++)
			{
				int temp = MinCoins(bal-value[i]);
				if(temp < min)
					min=temp;
			}

			if(min != Integer.MAX_VALUE)
				min++;
			memo[bal] = min;
			return min;
		}

	}


}
