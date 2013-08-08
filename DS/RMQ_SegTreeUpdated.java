import java.io.*;
import java.util.*;
class Main
{
	static int[] tree;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line = buf.readLine();
		StringTokenizer tok = new StringTokenizer(line);
		int num_el=Integer.parseInt(tok.nextToken());
		int num_query= Integer.parseInt(tok.nextToken());
		int rest = (int)Math.round(Math.pow(2, Math.ceil(Math.log(num_el)/Math.log(2))))-1;
		int total = (int)(Math.pow(2,Math.ceil(Math.log(num_el)/Math.log(2)) + 1))-1;
		int actual_range=(int)Math.pow(2,Math.ceil(Math.log(num_el)/Math.log(2)));
		tree = new int[total+1];
		for(int i=1;i<tree.length;i++)
		{
			tree[i]=Integer.MAX_VALUE;
		}
		line=buf.readLine();
		tok  = new StringTokenizer(line);
		for(int i=rest+1;i<=num_el+rest;i++)
		{
			tree[i] = Integer.parseInt(tok.nextToken());
		}

		create_seg_tree(1,1,actual_range);

		update(1,1,actual_range,1,0);

	}
	static int create_seg_tree(int node, int left,int right )
	{
		if(left == right)
		{
			return tree[node];
		}
		else
		{
			int middle=(left+right)/2;
			int min_a=create_seg_tree(2*node,left,middle);
			int min_b=create_seg_tree(2*node+1,middle+1,right);
			tree[node] = Math.min(min_a,min_b);
			return tree[node];
		}


	}
	static int query(int node, int left, int right,int begin , int end)
	{
		if(left == begin && right == end)
			return tree[node];
		else
		{
			int mid = (left+right)/2;
			if(begin <= mid && end <=mid)
			{
				return query(2*node,left, mid, begin, end);

			}
			else if(begin > mid && end > mid)
			{
				return query(2*node+1,mid+1,right,begin,end);
			}
			else
			{
				return (Math.max(query(2*node,left, mid, begin, mid),query(2*node+1,mid+1,right,mid+1,end)));
			}


		}

	}
	static int update(int node, int left, int right,int pos, int val)
	{
		if(left == right)
			{
				tree[node] = val;
				return tree[node];
			}
		else
		{
			int mid=(left + right)/2;
			if(pos <= mid)
			{
				int min_a=update(2*node,left,mid,pos,val);
				int min_b=tree[2*node+1];
				tree[node] = Math.min(min_a, min_b);
				return tree[node];
			}
			else
		{
				int min_a=update(2*node+1,mid+1,right,pos,val);
				int min_b=tree[2*node];
				tree[node]=Math.min(min_a, min_b);
				return tree[node];
			}

		}

	}

}
