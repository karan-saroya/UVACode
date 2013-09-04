import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int num_sets= Integer.parseInt(buf.readLine());
		for(int j=0;j<num_sets;j++)
		{
			if(j != 0)
			{
				System.out.println("");
			}
			buf.readLine();
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			int length = Integer.parseInt(tok.nextToken());
			int h_dis  =  Integer.parseInt(tok.nextToken());
			compute_arr(length,h_dis,"",0);

		}
	}
	static void compute_arr(int length,int hamm_dis,String arr,int curr_ones)
	{
		if(curr_ones+(length-arr.length()) <hamm_dis)
		{
			return;
		}
		else if(curr_ones == hamm_dis)
		{
			String temp=arr;

				if(arr.length() < length)
				{

					for(int i=0;i<length-arr.length();i++)
					{
						temp+="0";
					}
				}
			System.out.println(temp);
			return;
		}
		else if(arr.length() == length && curr_ones == hamm_dis)
		{
			System.out.println(arr);
			return;
		}
		else
		{
			compute_arr(length,hamm_dis,arr+"0",curr_ones);
			compute_arr(length,hamm_dis,arr+"1",curr_ones+1);


		}
	}

}
