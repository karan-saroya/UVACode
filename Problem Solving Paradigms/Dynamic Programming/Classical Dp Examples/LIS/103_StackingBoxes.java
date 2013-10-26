import java.io.*;
import java.util.*;
public class Main
{
	public static Box[] boxes;
	public static String[] paths;
	public static int[] len_seq;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		while((line= buf.readLine()) != null && !line.equals(""))
		{
			StringTokenizer tok = new StringTokenizer(line);
			int num_boxes = Integer.parseInt(tok.nextToken());
			int dim = Integer.parseInt(tok.nextToken());
			boxes = new Box[num_boxes+1];
			 paths = new String[num_boxes+1];
			len_seq= new int[num_boxes+1];
			for(int i=0;i<=num_boxes;i++)
				paths[i]="";
			for(int i=1;i<=num_boxes;i++)
			{
				int temp[] = new int[dim];
				tok = new StringTokenizer(buf.readLine());
				for(int j=0;j<dim;j++)
					temp[j] = Integer.parseInt(tok.nextToken());

				Arrays.sort(temp);
				boxes[i] = new Box(temp,i);
			}
			Arrays.sort(boxes,new cust_comp());
			int max=Integer.MIN_VALUE;
			int pos=-1;
			for(int i=num_boxes;i>=1;i--)
			{
				int temp= lis(i,num_boxes);
				if(temp > max)
					{
						max=temp;
						pos = i;
					}
			}
			System.out.println(max);
			System.out.println(paths[pos]);
		}

	}
	public static int lis(int curr_node,int num_boxes)
	{
		if(curr_node == num_boxes)
		{
			if(len_seq[curr_node]  == 0)
			{
				paths[curr_node] = boxes[curr_node].pos+" ";
				len_seq[curr_node]=1;
				return len_seq[curr_node];
			}
			else
			{
				return len_seq[curr_node];
			}
		}

		else
		{
			if(len_seq[curr_node] != 0)
				return len_seq[curr_node];
			int max=0;
			int pos=0;
			for(int i=curr_node+1;i<=num_boxes;i++)
			{
			  	int temp = lis(i,num_boxes);
			  	int box_no=curr_node;

			  	if(temp > max && boxes[i].can_nest(boxes[box_no]))
			  	{
			  		max=temp;
			  		pos=i;
			  	}
			}

			len_seq[curr_node]=max+1;
			paths[curr_node]=boxes[curr_node].pos+" "+paths[pos];
			return len_seq[curr_node];
		}
	}

}
class Box
{
	int[] dim;
	int pos;
	public Box()
	{

	}
	public Box(int[] c_dim,int cpos)
	{
		dim = c_dim;
		pos=cpos;
	}
	public boolean can_nest(Box b1)
	{
		if(dim.length != b1.dim.length)
			return false;
		else
		{
			boolean flag= true;
			for(int i=0;i<dim.length;i++)
			{
				if(b1.dim[i] >= dim[i])
				{
					flag=false;
					break;
				}
			}
			return flag;
		}
	}

}
class cust_comp implements Comparator
{


	public int compare(Object o1, Object o2)
	{
		if(o1 == null|| o2 == null)
			return 0;
	  Box box1,box2;
	  box1=(Box)o1;
	  box2=(Box)o2;
	  int flag=0;
	  for(int i=0;i<box1.dim.length;i++)
	  {
		  if(box1.dim[i] != box2.dim[i])
			  {
			  	flag=1;
			  	break;
			  }
	  }
	  	  if(flag == 0)
	  		  return flag;

		  flag=-1;
		  for(int i=0;i<box1.dim.length;i++)
		  {
			  if(box1.dim[i] > box2.dim[i])
				  {
				  	flag=1;
				  	break;
				  }
		  }
		  if(flag == -1)
			  return flag;

		  flag=1;
		  for(int i=0;i<box1.dim.length;i++)
		  {
			  if(box1.dim[i] < box2.dim[i])
				  {
				  	flag=-1;
				  	break;
				  }
		  }
		 if(flag == 1)
			 return flag;
		 else
			 return 0;
	}

}