#include<stdio.h>
#include<stdlib.h>
#include<string.h>
bool sieve[300];
int main()
{
	for(int i=0;i<300;i++)
		sieve[i]=true;
	sieve[0]=false;
	sieve[1]=false;
	for(int i=2;i<300;i++)
	{
		if(sieve[i])
		{
			for(int j=i*i;j<300;j+=i)
				sieve[j]=false;
		}
	}
	char str[1024];
	int fac[1024],powers[1024];
	int cases=0;
	while(fgets(str,1024,stdin) != NULL)
	{
		if(cases == 0)
			cases++;
		else
			printf("\n");
		for(int i=0;i<1024;i++)
		{
			fac[i]=0;
			powers[i]=0;
		}
		int count=0;
		char *tof=strtok(str," ");
		long long number=1;
		bool end=false;
		while(tof)
		{
			int prod=1;
			int first=atoi(tof);
			if(first == 0)
				{
					end=true;
					break;
				}
			tof=strtok(NULL," ");
			int power=atoi(tof);
			tof=strtok(NULL," ");
			for(int i=0;i<power;i++)
				prod=prod*first;
			number*=prod;
		}
		if(end)
			break;
		
		number=number-1;
		
		
		for(int i=2;i<300 && number > 1;i++)
		{
			if(sieve[i] && number % i == 0)
			{
				int pow=0;
				fac[count]=i;
				while(number%i == 0)
				{
					pow++;
					number=number/i;
				}
				powers[count]=pow;
				count++;
			}
		}
		if(number > 1)
		{
			fac[count]=number;
			powers[count]=1;
			count++;
		}
		
		for(int i=count-1;i>=0;i--)
		{
			if(i ==  count-1)
				printf("%d %d",fac[i],powers[i]);
			else
				printf(" %d %d",fac[i],powers[i]);
		}
		//printf("\n");
		
	}
	
	
	
}
