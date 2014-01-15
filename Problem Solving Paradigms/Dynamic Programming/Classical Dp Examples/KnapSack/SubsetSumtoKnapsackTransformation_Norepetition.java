import java.io.*;
import java.util.*;
class Main
{
	static int value[] = new int[1000];
	static cust_obj memo[][] = new cust_obj[1000][31];
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
					value[i] = Integer.parseInt(tok.nextToken());
					weight[i] = Integer.parseInt(tok.nextToken());
				}
			int num_people = Integer.parseInt(buf.readLine());
			int capacity[] = new int[num_people];

			for(int i=0;i<num_people;i++)
				capacity[i] = Integer.parseInt(buf.readLine());

			for(int i=0;i<num_items;i++)
			{
				for(int j=0;j<memo[i].length;j++)
				{
					memo[i][j] = new cust_obj(-1,-1);
				}
			}
			memo[0][0].curr_value=0;
			memo[0][0].weight_left=0;
			int ans=0;
			for(int i=0;i<capacity.length;i++)
				ans+=ks(capacity[i],0,0).curr_value;
			System.out.println(ans);



		}
	}
	static cust_obj ks(int weight_left, int curr_pos, int curr_value)
	{
		if(weight_left == 0)
			return new cust_obj(0,curr_value);
		else if(weight_left < 0)
			return null;
		else if(curr_pos  == num_items)
			return new cust_obj(weight_left,curr_value);
		else
		{
			if(memo[curr_pos][weight_left].curr_value != -1)
				return memo[curr_pos][weight_left];
			cust_obj obj= new cust_obj(0,Integer.MIN_VALUE);
			for(int i=curr_pos;i<num_items;i++)
			{
				cust_obj temp = ks(weight_left -weight[i],i+1,curr_value+value[i]);
				if(temp!= null && temp.weight_left >= 0 &&temp.curr_value > obj.curr_value )
					obj = temp;
			}
			if(obj.curr_value == Integer.MIN_VALUE)
				obj = new cust_obj(weight_left,curr_value);
			memo[curr_pos][weight_left] = obj;

			return obj;
		}
	}

}

class cust_obj
{
	int weight_left=0;
	int curr_value =0;
	cust_obj(int cweight_left, int c_curr_value)
	{
		weight_left = cweight_left;
		curr_value = c_curr_value;
	}

}