import java.io.*;
import java.util.*;
class Main
{
	static int[] value = new int[100];
	static int[][] memo = new int[100][50001] ;
	static int num_coins=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int k=0;k<num_cases;k++)
		{
			int sum = 0;
			num_coins = Integer.parseInt(buf.readLine());

			StringTokenizer tok = new StringTokenizer(buf.readLine());
			for(int i=0;i<num_coins;i++)
				{
					value[i] = Integer.parseInt(tok.nextToken());
					sum+=value[i];
				}
			int bal = sum/2;
			for(int i=0;i<num_coins;i++)
					for(int j=0;j<=bal;j++)
					{
						if(j == 0)
							memo[i][j]=0;
						else
							memo[i][j]=-1;
					}

			ss(bal,0);
			int left=memo[0][bal];
			left =  bal-left;
			System.out.println(Math.abs(left- (sum-left)));


		}
	}
	static int ss(int bal,int curr_pos)
	{
		if(bal == 0)
			return bal;
		else if(bal < 0)
			return Integer.MAX_VALUE;
		else if(curr_pos == num_coins)
			return bal;
		else
		{
			if(memo[curr_pos][bal] != -1)
				return  memo[curr_pos][bal];

			int min = Integer.MAX_VALUE;
			for(int i=curr_pos;i<num_coins;i++)
			{
				int temp = ss(bal- value[i],i+1);
				if(temp < min)
					min = temp;
			}
			if(min > bal)
				min = bal;
			memo[curr_pos][bal] = min;
			return min;

		}

	}

}
