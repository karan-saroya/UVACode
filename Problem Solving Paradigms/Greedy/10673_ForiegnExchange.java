import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line ="";
		while(Integer.parseInt(line=buf.readLine())!=0)
		{
			int size= Integer.parseInt(line);
			if(size == 0)
				break;
			int first_arr[] = new int[size];
			int sec_arr[] = new int[size];
			for(int i=0;i<size;i++)
 			{
 				StringTokenizer tok = new StringTokenizer(buf.readLine());
 				first_arr[i]=Integer.parseInt(tok.nextToken());
 				sec_arr[i] = Integer.parseInt(tok.nextToken());

 			}
			Arrays.sort(first_arr);
			Arrays.sort(sec_arr);
			int i=0;
			for( i=0;i<first_arr.length;i++)
			{
				if(first_arr[i] != sec_arr[i])
					break;
			}
 			if(i != first_arr.length)
 				System.out.println("NO");
 			else
 				System.out.println("YES");

		}


	}

}
