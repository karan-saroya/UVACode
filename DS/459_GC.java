import java.io.*;
class Main
{
	static int p[];
	static int size[];


	public static void main(String[] args) throws Exception
	{
		p=new int[27];
		size=new int[27];

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases=Integer.parseInt(buf.readLine());
		buf.readLine();


		for(int i=0;i<num_cases;i++)
		{
				int len=((int)buf.readLine().charAt(0)-64);
				for(int j=1;j<=len;j++)
						make_set(j);
				String str="";
				while(true)
				{
					str = buf.readLine();
					if(str == null || str.equals(""))
						break;
					if((int)str.charAt(0)-64 <= len && (int)str.charAt(1)-64 <=len)
						union((int)str.charAt(0)-64, (int)str.charAt(1)-64);
				}
				int count=0;
				for(int j=1;j<=len;j++)
				{
					if(p[j] == j)
						count++;
				}
				System.out.println(count);
				if(i != num_cases-1)
					System.out.println("");

				for(int j=1;j<=len;j++)
				{
					p[j]=j;
					size[j]=1;
				}
		}


	}
	static void make_set(int x)
	{
		p[x]=x;
		size[x]=1;
	}
	static int find(int x)
	{
		int par=x;
		while(p[par]!=par)
		{
			par=p[par];
		}
		return par;
	}
	static void union(int x, int y)
	{
		int par_x= find(x);
		int par_y= find(y);
		if(par_x!= par_y)
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
