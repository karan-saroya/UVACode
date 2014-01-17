import java.io.*;
class Main
{
	static int value[] = new int[]{1,5,10,25,50};
	static long memo[][] = new long[5][7490];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases=0;

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<memo[i].length;j++)
				memo[i][j] = -1;
		}
		String line="";
		while((line = buf.readLine())!= null && !line.equals(""))
		{

			int bal = Integer.parseInt(line);
			memo[0][0]=1;
			System.out.println(num_ways(bal,0));


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
