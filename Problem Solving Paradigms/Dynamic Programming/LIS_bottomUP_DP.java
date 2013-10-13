import java.io.*;
import java.util.*;
public class Main
{
	static String[] paths;
	static int[] array;
	static int[] memo;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(buf.readLine());
		array =new int[size];
		paths= new String[size];
		memo= new int[size];
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<size;i++)
			{
				array[i]= Integer.parseInt(tok.nextToken());
				memo[i]=-1;
			}
		int max=0;
		int pos=-1;
		for(int i=size-1;i>=0;i--)
		{
			 int temp=lis(i,array[i]+" ",size,1);
			 if(temp > max)
				 {
				 	max=temp;
				 	pos=i;
				 }
		}
		System.out.println(max+" "+paths[pos]);
	}
	public static int lis(int curr, String path, int size, int length)
	{
		if(curr == size-1)
		{
			if(memo[curr] == -1)
			{
				memo[curr]=length;
				paths[curr]=path;
				return memo[curr];
			}
			else
			{
				return memo[curr];
			}

		}

		else
		{

			int max=0;
			String temp="";
			for(int i=curr+1;i<size;i++)
			{
					if(memo[i]  > max && array[curr]<Integer.parseInt(paths[i].substring(0,paths[i].indexOf(" "))))
					{
						temp=paths[i];

						max=memo[i];

					}


			}

			paths[curr] = array[curr]+" "+temp;
			memo[curr]=max+1;
			return memo[curr];

		}
	}

}
