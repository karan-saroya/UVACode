import java.io.*;
import java.util.*;
class Main 
{
	static int value[]= new int[40];
	static int it_v[] = new int[40];
	static int memo[][] = new int[310][310];
	static int num_coins=0;
	static int bal=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int i=0;i<num_cases;i++)
		{
			if(i != 0)
				buf.readLine();
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			num_coins = Integer.parseInt(tok.nextToken());
			 bal = Integer.parseInt(tok.nextToken());
			for(int j=0;j<num_coins;j++)
			{
				tok = new StringTokenizer(buf.readLine());
				value[j] = Integer.parseInt(tok.nextToken());
				it_v[j] = Integer.parseInt(tok.nextToken());
				
			}
			for(int j=0;j<310;j++)
			for(int k=0;k<310;k++)
				memo[j][k]=-1;
			//memo[0][0]=-1;
			//long start=System.currentTimeMillis();
			int ans=(MinCoins(0,0));
			
			
			if(ans == Integer.MAX_VALUE)
				System.out.println("not possible");
			else
				System.out.println(ans);
			///System.out.println((System.currentTimeMillis()-start)/1000.0);
		}
		
	}

	static int MinCoins(int curr_value, int curr_it_v)
	{
		if((bal * bal ) == ((curr_value*curr_value)+(curr_it_v *curr_it_v)))
		{
			return 0;
		}
		else if((bal * bal ) < ((curr_value*curr_value)+(curr_it_v *curr_it_v)))
		{
			return Integer.MAX_VALUE;
		}
		else
		{
			if(memo[curr_value][curr_it_v] != -1)
			{
				return memo[curr_value][curr_it_v];
			}
			int min = Integer.MAX_VALUE;
			for(int i=0;i<num_coins;i++)
			{
				if((bal * bal ) >= (((curr_value+value[i])*(curr_value+value[i]))+((curr_it_v+it_v[i]) *(curr_it_v+it_v[i]))))
				{
					int temp = MinCoins(curr_value+value[i],curr_it_v+it_v[i]);
				
						if(temp < min)
							min = temp;
				}
					
			}
			if(min != Integer.MAX_VALUE)
				min++;
			memo[curr_value][curr_it_v] = min;
			return min;
		}
		
		
	}
}
