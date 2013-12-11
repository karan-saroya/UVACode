import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int i=1;i<=num_cases;i++)
		{
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			int size = Integer.parseInt(tok.nextToken());
			size--;
			int[] arr = new int[size];
			int[] end_pos = new int[size];
			for(int j=0;j<size;j++)
			{
				tok = new StringTokenizer(buf.readLine());
				arr[j] = Integer.parseInt(tok.nextToken());
			}

			int max_sum= arr[size-1];
			end_pos[size-1] = size+1;
			int kad[] = new int[size];
			kad[size-1] = arr[size-1];
			int max_start_pos=size;
			int max_end_pos=size+1;
			for(int j=size-1;j>0;j--)
			{
				if(kad[j] + arr[j-1] >= arr[j-1])
					{
						kad[j-1] = arr[j-1] + kad[j];
						end_pos[j-1] = end_pos[j];
					}
				else
					{
						kad[j-1] = arr[j-1];
						end_pos[j-1] = j+1;

					}

				if(max_sum < kad[j-1])
				{
					max_sum = kad[j-1];
				}
			}

			int diff=Integer.MIN_VALUE;
			for(int j=0;j<size;j++)
			{
				if(kad[j] == max_sum && end_pos[j] - (j+1) > diff)
				{
					diff = end_pos[j] -(j+1);
				}
			}


			for(int j=0;j<size;j++)
			{
				if(kad[j] == max_sum && (end_pos[j] -(j+1)) == diff)
				{
					max_start_pos = j +1;
					max_end_pos = end_pos[j];
					break;
				}
			}

			if(max_sum > 0)
				System.out.println("The nicest part of route "+i+" is between stops "+max_start_pos+" and "+ max_end_pos);
			else
				System.out.println("Route "+i+" has no nice parts");

		}

	}

}
