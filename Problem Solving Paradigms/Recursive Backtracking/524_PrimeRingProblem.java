import java.io.*;
import java.util.*;
class Main
{
	static boolean flag[];
	static boolean is_prime[];
	static ArrayList<ArrayList<Integer>> arr;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		flag= new boolean[17];

		is_prime = new boolean[]{false,false,true,true,false,true,false,true,false,false,false,true,false,true,false,false,false,true,false,true,false,false,false,true,false,false,false,false,false,true,false,true,false,false};
		int case_num=1;
		arr= new ArrayList<ArrayList<Integer>>();
		for(int i=1;i<=16;i++)
		{
			ArrayList<Integer> temp= new ArrayList<Integer>();
			if(i %2 == 1)
			{
				for(int j=2;j<=16;j+=2)
				{
					if(j != i && is_prime[j+i])
					{
						temp.add(j);
					}
				}
			}
			else
			{
				for(int j=3;j<=16;j+=2)
				{
					if(j != i && is_prime[j+i])
					{
						temp.add(j);
					}
				}

			}
			arr.add(temp);
		}
		while((line=buf.readLine())!= null && !line.equals(""))
		{
			if(case_num > 1)
			{
				System.out.println("");
			}
			for(int i=0;i<flag.length;i++)
				{
					flag[i]=false;

				}

			flag[1]=true;
			int n = Integer.parseInt(line);
			if(n == 1)
			{
				System.out.println("Case "+(case_num++)+":");
				System.out.println("1");
			}
			else
			{
				System.out.println("Case "+(case_num++)+":");

				compute_arr(2,n,"1",1);


			}

		}

	}
	static void compute_arr(int curr_pos, int num,String path, int prev)
	{
		if(curr_pos == num)
		{
			for(int i=2;i<=num;i+=2)
			{
				if(is_prime[1+i] && flag[i] == false && is_prime[prev+i])
				{
					System.out.println(path+" "+i);
				}
			}

			return;
		}
		else
		{
				ArrayList<Integer> temp= arr.get(prev-1);
				for(int i=0;i<temp.size();i++)
				{
					if(temp.get(i) > num)
						break;
					if(flag[temp.get(i)] == false)
					{
						flag[temp.get(i)] = true;
						compute_arr(curr_pos+1,num,path+" "+temp.get(i),temp.get(i));
						flag[temp.get(i)] = false;
					}
				}



		}

	}

}
