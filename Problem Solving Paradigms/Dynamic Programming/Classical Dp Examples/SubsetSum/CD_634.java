import java.io.*;
import java.util.*;
class Main
{
	static int dur[];
	static int memo[][];
	static int gmin = Integer.MAX_VALUE;
	static String path="";
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		while((line=buf.readLine()) != null && !line.equals(""))
		{
			path="";
			gmin= Integer.MAX_VALUE;
			StringTokenizer tok = new StringTokenizer(line);
			int sum = Integer.parseInt(tok.nextToken());
			int num_songs = Integer.parseInt(tok.nextToken());
			dur = new int[num_songs];
			memo= new int[num_songs][sum+1];
				for(int i=0;i<memo.length;i++)
			{
				for(int j=0;j<memo[i].length;j++)
				{
					if(j == 0)
						memo[i][j] =0;
					else
						memo[i][j] = -1;

				}
			}

			for(int i=0;i<dur.length;i++)
				{
					dur[i] = Integer.parseInt(tok.nextToken());

				}

			int ret=sum-ss(sum,0,"");
			System.out.println(path.substring(1)+" sum:"+ret);

		}
	}
	static int ss(int bal, int curr_pos,String curr_path)
	{
		if(bal == 0)
		{
			if(bal < gmin)
			{
				gmin=bal;
				path=curr_path;
			}
			return 0;

		}
		else if(bal < 0)
			return Integer.MAX_VALUE;
		else if(curr_pos == dur.length)
			{
				if(bal < gmin)
				{
					gmin=bal;
					path=curr_path;
				}
				return bal;
			}
		else
		{
			if(memo[curr_pos][bal] != -1)
				return memo[curr_pos][bal];
			int min = Integer.MAX_VALUE;
			for(int i=curr_pos;i<dur.length;i++)
			{
				int temp  = ss(bal - dur[i] , i+1,curr_path+" "+ dur[i]);
				if(temp < min)
					{
						min = temp;
						if(min < gmin)
						{
							gmin=min;
							path=curr_path;
						}
					}
			}
			if(bal < min)
			{
					min = bal;
					if(min < gmin)
					{
						gmin=min;
						path=curr_path;
					}
			}

			memo[curr_pos][bal]=min;
			return min;

		}

	}


}