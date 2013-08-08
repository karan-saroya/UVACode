#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>
int *tree;
int create_seg_tree(int node,int left, int right)
{
	if(left == right)
		return tree[node];
	else
	{
		int mid= (left + right)/2;
		int sum_a= create_seg_tree(2*node, left,mid);
		int sum_b = create_seg_tree(2*node +1, mid+1, right);
		tree[node]= sum_a+ sum_b;
		return tree[node]; 	
		
	}
}
int query(int node,int left, int right, int begin ,int end)
{
	if(left == begin &&right == end)
	{
		return tree[node];
	}
	else
	{	
		int mid=(left+right)/2;
		if(begin<= mid && end <= mid)
		{
			return query(2*node,left, mid, begin, end);
		}
		else if(begin> mid && end > mid)
		{
			return query(2*node+1,mid+1, right, begin, end);
		}
		else
		{
			int sum_a=query(2*node,left, mid, begin, mid);
			int sum_b=query(2*node+1,mid +1 , right,mid+1, end);
			return sum_a+sum_b;
		}
	}
}
int update(int node,int left, int right,int pos, int val)
{
	if(left == right)
	{
		tree[node]=val;
		return tree[node];
	}
	else
	{
		int mid=(left + right)/2;
		if(pos <= mid)
		{
			int sum_a=update(2*node,left, mid,pos,val);
			int sum_b = tree[2*node+1];
			tree[node]=sum_a+sum_b;
			return tree[node];
			
		}
		else
		{
			int sum_a= tree[2*node];
			int sum_b = update(2*node+1,mid+1,right,pos,val);
			tree[node]= sum_a + sum_b;
			return tree[node];
		}
		
		
	}
	
}
int main()
{
	int cases=0;
	while(true)
	{
		int num_el;
		scanf("%d",&num_el);
		if(num_el ==0)
			break;
		if(cases  == 0)
			cases++;
		else
			{
				cases++;
				printf("\n");
			}
		
		int rest = round(pow(2,ceil(log2(num_el)))) -1;
		int total = round(pow(2,ceil(log2(num_el))+1))-1;
		int actual_range= round(pow(2,ceil(log2(num_el))));
		tree = (int *)malloc(sizeof(int)*total+1);
		for(int i=1;i<=total;i++)
			tree[i]=0;
		for(int i=rest+1;i<=rest+num_el;i++)
			scanf("%d",tree+i);
		create_seg_tree(1,1,actual_range);
		char str[32];
		printf("Case %d:\n",cases);
		while(true)
		{
			fgets(str,32,stdin);
			char temp[32]="END";
			bool flag=true;
			for(int i=0;i<=2;i++)
				{
					if(temp[i]!= str[i])
					{
						flag=false;
						break;
					}
				}
			if(flag)
				break;
			char *ptr=strtok(str," ");
			
			if(str[0] ==  'S')
			{
				ptr=strtok(NULL," ");
				int pos = atoi(ptr);
				ptr=strtok(NULL," ");
				int val= atoi(ptr);
				update(1,1,actual_range,pos,val);
			} 
			else if(str[0] == 'M')
			{
				ptr=strtok(NULL," ");
				int left = atoi(ptr);
				ptr=strtok(NULL," ");
				int right= atoi(ptr);
				printf("%d\n",query(1,1,actual_range,left,right));
			}	
		}
		
	}
	
}
