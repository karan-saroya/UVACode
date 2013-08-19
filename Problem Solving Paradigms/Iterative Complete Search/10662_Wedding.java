import java.io.*;
import java.util.*;
class Main
{
	static boolean tr[][];
	static boolean rh[][];
	static boolean ht[][];
	static int trav_price[];
	static int res_price[];
	static int hot_price[];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		tr = new boolean[20][20];
		rh = new boolean[20][20];
		ht = new boolean[20][20];
		trav_price = new int[20];
		hot_price = new int[20];
		res_price = new int[20];
		while((line=buf.readLine())!= null && !line.equals("") )
		{
			StringTokenizer tok = new StringTokenizer(line);
			int t=Integer.parseInt(tok.nextToken());
			int r =Integer.parseInt(tok.nextToken());
			int h = Integer.parseInt(tok.nextToken());

			for(int i=0;i<20;i++)
			{
				for(int j=0;j<20;j++)
				{
					tr[i][j]=false;
					rh[i][j]=false;
					ht[i][j]=false;
					trav_price[i]=0;
					hot_price[i]=0;
					res_price[i]=0;
				}
			}

			for(int i=0;i<t;i++)
			{
				tok = new StringTokenizer(buf.readLine());
				trav_price[i]=Integer.parseInt(tok.nextToken());
				for(int j=0;tok.hasMoreTokens();j++)
				{
					if(Integer.parseInt(tok.nextToken()) == 0)
							{
								tr[i][j]=true;
							}
				}
			}
			for(int i=0;i<r;i++)
			{
				tok = new StringTokenizer(buf.readLine());
				res_price[i]=Integer.parseInt(tok.nextToken());
				for(int j=0;tok.hasMoreTokens();j++)
				{
					if(Integer.parseInt(tok.nextToken()) == 0)
							{
								rh[i][j]=true;
							}
				}
			}
			for(int i=0;i<h;i++)
			{
				tok = new StringTokenizer(buf.readLine());
				hot_price[i]=Integer.parseInt(tok.nextToken());
				for(int j=0;tok.hasMoreTokens();j++)
				{
					if(Integer.parseInt(tok.nextToken()) == 0)
							{
								ht[i][j]=true;
							}
				}
			}
			int min=Integer.MAX_VALUE;
			int pos_t=0;
			int pos_r=0;
			int pos_h=0;
			for(int i=0;i<t;i++)
			{
				for(int j=0;j<r;j++)
				{
					if(tr[i][j] )
					{
						for(int k=0;k<h;k++)
						{
							if(rh[j][k] && ht[k][i])
							{
								if(trav_price[i] + res_price[j] +hot_price[k] < min )
								{
									min=trav_price[i] + res_price[j] +hot_price[k];
									pos_t=i;
									pos_r=j;
									pos_h=k;
								}
							}
						}
					}

				}
			}
			if(min != Integer.MAX_VALUE)
			{
				System.out.println(pos_t+" "+pos_r+" "+pos_h+":"+min);
			}
			else
			{
				System.out.println("Don't get married!");
			}

		}

	}
}
