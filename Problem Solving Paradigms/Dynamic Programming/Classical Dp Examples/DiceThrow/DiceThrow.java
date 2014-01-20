import java.io.*;
public class DiceThrow
{
	static int m=0;
	static int n=0;
	static int memo[][];
	public static void main( String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(buf.readLine());
		m = Integer.parseInt(buf.readLine());
		int X= Integer.parseInt(buf.readLine());
		memo = new int[n][X+1];
		for(int i=0;i<memo.length;i++)
		{
			for(int j=0;j<memo[i].length;j++)
				memo[i][j] =-1;
		}
		System.out.println(dicethr(X,0));
	}
	static int dicethr(int bal, int curr_pos)
	{
		if(bal == 0 && curr_pos == n)
		{
			return 1;
		}
		else if(bal >0 && curr_pos ==n)
			return 0;
		else if(bal == 0 || bal <0)
		{
			return 0;
		}
		else
		{
			if(memo[curr_pos][bal] != -1)
				return memo[curr_pos][bal];
			int sum=0;
			for(int i=1;i<=m;i++)
			{
				if((bal - i) >= 0)
				{
						int temp = dicethr(bal-i,curr_pos+1);
						sum+=temp;
 				}
			}
			memo[curr_pos][bal] = sum;
			return sum;

		}
	}

}
