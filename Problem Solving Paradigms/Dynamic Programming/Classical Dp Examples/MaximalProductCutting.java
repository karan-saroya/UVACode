import java.io.*;
public class MaxProductCutting
{
	static int memo[];
	static int cut[];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine());
		memo = new int[length+1];
		cut= new int[length-1];
		for(int i=0;i<memo.length;i++)
			memo[i] =-1;
		for(int i=0;i<cut.length;i++)
			cut[i]=i+1;
		System.out.println(MaxProdCut(length));

	}
	static int MaxProdCut(int length)
	{
		if(length == 0 )
			return 1;
		else if(length<0)
			return Integer.MIN_VALUE;
		else
		{
			if(memo[length] != -1)
				return memo[length];
			int max = Integer.MIN_VALUE;
			for(int i=0;i<cut.length;i++)
			{
				if(length - cut[i] >= 0)
				{
						int temp = MaxProdCut(length-cut[i]);
						if((temp *cut[i]) > max)
							max=temp*cut[i];
				}
			}
			memo[length] = max;
			return max;
		}

	}

}
