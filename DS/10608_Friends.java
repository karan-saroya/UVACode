import java.io.*;
import java.util.*;
class Main
{
	 int p[];
	 int size[];


	public static void main(String[] args) throws Exception
	{

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases=Integer.parseInt(buf.readLine());


		for(int i=0;i<num_cases;i++)
		{
				Main obj= new Main();
				StringTokenizer tok = new StringTokenizer(buf.readLine());
				int len= Integer.parseInt(tok.nextToken());
				int num_lines = Integer.parseInt(tok.nextToken());
				obj.p= new int[len+1];
				obj.size= new int[len+1];
				for(int j=1;j<=len;j++)
					obj.make_set(j);
				for(int j=0;j<num_lines;j++)
				{
					tok= new StringTokenizer(buf.readLine());
					int first= Integer.parseInt(tok.nextToken());
					int sec = Integer.parseInt(tok.nextToken());
					obj.union(first, sec);

				}
				int max=0;
				for(int j=1;j<=len;j++)
				{
					if(obj.size[j] > max)
						max=obj.size[j];
				}
				System.out.println(max);

		}


	}
	 void make_set(int x)
	{
		p[x]=x;
		size[x]=1;
	}
	int find(int x)
	{
		int par=x;
		while(p[par]!=par)
		{
			par=p[par];
		}
		return par;
	}
	void union(int x, int y)
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
