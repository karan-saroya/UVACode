#include<stdio.h>
#include<stdlib.h>
#include<math.h>
long long power(long long a, long long pow,long long mod)
{
	if(pow == 1)
		{
			return a%(long long)mod;
		}
	else
	{
		if(pow % 2 ==0)
		{
			long long ans=power(a,pow/2,mod)%(long long)mod;
			ans= (ans*ans)%mod;
			return ans;
		}
		else
		{
			long long ans=power(a,pow/2,mod)%(long long)mod;
			ans= (ans*ans)%mod;
			ans=(ans * a)%mod;
			return ans;
		}
	}
	
}
/*
bool is_prime(long long prime,int iter) 
{
	long long num=prime-1;
		long long k=0;
		while(num%2  == 0)
		{
			k++;
			num=num>>1;

		}
		long long q=num;
		long long a=0;
	for(int i=0;i<iter;i++)
	{
		
		do
		{
			a=rand()%prime;
			
		}while(a<=1);
		if((a=power(a,q,prime)) == 1)		
		{
			continue;
		}
		else
		{
			bool is_prime=false;
			long long prod=1;
			for(int j=0;j<k;j++)
			{
				prod=power(a,(long long)(pow(2,j)*q),prime);
				if(prod == -1 || prod == prime -1)
				{
					is_prime=true;
					break;
				}
			}
			if(is_prime)
				continue;
			else
				return false;
		}
		
	}
	return true;
	
}
*/

bool sieve[10000001];
bool is_prime(int number)
{
	long long sqr=sqrt(number);
	bool is_prime=true;
	for(int i=2;i<=sqr;i++)
	{
		if(sieve[i] && number%i == 0) 
		{
			is_prime=false;
			break;
		}
	}
	return is_prime;
}
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
	
	long long  p, a;
	while(scanf("%lld %lld",&p,&a)!= EOF && p != 0 && a != 0)
	{
		if(p%2 == 1 )
		{
			if(p <= 10000000)
			{
				if(sieve[p])
					printf("no\n");
				else
				{
					if(power(a,p,p) == a )
						printf("yes\n");
					else
						printf("no\n");
				}
				
				
			}
			else
			{
				if(is_prime(p))
					printf("no\n");
				else
				{
					if(power(a,p,p) == a  ) 
						printf("yes\n");
					else
						printf("no\n");
				}
			}
			
		}
		else
		{
			 if(power(a,p,p) == a)
			{
				printf("yes\n");
			}
			else
			{
				printf("no\n");
			}
		}
	}
}


