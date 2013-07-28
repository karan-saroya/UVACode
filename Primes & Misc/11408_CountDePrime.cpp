#include<stdio.h>
#include<stdlib.h>
bool sieve[5000001];
int is_deprime[5000001];
int copy[5000001];
int main()
{

	for(int i=0;i<5000001;i++)
		{
			sieve[i]=true;
			is_deprime[i]=0;
			copy[i]=i;
		}
	for(int i=2;i<5000001;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<5000001;j+=i)
				{
					sieve[j]=false;
					is_deprime[j]+=i;
					while(copy[j]%i == 0)
					{
						copy[j]=copy[j]/i;
					}
				}
			
			is_deprime[i]=1;
		}
		
	}
	sieve[0]=false;
	sieve[1]=false;
	for(int i=2;i<5000001;i++)
	{
		if(!sieve[i])
		{
		
			if(copy[i] > 1  )
			{
				if(sieve[is_deprime[i]+copy[i]])
					is_deprime[i]=1;
				else
					is_deprime[i]=0;
			}
			else
			{
				if(sieve[is_deprime[i]])
					is_deprime[i]=1;
				else
					is_deprime[i]=0;
				
			}
		}
	}
	//printf("%lf",((double)clock()-init)/CLOCKS_PER_SEC);
	
	int  a,b;
	while(scanf("%d",&a)!= EOF && a!=0)
	{
		scanf("%d",&b);
		int count=0;
		for(int i=a;i<=b;i++)
		{
			if(is_deprime[i])
				count++;
		}
		printf("%d\n",count);
	}
	
	
	
	
	
	
}
