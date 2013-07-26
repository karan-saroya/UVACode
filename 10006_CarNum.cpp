#include<stdio.h>
#include<stdlib.h>
#include<math.h>
long long power(long long a, long long pow,long long mod)
{
	if(pow == 1)
		{
			return a%mod;
		}
	else
	{
		if(pow % 2 ==0)
		{
			long long ans=power(a,pow/2,mod)%mod;
			ans= (ans*ans)%mod;
			return ans;
		}
		else
		{
			long long ans=power(a,pow/2,mod)%mod;
			ans= (ans*ans)%mod;
			ans=(ans * a)%mod;
			return ans;
		}
	}
	
}
bool sieve[65000];
int main()
{
	for(int i=0;i<65000;i++)
		sieve[i]=true;
	for(int i=2;i<65000;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<65000;j+=i)
				sieve[j]=false;
		}
		
	}
	
	int num=0;
	while(scanf("%d",&num)!= EOF && num != 0)
	{
		if(!sieve[num])
			{
				bool is_ca=true;
				for(int i=3;i<num;i++)
				{
					if(power(i,num,num) != i)
					{
						is_ca=false;
						break;
					}
				}
				if(is_ca)
					printf("The number %d is a Carmichael number.\n",num);
				else
					printf("%d is normal.\n",num);
			
			}
		else
		{
			printf("%d is normal.\n",num);
		}
	}
	
	
	
	
}

