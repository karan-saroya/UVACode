#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main()
{
	int num_cases =0;
	scanf("%d",&num_cases);
	for(int i=0;i<num_cases;i++)
	{
		int len=0;
		scanf("%d",&len);
		const int length=len;
		int array[length];
	
	
		for(int j=0;j<length;j++)
		{
				scanf("%d",&array[j]);
		}
		int count = 0;
		for(int j=0;j<length;j++)
		{
			for(int k=0;k<length-1;k++)
			{
				if(array[k+1] < array[k])
				{
					count++;
					char temp=array[k+1];
					array[k+1]=array[k];
					array[k]=temp;
				}
			}
		}
		
		printf("Optimal train swapping takes %d swaps.\n",count);
		
		
		
		
		
	}
	return 0;
}

