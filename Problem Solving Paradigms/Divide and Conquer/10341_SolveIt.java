import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		DecimalFormat format = new DecimalFormat("0.0000");

		while((line = buf.readLine())!= null && !line.equals(""))
		{
			StringTokenizer tok = new StringTokenizer(line);
			double low =0;
			double up=1;
			int p= Integer.parseInt(tok.nextToken());
			int q= Integer.parseInt(tok.nextToken());
			int r= Integer.parseInt(tok.nextToken());
			int s= Integer.parseInt(tok.nextToken());
			int t= Integer.parseInt(tok.nextToken());
			int u= Integer.parseInt(tok.nextToken());
			double init_fx1=fx(p,q,r,s,t,u,0);
			double init_fx2=fx(p,q,r,s,t,u,1);

			if(init_fx1 == 0 || Math.abs(init_fx1-0) <0.00000001 )

			{
				System.out.println(format.format(low));
			}
			else if(init_fx2 == 0 || Math.abs(init_fx2-1) <0.00000001)
				System.out.println(format.format(up));
			else if((init_fx2 > 0 && init_fx1 > 0 )|| (init_fx2 < 0 && init_fx1 < 0 ))
			{
				System.out.println("No solution");
			}
			else
			{
				double mid=0;
				boolean no_sol=false;
				while(true)
				{
					double fx1=fx(p,q,r,s,t,u,low);
					double fx2=fx(p,q,r,s,t,u,up);
					if(fx1 >0 && fx2 > 0 || fx1<0 && fx2 <0)
					{
						no_sol=true;
						break;
					}
					mid = (low+up)/2.0;
					double ret = fx(p,q,r,s,t,u,mid);
					if(Math.abs(ret-0) < 0.00000001)
					{
						break;
					}
					else if(ret > 0)
					{
						if(fx1 > 0)
						{
							low = mid;

						}
						else
						{
							up=mid;
						}


					}
					else
					{
						if(fx1 > 0)
						{
							up=mid;
						}
						else
						{
							low=mid;
						}
					}
				}
				if(no_sol)
						System.out.println("No solution");
				else
						System.out.println(format.format(mid));


			}


		}


	}
	static double fx(int p, int q, int r, int s, int t,int u,double x)
	{
		return (p*Math.exp(-x) + q* Math.sin(x)+r*Math.cos(x)+ s*Math.tan(x)+t*x*x+u);
	}

}
