import java.io.*;
import java.util.*;
class Main
{
	static char grid[][] = new char[1000][1000];
	static boolean visited[][] = new boolean[1000][1000];
	static int dim1=0,dim2=0;
	static cust cust_arr[]= new cust[26];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		 int cases= Integer.parseInt(buf.readLine());

		 for(int k=0;k<cases;k++)
		{
			TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			dim1 = Integer.parseInt(tok.nextToken());
			dim2 = Integer.parseInt(tok.nextToken());
			for(int i=0;i<dim1;i++)
			{
				for(int j=0;j<dim2;j++)
				{
					grid[i][j] = 0;
					visited[i][j] = false;
				}
			}

			for(int i=0;i<dim1;i++)
			{
				String temp=buf.readLine();
				for(int j=0;j<temp.length();j++)
				{
					grid[i][j] = temp.charAt(j);
					if(!map.containsKey(temp.charAt(j)))
						map.put(temp.charAt(j), 0);
				}
			}
			int comp=0;
			for(int i=0;i<dim1;i++)
			{
				for(int j=0;j<dim2;j++)
				{
					if(visited[i][j] == false )
						{
							dfs(i,j);
							map.put(grid[i][j], map.get(grid[i][j]) +1);
						}
				}
			}

			Set set = map.entrySet();
			Iterator iter = set.iterator();
			System.out.println("World #"+(k+1));

			int size=0;
			while(iter.hasNext())
			{
				Map.Entry<Character, Integer> obj = (Map.Entry<Character, Integer>)(iter.next());
				cust_arr[size] = new cust(obj.getKey(),obj.getValue());
				size++;
			}
			Arrays.sort(cust_arr,0,size);
			for(int i=0;i<size;i++)
			{
				System.out.println(cust_arr[i].sym+": "+cust_arr[i].states);
			}

		}
	}
	static void dfs(int x, int y)
	{
		visited[x][y] =true;
		if(x-1 >=0 && visited[x-1][y] == false && grid[x-1][y] == grid[x][y])
		{
			dfs(x-1,y);
		}
		if(x+1 <dim1 && visited[x+1][y] == false&& grid[x+1][y] == grid[x][y])
		{
			dfs(x+1,y);
		}
		if(y-1 >=0 && visited[x][y-1] == false && grid[x][y-1] == grid[x][y])
		{
			dfs(x,y-1);
		}
		if(y+1 <dim2 && visited[x][y+1] == false&& grid[x][y+1] == grid[x][y])
		{
			dfs(x,y+1);
		}

	}

}
class cust implements Comparable
{
	char sym;
	int states;
	cust(char c_sym, int c_states)
	{
		sym = c_sym;
		states = c_states;
	}
	public int compareTo(Object arg0)
	{
		cust obj = (cust)arg0;
		if(states > obj.states)
			return -1;
		else if(states < obj.states)
			return 1;
		else
		{
			if(sym < obj.sym)
				return -1;
			else
				return 1;
		}
	}


}
