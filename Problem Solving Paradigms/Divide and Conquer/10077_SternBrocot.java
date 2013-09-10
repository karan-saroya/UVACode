import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		while((line = buf.readLine())!= null && !line.equals(""))
		{
			StringTokenizer tok = new StringTokenizer(line);
			int num= Integer.parseInt(tok.nextToken());
			int den = Integer.parseInt(tok.nextToken());
			if(num == den&& num == 1)
			{
				break;
			}
			if(num > den)
			{
				String ans="R";
				int lower_num=1;
				int lower_den=1;

				int up_num=1;
				int up_den=0;

				int mid_num=2;
				int mid_den=1;
				while(true)
				{
					if(mid_num == num && mid_den == den)
						break;
					else if(((double)num/den) > ((double)mid_num/mid_den))
					{
						lower_num=mid_num;
						lower_den=mid_den;
						ans+="R";
					}
					else if(((double)num/den) < ((double)mid_num/mid_den))
					{
						up_num = mid_num;
						up_den = mid_den;
						ans+="L";
					}
					mid_num=up_num + lower_num;
					mid_den = up_den+lower_den;



				}
				System.out.println(ans);

			}
			else
			{
				String ans="L";
				int lower_num=0;
				int lower_den=1;

				int up_num=1;
				int up_den=1;

				int mid_num=1;
				int mid_den=2;
				while(true)
				{
					if(mid_num == num && mid_den == den)
						break;
					else if(((double)num/den) > ((double)mid_num/mid_den))
					{
						lower_num=mid_num;
						lower_den=mid_den;
						ans+="R";
					}
					else if(((double)num/den) < ((double)mid_num/mid_den))
					{
						up_num = mid_num;
						up_den = mid_den;
						ans+="L";
					}
					mid_num=up_num + lower_num;
					mid_den = up_den+lower_den;



				}
				System.out.println(ans);

			}
		}
	}

}
