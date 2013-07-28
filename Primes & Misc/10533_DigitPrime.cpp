#include<stdio.h>
#include<stdlib.h>
#include<time.h>
bool sieve[10000001];
bool digit[10000001];
int dig_prim[10000001];
int sum_digits(int number)
{
	int sum=0;
	while(number!=0)
	{
		sum+=number%10; 
		number=number/10;
	}
	return sum;
}
int main()
{
	time_t init=clock();
	for(int i=0;i<10000001;i++)
		{
			sieve[i]=true;
			dig_prim[i]=0;
			digit[i]=false;
		}
	for(int i=2;i<10000001;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<10000001;j+=i)
				sieve[j]=false;
			if(sieve[sum_digits(i)])
			{
				digit[i]=true;
				dig_prim[i]=1;
			}	
			
		}
		
	}
	for(int i=1;i<10000001;i++)
	{
		dig_prim[i]=dig_prim[i]+dig_prim[i-1];
	}
	int num_cases;
	scanf("%d",&num_cases);
	for(int i=0;i<num_cases;i++)	
	{
		int lower,upper;
		scanf("%d %d",&lower,&upper);
		if(digit[lower])
		{
			printf("%d\n",dig_prim[upper]-dig_prim[lower]+1);
		}
		else
		{
			printf("%d\n",dig_prim[upper]-dig_prim[lower]);
		}
		
	}
}
