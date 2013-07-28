#include<stdio.h>
#include<stdlib.h>
#include<math.h>
bool sieve[1000001];
int phi_func(int num)
{
	int prod=1;
	int count=0;
	int sqr= sqrt(num);
	for(int i=2;i<=sqr && num >= 1;i++)
	{
		if(sieve[i] && num%i == 0)
		{
			int power=0;
			while(num%i == 0)
			{
				power++;
				num=num/i;
			}
			prod*=(pow(i,power)-pow(i,power-1));
		}
		
		
	}
	if(num > 1)
	{
		prod*= (num-1);
		
	}
	
	return prod;
	
}
int main()
{
	for(int i=0;i<=1000000;i++)
		sieve[i]=true;
	sieve[0]=sieve[1]=false;
	for(int i=2;i<=1000000;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<=1000000;j+=i)
				sieve[j]=false;
		}
	}
	int num=0;
	while(scanf("%d",&num)!= EOF && num != 0)
	{
			if(num == 1)
				printf("0\n");
			else
				printf("%d\n",phi_func(num));
		
	}
	
}
