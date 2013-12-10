import java.util.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			int M = Integer.parseInt(tok.nextToken());
			int N = Integer.parseInt(tok.nextToken());
			if(M == 0)
				break;
			int[][] grid = new int[M][N];

			for(int i=0;i<M;i++)
			{
				tok = new StringTokenizer(buf.readLine());
				for(int j=0;j<N;j++)
				{
					int val = Integer.parseInt(tok.nextToken());
					if(val == 0)
						grid[i][j]=1;
					else
						grid[i][j]=-1000;
				}

			}

			int max_sum=Integer.MIN_VALUE;
			for(int i=0;i<N;i++)
			{
				int[] temp = new int[M];
				for(int j=i;j<N;j++)
				{
					for(int k=0;k<temp.length;k++)
						temp[k] += grid[k][j];

					int sum = temp[temp.length-1];
					int[] kad = new int[temp.length];
					kad[temp.length-1] = temp[temp.length-1];
					for(int k=temp.length-1;k>0;k--)
					{
						if(kad[k] + temp[k-1] > temp[k-1])
							kad[k-1]= kad[k] + temp[k-1];
						else
							kad[k-1] = temp[k-1];

						if(kad[k-1] > sum)
							sum= kad[k-1];

					}

					if(sum > max_sum)
						max_sum = sum;

				}

			}
			if(max_sum == -1000)
				System.out.println("0");
			else
			{
					System.out.println(max_sum);

			}

		}

	}

}
