#include<stdio.h>
#include<stdlib.h>
bool sieve[33000];
int main()
{
	for(int i=0;i<33000;i++)
		sieve[i]=true;
	
	for(int j=2;j<33000;j++)
	{
		if(sieve[j])
		{
			for(int i=2*j;i<33000;i+=j)
				sieve[i]=false;
		}
	}
	int num=0;
	while(scanf("%d",&num) != EOF && num != 0)
	{
		int count=0;
		for(int i=2;i<=num/2;i++)
		{
			
			if(sieve[i] && sieve[num-i]) 
			{
				count++;
			}
		}
		printf("%d\n",count);
	}
	
	
	
}
