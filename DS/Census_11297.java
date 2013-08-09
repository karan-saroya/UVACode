import java.io.*;
import java.util.*;
class Main
{
	static int min_tree[][];
	static int max_tree[][];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok= new StringTokenizer(buf.readLine());
		int n=Integer.parseInt(tok.nextToken());
		int rest =(int) Math.round(Math.pow(2,Math.ceil(Math.log(n)/Math.log(2))))-1;
		int total  = (int) Math.round(Math.pow(2, Math.ceil(Math.log(n)/Math.log(2))+1))-1;
		int actual_range = (int) Math.round(Math.pow(2,Math.ceil(Math.log(n)/Math.log(2))));
		//System.out.println(actual_range);
		min_tree = new int[n+1][total+1];
		max_tree = new int[n+1][total+1];
		for(int i=1;i<min_tree.length;i++)
		{
			for(int j=1;j<=n;j++)
			{
				max_tree[i][j]=Integer.MIN_VALUE;
				min_tree[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=1;i<min_tree.length;i++)
		{
			tok= new StringTokenizer(buf.readLine());
			for(int j=rest+1;j<=rest+n;j++)
			{
				min_tree[i][j]=Integer.parseInt(tok.nextToken());
				max_tree[i][j]=min_tree[i][j];
			}
		}



		for(int i=1;i<min_tree.length;i++)
			{
				create_min_seg_tree(i,1,1,actual_range);
				create_max_seg_tree(i,1,1,actual_range);
			}
		int q=Integer.parseInt(buf.readLine());
		for(int i=0;i<q;i++)
		{
			String line=buf.readLine();
			tok = new StringTokenizer(line);
			tok.nextToken();
			if(line.charAt(0) == 'q')
			{
				int s_city=Integer.parseInt(tok.nextToken());
				int s_region = Integer.parseInt(tok.nextToken());
				int e_city=Integer.parseInt(tok.nextToken());
				int e_region = Integer.parseInt(tok.nextToken());

				int min=Integer.MAX_VALUE,max=0;
				for(int j=s_city;j<=e_city;j++)
				{
					int temp=min_query(j,1,1,actual_range,s_region,e_region);
					min = temp<min?temp:min;
					temp=max_query(j,1,1,actual_range,s_region,e_region);
					max = temp > max ? temp:max;
				}
				System.out.println(max+" "+min);

			}
			else
			{
				int city = Integer.parseInt(tok.nextToken());
				int region =Integer.parseInt(tok.nextToken());
				int value = Integer.parseInt(tok.nextToken());
				min_update(city,1,1,actual_range,region,value);
				max_update(city,1,1,actual_range,region,value);
			}

		}



	}
	static int create_min_seg_tree(int city,int node,int left, int right)
	{
		if(left == right)
			return min_tree[city][node];
		else
		{
			int mid=(left+right)/2;
			int min_a=create_min_seg_tree(city,2*node,left,mid);
			int min_b= create_min_seg_tree(city,2*node+1,mid+1,right);
			min_tree[city][node]=Math.min(min_a,min_b);
			return min_tree[city][node];
		}

	}
	static int create_max_seg_tree(int city,int node,int left, int right)
	{
		if(left == right)
			return max_tree[city][node];
		else
		{
			int mid=(left+right)/2;
			int max_a=create_max_seg_tree(city,2*node,left,mid);
			int max_b= create_max_seg_tree(city,2*node+1,mid+1,right);
			max_tree[city][node]=Math.max(max_a,max_b);
			return max_tree[city][node];
		}

	}
	static int min_query(int city,int node,int left, int right, int begin, int end)
	{
		if(left == begin && right == end)
		{
			return min_tree[city][node];
		}
		else
		{
			int mid=(left+right)/2;
			if(begin <= mid && end <= mid)
			{
				return min_query(city,2*node,left,mid,begin,end);
			}
			else if(begin > mid && end > mid)
			{
				return min_query(city, 2*node+1,mid+1,right,begin,end);
			}
			else
			{
				int min_a=min_query(city,2*node,left,mid,begin,mid);
				int min_b= min_query(city,2*node+1,mid+1, right,mid+1,end);
				return Math.min(min_a, min_b);
			}

		}

	}

	static int max_query(int city,int node,int left, int right, int begin, int end)
	{
		if(left == begin && right == end)
		{
			return max_tree[city][node];
		}
		else
		{
			int mid=(left+right)/2;
			if(begin <= mid && end <= mid)
			{
				return max_query(city,2*node,left,mid,begin,end);
			}
			else if(begin > mid && end > mid)
			{
				return max_query(city, 2*node+1,mid+1,right,begin,end);
			}
			else
			{
				int max_a=max_query(city,2*node,left,mid,begin,mid);
				int max_b= max_query(city,2*node+1,mid+1, right,mid+1,end);
				return Math.max(max_a, max_b);
			}

		}

	}

	static int min_update(int city,int node,int left, int right, int pos, int val)
	{
		if(left == right)
		{
			min_tree[city][node]=val;
			return min_tree[city][node];
		}
		else
		{
			int mid = (left+right)/2;
			if(pos <= mid)
			{
				int min_a=min_update(city,2*node,left,mid,pos,val);
				min_tree[city][node]=Math.min(min_a, min_tree[city][2*node+1]);
				return min_tree[city][node];
			}
			else
			{
				int min_a=min_update(city,2*node+1,mid+1,right,pos,val);
				min_tree[city][node]=Math.min(min_a, min_tree[city][2*node]);
				return min_tree[city][node];
			}

		}

	}
	static int max_update(int city,int node,int left, int right, int pos, int val)
	{
		if(left == right)
		{
			max_tree[city][node]=val;
			return max_tree[city][node];
		}
		else
		{
			int mid = (left+right)/2;
			if(pos <= mid)
			{
				int max_a=max_update(city,2*node,left,mid,pos,val);
				max_tree[city][node]=Math.max(max_a, max_tree[city][2*node+1]);
				return max_tree[city][node];
			}
			else
			{
				int max_a=max_update(city,2*node+1,mid+1,right,pos,val);
				max_tree[city][node]=Math.max(max_a, max_tree[city][2*node]);
				return max_tree[city][node];
			}

		}

	}


}
