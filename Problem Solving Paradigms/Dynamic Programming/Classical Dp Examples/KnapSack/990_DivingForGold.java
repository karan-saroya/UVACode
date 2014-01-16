import java.io.*;
import java.util.*;
class Main
{
	static int[] value = new int[1000];
	static int[] weight = new int[1000];
	static int[][] memo = new int[30][1001];
	static int num_items=0;
	static String[][] path = new String[30][1001];
	static int w=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases=0;
		while(true)
		{
			if(num_cases != 0)
				System.out.println("");
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			int cap = Integer.parseInt(tok.nextToken());
			w = Integer.parseInt(tok.nextToken());
			num_items = Integer.parseInt(buf.readLine());
			for(int j=0;j<num_items;j++)
			{
				tok = new StringTokenizer(buf.readLine());
				weight[j] = Integer.parseInt(tok.nextToken())*3*w;
				value[j] = Integer.parseInt(tok.nextToken());
			}
			for(int j=0;j<num_items;j++)
			{
				for(int k=0;k<=cap;k++)
					{
						memo[j][k] = -1;
						path[j][k]="";
					}
			}
			memo[0][0] = 0;
			path[0][0]="0";
			System.out.println(ks(cap,0));

			ArrayList<String> list = new ArrayList<String>();
			int count=0;
			tok = new StringTokenizer(path[0][cap]);
			while(tok.hasMoreTokens())
			{
				count++;
				String tmp = tok.nextToken();
				list.add(tmp.substring(0,tmp.indexOf(',')));
				list.add(tmp.substring(tmp.indexOf(',')+1));
			}
			System.out.println(count);
			for(int i=0;i<2*count;i+=2)
			{
				System.out.println(list.get(i)+" "+list.get(i+1));
			}

			if(buf.readLine() == null)
				break;
			else
				num_cases++;

		}

	}
	static int ks(int cap, int curr_pos)
	{
		if(cap == 0)
			return 0;
		else if(cap < 0)
			return Integer.MIN_VALUE;
		else if(curr_pos == num_items)
			return 0;
		else
		{
			if(memo[curr_pos][cap] != -1)
				return memo[curr_pos][cap];
			int max = Integer.MIN_VALUE;
			String str_tmp="";
			for(int i=curr_pos;i<num_items;i++)
			{
				if(cap-weight[i] >=0)
				{
					int temp = ks(cap-weight[i],i+1);
					if( max < temp+value[i])
						{
							max= temp+value[i];
							if(temp == 0)
							{
								str_tmp = (weight[i]/(3*w))+","+value[i];
							}
							else
								str_tmp = (weight[i]/(3*w))+","+value[i]+" "+path[i+1][cap-weight[i]];
						}
				}
			}
			if(max == Integer.MIN_VALUE)
				{
					max=0;

				}
			if(max == 0 )
				path[curr_pos][cap] = "";
			else
				path[curr_pos][cap] = str_tmp;
			memo[curr_pos][cap] = max;
			return max;
		}
	}

}
