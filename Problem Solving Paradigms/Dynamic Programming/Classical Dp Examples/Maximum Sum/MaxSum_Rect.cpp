#include<stdio.h>
#include<stdio.h>
int main()
{
	int tmp;
	scanf("%d",&tmp);
	const int size=tmp;
	int grid[size][size];
	for(int i=0;i<size;i++)
	{
		for(int j=0;j<size;j++)
		{
			scanf("%d",&grid[i][j]);
		}
	}

	
	int max_sum = -128*100*100;
	int temp[size];
	for(int left =0 ;left<size;left++)
	{
		for(int i=0;i<size;i++)
			temp[i]=0;
		for(int right=left;right<size;right++)
		{
			for(int i=0;i<size;i++)
				temp[i]+=grid[i][right];
				
			int sum = temp[size-1];
			int kad[size];
			kad[size-1]=temp[size-1];
			for(int i=size-1;i>=1;i--)
			{
				if(kad[i] + temp[i-1] > temp[i-1])
					kad[i-1] = kad[i] + temp[i-1];
				else
					kad[i-1] = temp[i-1];
					
				if(kad[i-1] > sum)
					sum=kad[i-1];
			}
			if(sum > max_sum)
				max_sum=sum;
						
		}
		
	}
	printf("%d\n",max_sum);
	
	
}
