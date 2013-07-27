#include<stdio.h>
#include<stdlib.h>
#include<math.h>
//#include<time.h>
bool sieve[10000001];
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
int main()
{
	//time_t init =clock();
	for(int i=0;i<=10000000;i++)
		sieve[i]=true;
	
	sieve[0]=false;
	sieve[1]=false;
	
	for(long long i=2;i<=10000000;i++)
	{
		if(sieve[i])
		{
			for(long long  j=i*i;j<=10000000 ;j+=i)
				sieve[j]=false;
		}
	}
	//printf("%lf",((double)clock()-init)/CLOCKS_PER_SEC);
	
	int num=0;
	while(scanf("%d",&num)!= EOF)
	{
		
		bool found=false;
		int i=0;
			for( i=num/2;i>=2;i--)
			{
					bool flag_1=false,flag_2=false;
					if(i<=10000000)
						flag_1=sieve[i];
					if(num-i<=1000000)
						flag_2=sieve[num-i];
					if(i> 10000000)
						flag_1=is_prime(i,4);	
					if(num-i> 10000000)
						flag_2=is_prime(num-i,4);	
						
						
					if((i==2 || i%2 == 1) && flag_1 && flag_2) 
						{
							if(num-2*i > 0)
							{
								found=true;
								
								break;
							}
						}
			}
		
		if(found)
		{
			printf("%d is the sum of %d and %d.\n",num,i,num-i);
		}
		else
			printf("%d is not the sum of two primes!\n",num);

	}
}
