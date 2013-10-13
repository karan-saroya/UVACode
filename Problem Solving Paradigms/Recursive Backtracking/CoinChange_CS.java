import java.io.*;
import java.util.*;
public class CoinChange_CS
{
	static int min=Integer.MAX_VALUE;
	static String min_path="";
	static int num_coins;
	static int V;
	static int[] coins_denom;
	public static void main(String args[]) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		num_coins = Integer.parseInt(buf.readLine());

		V = Integer.parseInt(buf.readLine());
		 coins_denom=  new int[num_coins];
		 StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<coins_denom.length;i++)
		{

			coins_denom[i] = Integer.parseInt(tok.nextToken());
		}
		for(int i=0;i<coins_denom.length;i++)
		{
			 int limit = V/coins_denom[i];
			 String path=""+coins_denom[i];
			 for(int j=1;j<=limit;j++)
			 {
				 coin_change(i,V-coins_denom[i]*j,path,j);
				 path=path+" "+coins_denom[i];
			 }

		}
		System.out.println(min+" "+min_path);

	}
	public static void coin_change(int curr,int bal, String path, int coins)
	{

		if(bal == 0)
		{
			if(coins<min)
			{
				min=coins;
				min_path=path;
			}
			return;
		}
		else if(bal <0)
			return;

		else
		{
			for(int i=curr+1;i<num_coins;i++)
			{
				 int limit = bal/coins_denom[i];
				 String temp=path+" "+coins_denom[i];
				 for(int j=1;j<=limit;j++)
				 {
					 coin_change(i,bal-coins_denom[i]*j,temp,j+coins);
					 temp=temp+" "+coins_denom[i];
				 }


			}
		}
	}

}
