#include<stdio.h>
#include<stdlib.h>
bool sieve[10001];
int main()
{
	for(int i=0;i<10001;i++)
		sieve[i]=true;
	sieve[1]=false;
	sieve[0]=false;
	
	for(int i=2;i<10001;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<10001;j+=i)
			{
				sieve[j]=false;
			}
		}
	}
}
