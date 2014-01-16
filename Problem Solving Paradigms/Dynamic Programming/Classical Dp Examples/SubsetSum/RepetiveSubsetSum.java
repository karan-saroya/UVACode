import java.io.*;
import java.util.*;
public class SS_Repetition
{
	static int value[];
	static int memo[];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(buf.readLine());
		int num_items = Integer.parseInt(buf.readLine());
		value = new int[num_items];
		memo = new int[C+1];
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<num_items;i++)
			{
				value[i] = Integer.parseInt(tok.nextToken());
			}
		for(int i=0;i<=C;i++)
			memo[i]=-1;
		memo[0] = 0;
		System.out.println(ssr(C));
	}
	static int ssr(int sum_left)
	{
		if(sum_left == 0)
			return 0;
		else if(sum_left < 0)
			return Integer.MAX_VALUE;
		else
		{
			if(memo[sum_left] != -1)
				return memo[sum_left];
			int min=Integer.MAX_VALUE;
			for(int i=0;i<value.length;i++)
			{
				int temp = ssr(sum_left - value[i]);
				if(temp < min)
					min=temp;

			}
			if(min > sum_left)
				min = sum_left;
			memo[sum_left] = min;
			return min;

		}

	}

}
