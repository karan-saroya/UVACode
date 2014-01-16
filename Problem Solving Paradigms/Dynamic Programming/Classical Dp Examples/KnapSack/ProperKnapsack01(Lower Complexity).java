import java.io.*;
import java.util.*;
class KnapSack_DP
{
	static int value[];
	static int weight[];
	static int memo[][];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_items = Integer.parseInt(buf.readLine());
		value = new int[num_items];
		weight= new int[num_items];

		int cap = Integer.parseInt(buf.readLine());
		memo = new int[num_items][cap+1];
		for(int i=0;i<num_items;i++)
			{
				StringTokenizer tok = new StringTokenizer(buf.readLine());
				weight[i] = Integer.parseInt(tok.nextToken());
				value[i] = Integer.parseInt(tok.nextToken());
				for(int j=0;j<memo[i].length;j++)
					memo[i][j] = -1;
			}
		memo[0][0] = 0;
		long start = System.currentTimeMillis();
		System.out.println(ks(cap,0));
		System.out.println((System.currentTimeMillis()- start)/1000.0);

	}
	static int ks(int cap,int curr_pos)
	{
		if(cap == 0)
			return 0;
		else if(cap < 0)
			return  Integer.MIN_VALUE;
		else if(curr_pos == value.length)
			return 0;
		else
		{
			if(memo[curr_pos][cap] != -1)
				return memo[curr_pos][cap];
			int max = Integer.MIN_VALUE;
			for(int i=curr_pos ;i<value.length;i++)
			{
				int temp = ks(cap - weight[i] , i+1);
				if( cap -weight[i] >=0 && temp+value[i] > max)
				{
					max = temp+ value[i];
				}
			}
			if(max  == Integer.MIN_VALUE)
				max= 0;
			memo[curr_pos][cap]= max;
			return max;
		}

	}

}
