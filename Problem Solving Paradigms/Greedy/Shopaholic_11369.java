import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int cases= Integer.parseInt(buf.readLine());
		for(int i=0;i<cases;i++)
		{
			int num_items = Integer.parseInt(buf.readLine());
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			int array[]= new int[num_items+1];
			for(int j=1;j<=num_items;j++)
				array[j]=Integer.parseInt(tok.nextToken());

			Arrays.sort(array);
			int disc=0;
			for(int j=num_items-2;j>=1;j-=3)
				disc+=array[j];
			System.out.println(disc);



		}


	}

}
