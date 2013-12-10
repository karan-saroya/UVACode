import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(buf.readLine());
		buf.readLine();
		for(int i=0;i<num_cases;i++)
		{
			if(i != 0 )
				System.out.println("");
			String line="";
			ArrayList<String> list = new ArrayList<String>();
			while((line = buf.readLine()) != null && !line.equals(""))
			{
				list.add(line);
			}

			int[][] grid = new int[list.size()][list.size()];

			for(int j=0;j<grid.length;j++)
			{
				String str= list.get(j);
				for(int k=0;k<grid[j].length;k++)
				{
					if(Integer.parseInt(str.charAt(k)+"") == 0)
						grid[j][k] =-1000;
					else
						grid[j][k] = 1;
				}
			}

			int max_sum=Integer.MIN_VALUE;
			for(int j=0;j<grid.length;j++)
			{
				int temp[] = new int[grid.length];
				for(int k=j;k<grid.length;k++)
				{
					for(int l=0;l<grid.length;l++)
						temp[l] += grid[l][k];

					int sum = temp[grid.length-1];
					int kad[] = new int[grid.length];
					kad[grid.length-1] = temp[grid.length - 1];
					for(int l=grid.length-1;l>=1;l--)
					{
						if(kad[l] + temp[l-1] > temp[l-1])
							kad[l-1] = kad[l] + temp[l-1];
						else
							kad[l-1] = temp[l-1];
						if(kad[l-1] > sum)
							sum = kad[l-1];
					}

					if(max_sum < sum)
						max_sum=sum;

				}

			}
			if(max_sum == -1000)
				System.out.println("0");
			else
				System.out.println(max_sum);


		}

	}

}
