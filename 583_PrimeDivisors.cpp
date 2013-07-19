#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int sieve[70001];
//65535 is sqrt of 2^31 hence generating primes upto 70000
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
	
	int factors[70001];
	long long number=0;
	
	while(scanf("%lld",&number)!= EOF && number != 0 )
	{
		long long temp = number;
		int index=0;
		if(number <0)
		{
			factors[0]=-1;
			number=-number;
			index++;
		
		}
		
		for(int i=2;i<=70000 && number > 1;i++)
		{
			if(sieve[i] != -1)
			{
				while(number%i == 0)
				{
					factors[index++]=i;
					number=number/i;
				}
				
				
			}
			
		}
		if(number > 1)
		{
			factors[index]=number;
		}
		
		if(number > 1)
		{
			int count=0;
			for(int i=0;count<=index;i++)
				{
						if(i == 0)
							printf("%lld = ",temp);
						else if(count == index)
						{
							printf("%d\n",factors[count++]);
						
						}
							
						else
						{
								printf("%d x ",factors[count++]);
						}
						
				}
		}
		else
		{
			int count=0;
			for(int i=0;count<index;i++)
				{
						if(i == 0)
							printf("%lld = ",temp);
						else if(count == index-1)
						{
							printf("%d\n",factors[count++]);
						
						}
							
						else
						{
								printf("%d x ",factors[count++]);
						}
						
				}
		}
	}
	

	return 0;
	
}
