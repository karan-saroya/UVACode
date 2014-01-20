import java.io.*;
import java.util.*;
public class MaxLengthChainOfPairs
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(buf.readLine());
		int first[] = new int[size];
		int sec[] = new int[size];
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<size;i++)
		{
			first[i] = Integer.parseInt(tok.nextToken());
		}
		tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<size;i++)
			sec[i] = Integer.parseInt(tok.nextToken());

		int[] lchain = new int[size];

		for(int i=0;i<size;i++)
		{
			int max=Integer.MIN_VALUE;
			for(int j=0;j<i;j++)
			{
				if(sec[j] < first[i] && max< lchain[j])
					max=lchain[j];

			}
			if(max < 0)
				max=0;
			lchain[i] = max+1;
		}
		int temp= Integer.MIN_VALUE;
		for(int i=0;i<lchain.length;i++)
		{
			if(temp < lchain[i])
				temp = lchain[i];
		}
		System.out.println(temp);

	}

}
