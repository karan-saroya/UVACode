import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true)
		{

			String line=buf.readLine();
			StringTokenizer tok = new StringTokenizer(line);
			int f=Integer.parseInt(tok.nextToken());

			if(f == 0)
				break;
			int r=Integer.parseInt(tok.nextToken());
			int[] front = new int[f];
			int[] rear= new int[r];
			line = buf.readLine();
			tok = new StringTokenizer(line);
			for(int i=0;i<f;i++)
			{
				front[i] = Integer.parseInt(tok.nextToken());
			}
			line = buf.readLine();
			tok = new StringTokenizer(line);
			for(int i=0;i<r;i++)
			{
				rear[i] = Integer.parseInt(tok.nextToken());
			}

			double drive_ratio[] = new double[f*r];

			int count=0;
			for(int i=0;i<r;i++)
			{
				for(int j=0;j<f;j++,count++)
				{
					drive_ratio[count]=(double)rear[i]/front[j];
				}
			}
			Arrays.sort(drive_ratio);
			double spread[] = new double[f*r-1];
			for(int i=0;i<drive_ratio.length-1;i++)
			{

				spread[i]=drive_ratio[i+1]/drive_ratio[i];

			}
			double max_spread=0.0;
			for(int i=0;i<spread.length;i++)
			{
				if(spread[i] > max_spread )
					max_spread=spread[i];

			}
			DecimalFormat format = new DecimalFormat("#.00");
			System.out.println(format.format(max_spread));



		}
	}

}
