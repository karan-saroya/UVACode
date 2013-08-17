#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>
int tree[1024100];
char str[1024100];
int create_seg_tree(int node, int left, int right)
{
	if(right == left)
		return tree[node];
	else
	{
		int mid=(left+right)/2;
		int num_a = create_seg_tree(2*node,left,mid);
		int num_b = create_seg_tree(2*node+1,mid+1,right);
		tree[node]=num_a+num_b;
		return tree[node];
	}
	
}
int query(int node, int left,int right,int begin, int end)
{
	if(left == begin && right == end)
		return tree[node];
	else
	{
		int mid=(left+right)/2;
		if(begin<= mid && end <= mid)
		{
			return query(2*node,left,mid,begin,end);
		}
		else if(begin > mid && end > mid)
			return query(2*node+1,mid+1,right,begin,end);
		else
		{
			int num_a= query(2*node,left,mid,begin,mid);
			int num_b= query(2*node+1,mid+1,right,mid+1,end);
			return num_a+num_b;
		}
	}
	
}


int update(int node,int left,int right, int pos, int val)
{
	if(left == right)
	{
		tree[node]=val;
		return tree[node];
	}
	else
	{
		int mid=(left+right)/2;
		if(pos <= mid )
		{
			int sum_a= update(2*node,left,mid,pos,val);
			tree[node]  = sum_a+tree[2*node+1];
			return tree[node];
		}
		else
		{
			int sum_a = update(2*node+1,mid+1,right,pos,val);
			tree[node] = sum_a + tree[2*node];
			return tree[node];
			
		}
		
	}
	
	
}
int inv_update(int node,int left,int right, int pos)
{
	if(left == right)
	{
		if(tree[node] == 1)
			tree[node]=0;
		else
			tree[node]=1;
		return tree[node];
	}
	else
	{
		int mid=(left+right)/2;
		if(pos <= mid )
		{
			int sum_a= inv_update(2*node,left,mid,pos);
			tree[node]  = sum_a+tree[2*node+1];
			return tree[node];
		}
		else
		{
			int sum_a = inv_update(2*node+1,mid+1,right,pos);
			tree[node] = sum_a + tree[2*node];
			return tree[node];
			
		}
		
	}
	
	
}


int main()
{
	int num_cases;
	scanf("%d",&num_cases);
	for(int j=1;j<=num_cases;j++)
	{
		
		printf("Case %d:\n",j);
		int m;
		scanf("%d",&m);
		char temp[64];
		for(int i=0;i<m;i++)
		{
			int num_cat;
			scanf("%d",&num_cat);
			
			scanf("%s",temp);
			for(int k=0;k<num_cat;k++)
				strcat(str,temp);
		}
		int num_el = strlen(str);
		int rest= round(pow(2,ceil(log2(num_el))))-1;
		int total= round(pow(2,ceil(log2(num_el))+1))-1;
		int actual_range= round(pow(2,ceil(log2(num_el))));
		for(int i=1;i<=1030000;i++)
			tree[i]=0;
			
		for(int i=rest+1,k=0;i<=rest+num_el;i++,k++)
			{
				tree[i] = str[k]-48;			
			}
			
		create_seg_tree(1,1,actual_range);	
	
		int num_query,god_q=0;
		scanf("%d",&num_query);
		char string[32];
		for(int k=1;k<=num_query;k++)
		{
			fflush(stdin);
			fgets(string,32,stdin);
			char *ptr=strtok(string," ");
			ptr=strtok(NULL," ");
			int a=atoi(ptr)+1;
			ptr=strtok(NULL," ");
			int b=atoi(ptr)+1;
			if(string[0] == 'F')
			{
				for(int i=a;i<=b;i++)
					update(1,1,actual_range,i,1);
				
			}
			else if(string[0] == 'E')
			{
				for(int i=a;i<=b;i++)
					update(1,1,actual_range,i,0);
				
			}
			else if(string[0] == 'I')
			{
				for(int i=a;i<=b;i++)
					inv_update(1,1,actual_range,i);
			}
			else if(string[0] == 'S')
			{
				god_q++;
				printf("Q%d: %d\n",god_q,query(1,1,actual_range,a,b));
				
			}
		}
		strcpy(str,"");
		
	}
	return 0;
}

