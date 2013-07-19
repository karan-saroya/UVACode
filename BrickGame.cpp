#include<stdio.h>
#include<stdlib.h>
int main()
{
	int num_cases;
	scanf("%d",&num_cases);
	for(int i=0;i<num_cases;i++)
	{
		int num_play;
		scanf("%d",&num_play);
		int median=num_play/2;
		int test;
		
		for(int j=0;j<num_play;j++)
		{
			if(j == median)
			{
				scanf("%d",&median);
			}
			else
			{
				scanf("%d",&test);
			}
		}
		printf("Case %d: %d\n",i+1,median);
	}
	
	return 0;
}
