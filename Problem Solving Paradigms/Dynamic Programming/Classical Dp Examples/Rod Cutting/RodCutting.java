import java.io.*;
import java.util.*;
class RodCutting
{

	static int cut[];
	static int price[];
	static int memo[];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int items = Integer.parseInt(buf.readLine());
		cut = new int[items];
		price = new int[items];

		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<items;i++)
				cut[i] = Integer.parseInt(tok.nextToken());
		tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<items;i++)
				price[i] = Integer.parseInt(tok.nextToken());
		int rod_length = Integer.parseInt(buf.readLine());
		memo =new int[rod_length+1];
		for(int i=0;i<memo.length;i++)
			memo[i]=-1;
		RodCutting(rod_length);
		System.out.println(memo[rod_length]);
	}
	static int RodCutting(int length)
	{
		if(length == 0)
		{
			return 0;

		}
		else if(length < 0)
			return Integer.MIN_VALUE;
		else
		{
			if(memo[length] != -1)
				return memo[length];
			int max= Integer.MIN_VALUE;
			for(int i=0;i<cut.length;i++)
			{
				if(length-cut[i] >=0)
				{
					int temp  = RodCutting(length - cut[i]);

					if(temp+price[i]> max)
						max=(temp+price[i]);
				}
			}
			memo[length] = max;
			return max;
		}


	}

}
