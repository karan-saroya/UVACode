#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int lis[10000];
int lds[10000];
int arr[10000];
#define MIN -21456789
int main()
{
	int size=0;
	while(scanf("%d",&size)!=EOF)
	{
		for(int i=0;i<size;i++)
			scanf("%d",&arr[i]);
			
		for(int i=0;i<size;i++)
		{
			lis[i]=0;
			lds[i]=0;
		}	
		for(int i=0;i<size;i++)
		{
			int max = MIN ;
			for(int j=0;j<i;j++)
			{
				if(arr[j] < arr[i] && lis[j] > max)
					max=lis[j];					
			}
			if(max == MIN)
			{
				lis[i]=1;
			}
			else
			{
					lis[i] = max+1;
			}
		}
		for(int i=size-1;i>=0;i--)
		{
			int max = MIN ;
			for(int j=i;j<size;j++)
			{
				if(arr[j] < arr[i] && lds[j] > max)
					max=lds[j];					
			}
			if(max == MIN)
			{
				lds[i]=1;
			}
			else
			{
					lds[i] = max+1;
			}
		}
		
		int max=MIN;
		for(int i=0;i<size;i++)
		{
			if( (lds[i] <=lis[i] ? lds[i]:lis[i]) >max)
				max=(lds[i] <=lis[i] ? lds[i]:lis[i]);
		}
		printf("%d\n",2*max-1);
		
	}
	
}
