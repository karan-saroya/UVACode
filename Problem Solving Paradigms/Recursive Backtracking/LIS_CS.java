import java.io.*;
import java.util.*;
public class LIS_CS
{
	static int max_length=0;
	static String max_path="";
	static int[] array;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(buf.readLine());
		array =new int[size];
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<size;i++)
			array[i]= Integer.parseInt(tok.nextToken());
		for(int i=0;i<size;i++)
		{
			 lis(i," "+array[i],size,1);
		}
		System.out.println(max_length+" "+ max_path);
	}
	public static void lis(int curr, String path, int size, int length)
	{
		if(curr == size-1)
		{
			if(length > max_length)
			{
				max_length=length;
				max_path=path;
			}
			return;
		}
		else
		{
			for(int i=curr+1;i<size;i++)
			{
				if(array[i] > Integer.parseInt(path.substring(path.lastIndexOf(" ")+1)))
				{
					lis(i,path+" "+array[i],size,length+1);
				}
				else
				{
					lis(i,path,size,length);
				}
			}

		}
	}

}
