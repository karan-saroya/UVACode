import java.io.*;
import java.util.*;
public class MinJumps
{
	static int arr[];
	static int memo[];
	static int items=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		items = Integer.parseInt(buf.readLine());
		memo = new int[items];
		arr = new int[items];
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<memo.length;i++)
			{
				memo[i]=-1;
				arr[i] = Integer.parseInt(tok.nextToken());
			}

		long start = System.currentTimeMillis();
		int ans=MinJumps(0);
		if(ans == Integer.MAX_VALUE)
			System.out.println("Not reachable");
		else
			System.out.println(ans);
		System.out.println((System.currentTimeMillis()-start)/1000.0);



	}
	static int MinJumps(int curr_pos)
	{
		if(curr_pos >= items-1)
			return 0;
		else if(arr[curr_pos] <= 0)
			return Integer.MAX_VALUE;
		else
		{
			if(memo[curr_pos] !=-1)
				return memo[curr_pos];
			int min = Integer.MAX_VALUE;
			for(int i=1;i<=arr[curr_pos];i++)
			{
				if(curr_pos+i <= items-1 && arr[curr_pos+1] > 0)
					{
						int temp = MinJumps(curr_pos+i);
						if(temp < min)
							min =temp;
					}
			}
			if(min != Integer.MAX_VALUE)
				min++;
			memo[curr_pos]=min;
			return min;

		}
	}

}
