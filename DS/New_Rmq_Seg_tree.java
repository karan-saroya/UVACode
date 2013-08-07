import java.io.*;
public class RMQ_SegTree
{
	static int[] tree;
	public static void main(String[] args) throws Exception
	{
		int num_el;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		num_el=Integer.parseInt(buf.readLine());
		int rest =(int)Math.round(Math.pow(2, Math.ceil(Math.log(num_el)/Math.log(2))))-1;
		tree = new int[rest+num_el+1];
		for(int i=rest+1;i<=rest+num_el;i++)
			tree[i]=Integer.parseInt(buf.readLine());
		create_seg_tree(1,1,num_el);
		System.out.println("Enter the lower limt of the range");
		int low= Integer.parseInt(buf.readLine());
		System.out.println("Enter the upper limit of the range");
		int high = Integer.parseInt(buf.readLine());
		System.out.println(rmq(1,1,num_el,low,high));
		System.out.println("");
		System.out.println("Enter the index of updation");
		int pos= Integer.parseInt(buf.readLine());
		System.out.println("Enter the new value");
		int new_value= Integer.parseInt(buf.readLine());
		update(1,1,num_el,pos,new_value);
	}
	static int create_seg_tree(int parent,int left, int right)
	{
		if(left == right)
			return tree[parent];
		else
		{
			int middle= (left+right)/2;
			int min_a=create_seg_tree(2*parent,left,middle);
			int min_b=create_seg_tree(2*parent+1,middle+1,right);
			tree[parent]=Math.min(min_a, min_b);
			return tree[parent];
		}

	}
	static int inorder(int root)
	{
		if(root < tree.length)
		{
			inorder(2*root);
			System.out.print(tree[root]+"\t");
			inorder(2*root+1);
			return 1;
		}
		else
			return 0;

	}
	static int rmq(int node,int left, int right,int begin, int end)
	{

		if(left == begin && right == end)
		{
			return tree[node];
		}
		else
		{
			int middle = (left+right)/2;


			if(begin<=middle && end <= middle)
			{
				return rmq(2*node,left, middle,begin,end);
			}
			else if(begin > middle && end > middle)
			{
				return rmq(2*node+1,middle+1,right,begin,end);
			}
			else
			{
				int min_a= rmq(2*node,left, middle,begin,middle);
				int min_b= rmq(2*node+1,middle+1,right,middle+1,end);
				return Math.min(min_a, min_b);
			}

		}

	}
	static int update(int node,int left, int right, int pos, int val)
	{
		if(left == right )
		{
			tree[node]=val;
			return tree[node];
		}
		else
		{
			int middle = (left + right)/2;
			if(pos <= middle)
			{
				int min_a=update(2*node,left,middle,pos,val);
				int min_b=tree[2*node+1];
				tree[node]=Math.min(min_a, min_b);
				return tree[node];

			}
			else
			{
				int min_a=update(2*node+1,middle+1,right,pos,val);
				int min_b=tree[2*node];
				tree[node]=Math.min(min_a, min_b);
				return tree[node];
			}

		}

	}


}