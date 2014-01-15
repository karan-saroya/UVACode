import java.io.*;
import java.util.*;
public class KSR_CS
{
	static int value[];
	static cust_obj memo[];
	static int weight[];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_items = Integer.parseInt(buf.readLine());
		value = new int[num_items];
		weight = new int[num_items];
		int W = Integer.parseInt(buf.readLine());
		memo  = new cust_obj[W+1];
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<num_items;i++)
			value[i] = Integer.parseInt(tok.nextToken());
		tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<num_items;i++)
			weight[i] = Integer.parseInt(tok.nextToken());
		for(int i=0;i<=W;i++)
			memo[i] = new cust_obj(-1,-1);
		System.out.println(ksr(W,0,0).curr_value);
	}
	static cust_obj ksr(int weight_left, int curr_pos, int curr_value)
	{
		if(weight_left  == 0)
			return new cust_obj(0,curr_value);
		else if(weight_left < 0)
			return null;
		else if(curr_pos == value.length)
			return new cust_obj(weight_left,curr_value);
		else
		{
			if(memo[weight_left].curr_value != -1)
			{
				return memo[weight_left];
			}
			cust_obj obj = new cust_obj(0,Integer.MIN_VALUE);
			for(int i=0;i<value.length;i++)
			{
				cust_obj temp  = ksr(weight_left-weight[i],i+1,curr_value+value[i]);
				if(temp != null && temp.curr_value > obj.curr_value )
					obj=temp;
			}
			if(obj.curr_value == Integer.MIN_VALUE)
				obj.curr_value = weight_left;

			return obj;
		}

	}

}
class cust_obj
{
	int weight_left=0;
	int curr_value=0;
	cust_obj(int cweight_left, int ccurr_value)
	{
		weight_left= cweight_left;
		curr_value = ccurr_value;
	}

}