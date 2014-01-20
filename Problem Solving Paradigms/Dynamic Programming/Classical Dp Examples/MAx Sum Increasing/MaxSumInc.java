import java.io.*;
import java.util.*;
public class MaxSumIncreasing
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int items = Integer.parseInt(buf.readLine());
		int value[] = new int[items];
		int msi[] = new int[items];
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<value.length;i++)
			value[i] = Integer.parseInt(tok.nextToken());

		for(int i=0;i<value.length;i++)
		{
			int max = Integer.MIN_VALUE;
			for(int j=i-1;j>=0;j--)
			{
				if(value[i] >= value[j] && max < msi[j])
				{
					max=msi[j];
				}
			}
			if(max < 0)
				max=0;
			msi[i]=max+value[i];

		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<msi.length;i++)
		{
			if(msi[i] > max)
				max=msi[i];
		}
		System.out.println(max);


	}

}
