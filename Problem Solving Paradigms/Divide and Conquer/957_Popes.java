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
			int y= Integer.parseInt(line);
			int num_popes= Integer.parseInt(buf.readLine());
			int arr[] = new int[num_popes];
			for(int i=0;i<num_popes;i++)
				arr[i]= Integer.parseInt(buf.readLine());
			int max=0;
			int beg=0;
			int end=0;
			for(int i=0;i<num_popes;i++)
			{
				int upper_lim = arr[i]+y-1;
				int ret= Arrays.binarySearch(arr, upper_lim);
				if(ret < 0)
				{
					int pos=-ret-1;
					if(pos <arr.length)
					{
						if(pos - i  > max)
						{

							max=pos-i;
							beg=arr[i];
							end = arr[pos-1];
						}

					}
					else
					{
						if(arr.length-i > max)
						{
							max=arr.length-i;
							beg=arr[i];
							end=arr[pos-1];
						}

					}


				}
				else
				{
					int j=0;
					for( j=ret+1;j<arr.length;j++)
					{
						if(arr[j] > arr[ret])
							break;
					}
					if(j-i > max)
						{
							max=j-i;
							beg=arr[i];
							end=arr[ret];
						}

				}


			}

			System.out.println(max+" "+beg+" "+end);

			buf.readLine();
		}

	}

}
