#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int phi[50001];
bool sieve[512];
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
	for(int i=0;i<512;i++)
		sieve[i]=true;
	for(int i=0;i<=50000;i++)
		phi[i]=0;
		
	
	sieve[0]=sieve[1]=false;
	for(int i=2;i<512;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<512;j+=i)
				sieve[j]=false;
		}
	}
	phi[1]=1;
	for(int i=2;i<=50000;i++)
	{
		phi[i]=phi_func(i);
	
	}

	int num=0;
	while(scanf("%d",&num)!= EOF && num != 0)
	{
		long long  sum=0;
		for(int i=num;i>=2;i--)
		{
			sum+=(phi[i]*2);
		}
		sum++;
		printf("%lld\n",sum);
	}	
	
	
	
	
}
