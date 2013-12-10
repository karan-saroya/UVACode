import java.util.*;
import java.io.*;
class Main
{
	static int weight[] = new int[2007];
	static int memo[] = new int[2007];
	static int memo_d[] = new int[2007];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int i=0;i<num_cases;i++)
		{
			int num_cars=Integer.parseInt(buf.readLine());
			for(int j=num_cars-1;j>=0;j--)
			{
				memo[j]=0;
				weight[j]=Integer.parseInt(buf.readLine());
				memo_d[j]=0;
			}
			memo[0]=1;
			for(int j=1;j<num_cars;j++)
			{
				memo[j]=1;
				int max=0;
				for(int k=0;k<j;k++)
				{
					if(weight[k] < weight[j] && memo[k] > max )
					{
						max=memo[k];
					}

				}
				memo[j]=max+1;

			}
			memo_d[0]=1;
			for(int j=1;j<num_cars;j++)
			{
				memo_d[j]=1;
				int max=0;
				for(int k=0;k<j;k++)
				{
					if(weight[k] > weight[j] && memo_d[k] > max )
					{
						max=memo_d[k];
					}

				}
				memo_d[j]=max+1;

			}
			int max=0;
			for(int j=0;j<num_cars;j++)
			{
				if(memo[j]+ memo_d[j]-1 > max)
					max=memo[j]+memo_d[j]-1;
			}

			System.out.println(max);
		}


	}

}