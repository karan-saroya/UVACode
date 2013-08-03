#include<stdio.h>
#include<stdlib.h>
int main()
{
	int num=0;
	while(scanf("%d",&num)!=EOF && num != 0)
	{
		const int length=num;
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
		if(count%2 == 0)
			printf("Carlos\n");
		else
			printf("Marcelo\n");
		
	}
	
	
	return 0;
}
