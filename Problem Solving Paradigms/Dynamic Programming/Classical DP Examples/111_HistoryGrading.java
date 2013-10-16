import java.io.*;
import java.util.*;

public class Main
{
	static int[] rating;
	static int[] cand_rank;
	static int[] len_seq;
	public static void main(String[] args) throws Exception
	{

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(buf.readLine());
		 rating = new int[n+1];
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=1;i<=n;i++)
		{
			int number = Integer.parseInt(tok.nextToken());
			rating[i]=number;
		}

		String line="";
		cand_rank = new int[n+1];
		len_seq= new int[n+1];
		while((line = buf.readLine()) != null && !line.equals(""))
		{
			tok = new StringTokenizer(line);
			for(int i=1;i<=n;i++)
				len_seq[i]=0;

			for(int i=1;i<=n;i++)
			{
				cand_rank[Integer.parseInt(tok.nextToken())] = i;
			}
			int max=0;
			for(int i=n;i>=1;i--)
				{
					int temp=lis(i,n);
					if(temp > max)
						max=temp;
				}

			System.out.println(max);
		}

	}
	public static int lis(int curr_node,int n)
	{
		if(curr_node == n)
		{
			if(len_seq[curr_node] == 0)
			{
				len_seq[curr_node]=1;
				return 1;
			}
			else
				return len_seq[curr_node];

		}
		else
		{
			if(len_seq[curr_node] != 0)
				return len_seq[curr_node];
			else
			{
				int max=0;
				for(int i=curr_node+1;i<=n;i++)
				{
					int temp=lis(i,n);
					if(temp > max && rating[cand_rank[curr_node]] < rating[cand_rank[i]])
					{
						max=temp;
					}
				}

				len_seq[curr_node]= max+1;
				return (max+1);
			}
		}

	}

}
