import java.io.*;
import java.util.*;
class Main
{
	int p[];
	int size[];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
		int num_cases=Integer.parseInt(buf.readLine());
		buf.readLine();
		for(int i=0;i<num_cases;i++)
		{
			Main obj = new Main();
			int num_comp=Integer.parseInt(buf.readLine());

			obj.p = new int[num_comp+1];
			obj.size = new int[num_comp+1];


			for(int j=1;j<=num_comp;j++)
			{
				obj.make_set(j);
			}

			String str="";
			int yes=0,no=0;
			while(true)
			{
				str=buf.readLine();

				if(str ==  null  || str.equals(""))
					break;

				StringTokenizer tok = new StringTokenizer(str);
				char c=tok.nextToken().charAt(0);
				int first= Integer.parseInt(tok.nextToken());
				int second= Integer.parseInt(tok.nextToken());
				if(c == 'c')
				{
					obj.union(first, second);
				}
				else
				{
					if(obj.find(first) == obj.find(second))
						yes++;
					else
						no++;
				}

			}

			System.out.println(yes+","+no);

			if(i != num_cases-1)
				System.out.println("");

			for(int j=1;j<=num_comp;j++)
			{
				obj.p[j]=j;
				obj.size[j]=1;
			}





		}


	}
	void make_set(int x)
	{
		p[x]=x;
		size[x]=1;
	}
	int find(int x)
	{
		int par_x=x;
		while(par_x != p[par_x])
		{
			par_x=p[par_x];
		}
		return par_x;
	}
	void union(int x, int y)
	{
		int par_y=find(y);
		int par_x=find(x);

		if(par_y != par_x)
		{
			if(size[par_x] >= size[par_y])
			{
				p[par_y]=par_x;
				size[par_x]+=size[par_y];
			}
			else
			{
				p[par_x]=par_y;
				size[par_y]+=size[par_x];
			}


		}

	}


}
