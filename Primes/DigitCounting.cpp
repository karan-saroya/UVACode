#include<stdio.h>
#include<stdlib.h>
int main()
{
	int count[]={0,0,0,0,0,0,0,0,0,0};
	int num_sets;
	scanf("%d",&num_sets);
	for(int i=0;i<num_sets;i++)
	{
		int num;
		scanf("%d",&num);
		for(int j=0;j<10;j++)
			count[j]=0;
		for(int j=1;j<=num;j++)	
		{
			int a=j;
			int b;
			while(a!=0)
			{
				b=a%10;
				count[b]=count[b]+1;
				a=a/10;
			}
		}
		for(int j=0;j<9;j++)
		{
			printf("%d ",count[j]);
		}
		printf("%d\n",count[9]);
	}
	return 0;
}
