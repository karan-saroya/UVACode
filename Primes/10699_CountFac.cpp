#include<stdio.h>
#include<stdlib.h>
bool sieve[1001];
int main()
{
	for(int i=0;i<1001;i++)
		sieve[i]=true;
	for(int i=2;i<1001;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<1001;j+=i)
			{
				sieve[j]=false;
			}
		}
	}
	
	sieve[0]=false;
	sieve[1]=false;
	
	int num=0;
	while(scanf("%d",&num) != EOF && num != 0)
	{
		int number=num;
		int prime_fac=0;
		for(int i=2;i<=1000&&number > 1;i++)
		{
			if(sieve[i] && number%i == 0)
			{
				prime_fac++;
				while(number%i == 0)
					number=number/i;
					
			} 
			
		}
		if(number>1)
			prime_fac++;
		
		printf("%d : %d\n",num,prime_fac);
		
	}
	

}
