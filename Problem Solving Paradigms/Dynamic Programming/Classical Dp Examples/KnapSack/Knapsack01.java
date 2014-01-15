import java.io.*;
import java.util.*;
class Main
{
	static int value[] = new int[1000];
	static int memo[][][];
	static int weight[] = new int[1000];
	static int num_items=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		for(int k=0;k<num_cases;k++)
		{
			 num_items = Integer.parseInt(buf.readLine());
			StringTokenizer tok ;

			for(int i=0;i<num_items;i++)
				{
					tok = new StringTokenizer(buf.readLine());
					weight[i] = Integer.parseInt(tok.nextToken());
					value[i] = Integer.parseInt(tok.nextToken());

				}
			int num_people = Integer.parseInt(buf.readLine());
			int capacity[] = new int[num_people];

			for(int i=0;i<num_people;i++)
				capacity[i] = Integer.parseInt(buf.readLine());
			memo= new int[num_items][capacity[0]+1][4400];
			for(int i=0;i<num_items;i++)
			{
				for(int j=0;j<memo[i].length;j++)
				{
					for(int l=0;l<memo[i][j].length;l++)
						memo[i][j][l] = -1;
				}
			}
			memo[0][0][0]=0;
			memo[0][0][0]=0;
			int ans=0;
			long start = System.currentTimeMillis();
			ans+=ks(capacity[0],0,0);

			System.out.println(ans);
			System.out.println((System.currentTimeMillis() - start)/1000.0);


		}
	}
	static int ks(int weight_left, int curr_pos, int curr_value)
	{
		if(weight_left == 0)
			return curr_value;
		else if(weight_left < 0)
			return Integer.MIN_VALUE;
		else if(curr_pos  == num_items)
			return curr_value;
		else
		{
			if(memo[curr_pos][weight_left][curr_value] != -1)
				return memo[curr_pos][weight_left][curr_value];
			int obj=Integer.MIN_VALUE;
			for(int i=curr_pos;i<num_items;i++)
			{
				int temp = ks(weight_left -weight[i],i+1,curr_value+value[i]);
				if(temp> obj )
					obj = temp;
			}
			if(obj == Integer.MIN_VALUE)
				obj = curr_value;
			memo[curr_pos][weight_left][curr_value] = obj;

			return obj;
		}
	}

}
