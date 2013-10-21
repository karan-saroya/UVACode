import java.io.*;
import java.util.*;
public class Main
{
	static ArrayList<Integer> heights;
	static int[] len_seq;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int count=0;
		while(true)
		{
			String line=buf.readLine();
			if(Integer.parseInt(line) == -1)
				break;
			count++;

			heights= new ArrayList<Integer>();
			heights.add(Integer.parseInt(line));
			while(Integer.parseInt(line= buf.readLine()) != -1)
			{
				heights.add(Integer.parseInt(line));

			}
			int size = heights.size();
			len_seq= new int[size];
			int max=0;

			for(int i=size-1;i>=0;i--)
			{
				int temp= lnis(i,size-1);
				if(temp > max)
					max=temp;
			}
			if(count != 1)
				System.out.println("");
			System.out.println("Test #"+count+":");
			System.out.println("  maximum possible interceptions: "+max);
		}

	}
	static int lnis(int curr_node,int size)
	{
		if(size == curr_node)
		{
			if(len_seq[curr_node] == 0)
			{
				len_seq[curr_node] = 1;
				return len_seq[curr_node];
			}
			else
				return len_seq[curr_node];
		}
		else
		{
			int max=0;
			if(len_seq[curr_node] != 0)
				return len_seq[curr_node];
			else
			{
				for(int i=curr_node+1;i<=size;i++)
				{
					int temp= lnis(i,size);
					if(temp > max && heights.get(curr_node) >= heights.get(i))
						max=temp;
				}
			}
			len_seq[curr_node]= max+1;
			return len_seq[curr_node];
		}

	}


}
