#include<stdio.h>
#include<stdlib.h>
bool sieve[1001];
int main()
{
	
	for(int i=0;i<1001;i++)
	{
		sieve[i]=true;
	}
	
	for(int i=2;i<=1000;i++)
	{
		if(sieve[i])
		{
			for(int j=i*i;j<=1000;j+=i)
			{
				sieve[j]=false;
			}
		}
	}
	int N=0,C=0;
	while(scanf("%d %d",&N,&C)!= EOF && N!=0&& C!=0)
	{
		int count=0;
		int size=0;
		for(int i=1;i<=N;i++)
			{
				if(sieve[i])
					count++;
			}
		if(count%2 == 0)
			size=2*C;
		
		else
			size=2*C-1;
		if(size > count)
		{
			printf("%d %d:",N,C);
			for(int i=1;i<=N;i++)
			{
				if(sieve[i])
					printf(" %d",i);
			
			}
			printf("\n");
			printf("\n");
			
		}
		else
		{
		
			const int length=count;
			int primes[length];
		
			for(int i=0;i<length;i++)
				primes[i]=0;
		
			count=0;
			for(int i=1,count=0;i<=N && count<length;i++)
			{
				if(sieve[i])
					primes[count++]=i;
			}
			if(length%2 == 1)
			{
				printf("%d %d:",N,C);
				int counter=0;
				for(int i=(length/2 -C + 1);counter<(2*C-1);i++)
				{
					if(counter == 2*C -2)
						printf(" %d\n",primes[i]);
					else
						printf(" %d",primes[i]);
					counter++;
				}
				printf("\n");
			}
			else
			{
				printf("%d %d:",N,C);
				int counter=0;
				for(int i=(length/2 -C);counter<(2*C);i++)
				{
					if(counter == 2*C-1)
						printf(" %d\n",primes[i]);
					else
						printf(" %d",primes[i]);
					counter++;
				}
				printf("\n");
				
			}
		
		}
		
	}
	
}
