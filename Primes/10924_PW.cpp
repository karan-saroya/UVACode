#include<stdio.h>
#include<stdlib.h>
#include<string.h>
bool sieve[2000];
int main()
{
	for(int i=0;i<2000;i++)
		sieve[i]=true;
	sieve[0]=false;
	sieve[1]=true;
	for(int i=2;i<2000;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<2000;j+=i)
				sieve[j]=false;
		}
	}	
	char str[32];
	while(scanf("%s",str) != EOF)
	{
		
		int sum=0;
		int length=strlen(str);
		for(int i=0;i<length;i++)
		{
			if(str[i] >= 65 && str[i]<=90)
			{
				sum+=(str[i]-65)+27;
			}
			else
			{
				sum+=str[i]-97+1;
				
			}
		}
		if(sieve[sum])
		{
			printf("It is a prime word.\n");
			
		}
		else
		{
			printf("It is not a prime word.\n");
		}
	}
	
	
}

