import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(buf.readLine());
		int arr[] = new int[n];
		StringTokenizer tok =new StringTokenizer(buf.readLine());
		for(int i=0;i<n;i++)
			arr[i]= Integer.parseInt(tok.nextToken());

		int q = Integer.parseInt(buf.readLine());
		tok = new StringTokenizer(buf.readLine());
		for(int i=0;i<q;i++)
		{
			int item= Integer.parseInt(tok.nextToken());

			int ret=Arrays.binarySearch(arr, item);
			if(ret >=0)
			{

				int pos = ret;
				int j=0;
				boolean flag=true;
				for( j=pos;j>=0;j--)
				{
					if(arr[j]< item)
					{
						flag=false;
						break;
					}
				}
				int min=0;
				if(flag == true)
				{
					min=-1;
				}
				else
				{
					min=arr[j];
				}
				j=pos;
				flag=true;
				for(j=pos;j<arr.length;j++)
				{
					if(arr[j]> item)
					{
						flag=false;
						break;
					}
				}
				int max=0;
				if(flag)
				{
					max=-1;
				}
				else
				{
					max=arr[j];
				}

				String ans= min == -1 ? "X":min+"";
				ans+=" "+(max==-1?"X":max+"");
				System.out.println(ans);


			}
			else
			{
				int pos = -ret-1;
				int j=0;
				boolean flag=true;
				if(pos >= arr.length )
				{
					for( j=pos-1;j>=0;j--)
					{
						if(arr[j]< item)
						{
							flag=false;
							break;
						}
					}
					int min=0;
					if(flag == true)
					{
						min=-1;
					}
					else
					{
						min=arr[j];
					}
					j=pos;
					flag=true;
					for(j=pos;j<arr.length;j++)
					{
						if(arr[j]> item)
						{
							flag=false;
							break;
						}
					}
					int max=0;
					if(flag)
					{
						max=-1;
					}
					else
					{
						max=arr[j];
					}

					String ans= min == -1 ? "X":min+"";
					ans+=" "+(max==-1?"X":max+"");
					System.out.println(ans);



				}
				else
				{
					for( j=pos;j>=0;j--)
					{
						if(arr[j]< item)
						{
							flag=false;
							break;
						}
					}
					int min=0;
					if(flag == true)
					{
						min=-1;
					}
					else
					{
						min=arr[j];
					}
					j=pos;
					flag=true;
					for(j=pos;j<arr.length;j++)
					{
						if(arr[j]> item)
						{
							flag=false;
							break;
						}
					}
					int max=0;
					if(flag)
					{
						max=-1;
					}
					else
					{
						max=arr[j];
					}

					String ans= min == -1 ? "X":min+"";
					ans+=" "+(max==-1?"X":max+"");
					System.out.println(ans);
				}
			}

		}



	}

}
