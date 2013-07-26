#include<stdio.h>
#include<stdlib.h>
bool sieve[1000001];
int main()
{
	for(int i=0;i<1000001;i++)
		sieve[i]=true;
	
	for(int j=2;j<1000001;j++)
	{
		if(sieve[j])
		{
			for(int i=2*j;i<1000001;i+=j)
				sieve[i]=false;
		}
	}
	for(int i=2;i<1000001;i++)
	{
		
		if(!sieve[i])
		{
			int number=i;
			int count=0;
			for(int j=2;j<=1000 && number >1;j++)
			{
				if(sieve[j] && number%j == 0)
				{
					count++;
				}
			}
			
		}
		
	}
	
	
	
	
}
