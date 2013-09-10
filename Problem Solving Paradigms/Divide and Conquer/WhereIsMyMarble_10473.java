import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		int num_cases=1;
		while((line= buf.readLine())!= null && !line.equals(""))
		{
			StringTokenizer tok = new StringTokenizer(line);
			int n = Integer.parseInt(tok.nextToken());
			if(n == 0)
				break;
			int q = Integer.parseInt(tok.nextToken());
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]= Integer.parseInt(buf.readLine());
			}
			Arrays.sort(arr);
			System.out.println("CASE# "+num_cases+":");
			for(int i=0;i<q	;i++)
			{
				int item=Integer.parseInt(buf.readLine());
				int ret=Arrays.binarySearch(arr,item);
				if(ret < 0)
				{
					System.out.println(item +" not found");
				}
				else
				{
					int j=ret;
					for( j=ret;j>=0;j--)
					{
						if(arr[j] != arr[ret])
							break;

					}
					j=j+2;
					System.out.println(item+" found at "+j);
				}
			}
			num_cases++;
		}


	}


}
