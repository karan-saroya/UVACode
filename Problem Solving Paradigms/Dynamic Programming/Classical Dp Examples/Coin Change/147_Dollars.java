
import java.io.*;
import java.text.DecimalFormat;
class Main
{
	static int value[] = new int[]{5,10,20,50,100,200,500,1000,2000,5000,10000};
	static long memo[][] = new long[11][30001];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases=0;

		for(int i=0;i<11;i++)
		{
			for(int j=0;j<=30000;j++)
				memo[i][j] = -1;
		}
		while(true)
		{

			int bal = (int)(Math.rint((Double.parseDouble(buf.readLine())*100+0.01)));
			if(bal == 0)
				break;
			memo[0][0]=1;
			String ans=""+num_ways(bal,0);

		DecimalFormat format = new DecimalFormat("0.00");
		String str=format.format(bal/100.0);
		if(str.length()<6)
		{
			while(str.length() <6)
				str=" "+str;
		}
		if(ans.length()<17)
		{
			while(ans.length() < 17)
				ans=" "+ans;
		}
			System.out.println(str+ans);
			num_cases++;

		}
	}
	static long  num_ways(int bal, int curr_pos)
	{
		if(bal == 0)
			return 1;
		else if(bal < 0)
			return 0;
		else
		{
			if(memo[curr_pos][bal] != -1)
				return memo[curr_pos][bal];
			long ways=0;
			for(int i=curr_pos;i<value.length;i++)
			{
				if(bal - value[i] >= 0)
					ways+=num_ways(bal-value[i],i);

			}
			memo[curr_pos][bal] = ways;
			return ways;
		}

	}

}
