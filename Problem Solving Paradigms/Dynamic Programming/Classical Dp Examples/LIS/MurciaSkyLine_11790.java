import java.io.*;
import java.util.*;
class Main
{
	static int memo[];
	static int height[];
	static int width[];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int i=1;i<=num_cases;i++)
		{
			int num_build= Integer.parseInt(buf.readLine());
			height= new int[num_build];
			width = new int[num_build];
			memo = new int[num_build];
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			for(int k=0;k<num_build;k++)
				{
					height[k] = Integer.parseInt(tok.nextToken());
					memo[k]=-1;
				}

			tok = new StringTokenizer(buf.readLine());
			for(int k=0;k<num_build;k++)
				width[k] = Integer.parseInt(tok.nextToken());

			int max_lis=0;
			for(int j=num_build-1;j>=0;j--)
			{
				int temp = lis(j,num_build-1);
				if(temp > max_lis)
				{
					max_lis  = temp;
				}

			}
			for(int k=0;k<num_build;k++)
			{
				memo[k]=-1;
			}
			int max_lds=0;
			for(int k=num_build-1;k>=0;k--)
			{
				int temp = lds(k,num_build-1);
				if(temp > max_lds)
					max_lds=temp;

			}
			if(max_lis >= max_lds)
			{
				System.out.println("Case "+i+". Increasing ("+max_lis+"). Decreasing ("+max_lds+").");
			}
			else
			{
				System.out.println("Case "+i+". Decreasing ("+max_lds+"). Increasing ("+max_lis+").");
			}


		}

	}
	static int lis(int curr, int size)
	{
		if(curr  == size)
		{
			if(memo[curr] == -1)
				memo[curr]=width[curr];
			return memo[curr];
		}
		else
		{
			if(memo[curr] != -1)
				return memo[curr];
			else
			{
				int max=0;
				for(int i=curr+1;i<=size;i++)
				{
					int temp = lis(i,size);
					if(temp > max && height[curr] < height[i])
						max=temp;
				}
				memo[curr] = max + width[curr];
				return memo[curr];


			}

		}
	}
	static int lds(int curr, int size)
	{
		if(curr  == size)
		{
			if(memo[curr] == -1)
				memo[curr]=width[curr];
			return memo[curr];
		}
		else
		{
			if(memo[curr] != -1)
				return memo[curr];
			else
			{
				int max=0;
				for(int i=curr+1;i<=size;i++)
				{
					int temp = lis(i,size);
					if(temp > max && height[curr] > height[i])
						max=temp;
				}
				memo[curr] = max+width[curr];
				return memo[curr];


			}

		}
	}
}
