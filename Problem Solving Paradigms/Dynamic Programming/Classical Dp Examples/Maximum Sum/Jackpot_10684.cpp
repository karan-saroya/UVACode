#include<stdio.h>
#include<stdlib.h>
int main()
{
	while(true)
	{
	
		int tmp;
		scanf("%d",&tmp);
		if(tmp == 0)
			break;
		if(tmp == 1)
		{
			int temp;
			scanf("%d",&temp);
			if(temp >0)
				printf("The maximum winning streak is 1.\n");
			else
				printf("Losing streak.\n");
			continue;
		}
		const int size = tmp;
		int arr[size];
		for(int i=0;i<size;i++)
			scanf("%d",&arr[i]);
			
		int max_sum = -10000*100;
		int temp[size];
		temp[size-1] = arr[size-1];
		for(int i=size-1;i>=1;i--)
		{
			if(temp[i] + arr[i-1] > arr[i-1])
				temp[i-1] = arr[i-1] + temp[i];
			else
				temp[i-1] = arr[i-1];
				
			if(temp[i-1] > max_sum)
				max_sum = temp[i-1];
		}
		if(max_sum > 0)
			printf("The maximum winning streak is %d.\n",max_sum);
		else
			printf("Losing streak.\n");
	}
	
}
