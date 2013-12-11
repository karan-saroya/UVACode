import java.io.*;
import java.util.*;

class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int i=0;i<num_cases;i++)
		{
			int size  = Integer.parseInt(buf.readLine());
			int[][] arr = new int[size][size];
			for(int j=0;j<size;j++)
			{
				for(int k=0;k<size;k++)
				{
					arr[j][k] = 1;
				}
			}
			int num_blocks = Integer.parseInt(buf.readLine());
			for(int j=0;j<num_blocks;j++)
			{
				StringTokenizer tok = new StringTokenizer(buf.readLine());
				int start_x = Integer.parseInt(tok.nextToken());
				int start_y = Integer.parseInt(tok.nextToken());
				int end_x = Integer.parseInt(tok.nextToken());
				int end_y = Integer.parseInt(tok.nextToken());
				for(int k=start_x-1;k<end_x;k++)
				{
					for(int l=start_y-1;l<end_y;l++)
					{
						arr[k][l] = -1000;
					}
				}
			}

			int max_sum = Integer.MIN_VALUE;
			for(int j=0;j<size;j++)
			{
				int temp[] = new int[size];
				for(int k=j;k<size;k++)
				{
					for(int l=0;l<size;l++)
						temp[l] += arr[l][k];

					int sum = temp[size-1];
					int kad[] = new int[size];
					kad[size-1] = temp[size-1];

					for(int l=size-1;l>0;l--)
					{
						if(temp[l-1] + kad[l] > temp[l-1])
							kad[l-1] = kad[l] + temp[l-1];
						else
							kad[l-1] = temp[l-1];
						if(kad[l-1] > sum)
							sum= kad[l-1];
					}

					if(sum > max_sum)
						max_sum=sum;

				}

			}

			if(max_sum == -1000)
				System.out.println("0");
			else
				System.out.println(max_sum);


		}



	}

}
