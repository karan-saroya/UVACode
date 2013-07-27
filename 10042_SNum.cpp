#include<stdio.h>
#include<stdlib.h>
#include<math.h>
bool sieve[1000000];
int main()
{
	for(int i=0;i<1000001;i++)
		sieve[i]=true;
	sieve[1]=false;
	sieve[0]=false;
	
	for(int i=2;i<1000001;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<1000001;j+=i)
			{
				sieve[j]=false;
			}
		}
	}
	
	int num_cases=0;
	scanf("%d",&num_cases);
	
	for(int i=0;i<num_cases;i++)
	{
		int num=0;
		scanf("%d",&num);
		int sum=0;
		for(int j=2;j<=sqrt(num) && num > 1;j++)
		{
			if(sieve[j] && num%j == 0)
			{
				sum+=j;
				while(num%j == 0)
				{
					sum+=j;
					num=num/j;
				}
				
			}
		}
		if(num > 1)
		{
			sum+=num;
		}
		
	}
	
	
	
	
	
}

