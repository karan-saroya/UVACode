#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
int sieve[70001];
unsigned long long ugly[1501];
int main()
{
	
	for(int i=0;i<=70000;i++)
		sieve[i]=0;
	for(int i=2;i<=70000;i++)
	{
		if(sieve[i] != -1)
		{
		
			for(int j=2*i;j<=70000;j+=i)
			{
				sieve[j]=-1;
			}
		}
		
		
	}
	
	
	unsigned long long number=0;
	int count=1;
	unsigned long long i=0;
	for( i=2;count<=1500;i++)
	{
		number=i;
		unsigned long long temp = number;
		int index=0;
		bool is_ugly=true;
		for(int j=2;j<=70000 && number > 1;j++)
		{
			if(sieve[j] != -1)
			{
				if(number%j == 0 && j <=5)
				{
					
					while(number%j == 0)
					{
					
						number=number/j;
					}
				}
				else
				{
					break;
				}
				
			}
			
		}
		if(number > 5)
			is_ugly=false;
		if(is_ugly)
		{
			ugly[count++]=i;		
		}
		
	
    }
	printf("%llu",ugly[1499]);
		
		
		
}
