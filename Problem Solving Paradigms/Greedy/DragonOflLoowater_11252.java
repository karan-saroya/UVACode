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
			int n = Integer.parseInt(tok.nextToken());
			int m = Integer.parseInt(tok.nextToken());
			if(n == 0 && m == 0)
				break;
			long heads[] = new long[n];
			ArrayList<Long> heights = new ArrayList<Long>(m);
			for(int i=0;i<n;i++)
				heads[i]= Long.parseLong(buf.readLine());
			for(int i=0;i<m;i++)
				heights.add( Long.parseLong(buf.readLine()));

			if(m < n)
			{
				System.out.println("Loowater is doomed!");

			}
			else
			{

				Collections.sort(heights);
				long sum=0;
				boolean found=true;
				for(int i=0;i<n;i++)
				{
					int ret=Collections.binarySearch(heights,heads[i]);
					if(ret >=0)
					{
						long num=heights.get(ret);
						heights.remove(ret);
						sum+=num;

					}
					else
					{
						int pos = -ret-1;
						if(pos == heights.size())
						{
							found=false;
							break;

						}
						else
						{
							long num=heights.get(pos);
							heights.remove(pos);
							sum+=num;


						}
					}
				}
				if(found)
				{
					System.out.println(sum);
				}
				else
				{
					System.out.println("Loowater is doomed!");
				}

			}
		}

	}

}
