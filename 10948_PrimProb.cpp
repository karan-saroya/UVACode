#include<stdio.h>
#include<stdlib.h>
bool sieve[1000001];
int main()
{
	for(int i=0;i<=1000000;i++)
		sieve[i]=true;
	for(int j=2;j<=1000000;j++)
	{
		if(sieve[j])
		{
			for(int i=2*j;i<=1000000;i+=j)
				sieve[i]=false;
		}
	}
	sieve[0]=false;
	sieve[1]=false;
	int num=0;
	while(scanf("%d",&num) != EOF && num != 0)
	{
		bool is=false;
		int i=0;
		for( i=2;i<=num/2;i++)
		{
			if(sieve[i] && sieve[num-i])
			{
				is=true;
				break;
			}
		}
		if(is)
		{
			printf("%d:\n",num);
			printf("%d+%d\n",i,num-i);
		}
		else
		{
			printf("%d:\n",num);
			printf("NO WAY!\n");
		}
		
	}
	
	
}
