#include<stdio.h>
#include<stdlib.h>
bool sieve[10000001];
int main()
{
	for(int i=0;i<10000001;i++)
		sieve[i]=true;
	for(int i=2;i<10000001;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<10000001;j+=i)
				sieve[j]=false;
		}
	}
	sieve[0]=false;
	sieve[1]=false;
	
	 long long num=99999999999997;
	
	 
	while(scanf("%lld",&num)!= EOF && num != 0)
	{
		if(num <0)
			num=-num;
		if(num <= 10000000 )
			{
				if(sieve[num])	
				{
					printf("-1\n");
					continue;
				}
				else
				{
					long long ans=0;
					int count=0;
					for(int i=2;i<=10000000&&num > 1;i++)
					{
						if(sieve[i] && num%i == 0)  	
						{
							count++;
							ans=i;
							while(num%i == 0)
							{
								num=num/i;
							}
						}
					}
					if(count == 0 || count == 1 && num == 1)
					{
						printf("-1\n");
						continue;
					}
					else
					{
						if(num > 1)
							ans=num;
						printf("%lld\n",ans);
					}
				}
			}
			else
				{
					long long ans=0;
					int count=0;
					for(int i=2;i<=10000000&&num > 1;i++)
					{
						if(sieve[i] && num%i == 0)  	
						{
							count++;
							ans=i;
							while(num%i == 0)
							{
								num=num/i;
							}
						}
					}
					
					if(count == 0|| count == 1 && num == 1)
					{
						printf("-1\n");
						continue;
					}
					else
					{
						if(num > 1)
							ans=num;
						printf("%lld\n",ans);
					}
				}
		
	}
	
	
	

}
