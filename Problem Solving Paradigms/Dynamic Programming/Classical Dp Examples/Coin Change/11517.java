import java.io.*;

class Main
{
	static int value[]= new int[100];
	static int[] memo_ss[] = new int[100][10001];
	static int[] memo_mc[] = new int[100][10001];
	static int num_coins=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int i=0;i<num_cases;i++)
		{
			int target = Integer.parseInt(buf.readLine());
			num_coins = Integer.parseInt(buf.readLine());
			int min=Integer.MAX_VALUE;
			for(int j=0;j<num_coins;j++)
					{
						value[j] = Integer.parseInt(buf.readLine());
						if(value[j] < min)
							min=value[j];
					}
		for(int k=0;k<num_coins;k++)
			for(int j=0;j<=target;j++)
				memo_ss[k][j]=-1;
			memo_ss[0][0]=0;
			int left=ss(target,0);


				for(int k=0;k<num_coins;k++)
					for(int j=0;j<=(target+left);j++)
						memo_mc[k][j]=-1;
				int mc = mc(0,target+left);
				System.out.println(target+left + " "+mc);


		}
	}
	static int ss(int left,int curr_pos)
	{
		if(left == 0)
			return 0;
		else if(left < 0)
			return -left;
		else if(curr_pos == num_coins)
			return left;
		else
		{
			if(memo_ss[curr_pos][left] != -1)
				return memo_ss[curr_pos][left];
			int min = Integer.MAX_VALUE;
			for(int i=curr_pos;i<num_coins;i++)
			{

						int temp = ss(left-value[i],i+1);
						if(temp < min)
							min =temp;


			}
			if(min == Integer.MAX_VALUE)
				min = left;
			memo_ss[curr_pos][left]= min;
			return min;
		}

	}
	static int mc(int curr_pos,int left)
	{
		if(left == 0)
			return 0;
		else if(left < 0)
			return Integer.MAX_VALUE;
		else if(curr_pos == num_coins)
			return left;
		else
		{
			if(memo_mc[curr_pos][left] != -1)
				return memo_mc[curr_pos][left];
			int min = Integer.MAX_VALUE;
			for(int i=curr_pos;i<num_coins;i++)
			{
				if(left-value[i] >=0)
					{
						int temp = mc(i+1,left-value[i]);
						if(temp < min)
							min =temp;
					}

			}
			if(min != Integer.MAX_VALUE)
				min++;
			memo_mc[curr_pos][left]= min;
			return min;
		}

	}
}
