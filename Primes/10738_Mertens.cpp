#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int mu[1000001];
int M[1000001];
int main()
{
	
	for(int i=0;i<1000001;i++)
	{
	
		mu[i]=1;
		M[i]=0;
	}
	mu[1]=1;
	M[1]=1;
	for(long long i=2;i<1000001;i++)
	{
		if(mu[i] == 1)
		{
		
			for(long long  j=i;j<1000001;j+=i)
			{	
				M[i]=mu[j]*=-i;
				
			}
			for(long long j=i*i;j<1000001;j+=i*i)
			{
				M[i]=mu[j]=0;
			}
			
		}
	}
	for(int i=2;i<=1000000;i++)
	{
			if(mu[i] == i)
			{
				M[i]=mu[i]=1;
			}
			else if(mu[i] == -i)
			{
				M[i]=mu[i]=-1;
			}
		
	}
	
	for(int i=1;i<=1000000;i++)
	{
		M[i]=M[i]+M[i-1];
	}
	
	int num=0;
	while(scanf("%d",&num)!= EOF && num !=0)
	{
		printf("%8d",num);
		printf("%8d",mu[num]);
		printf("%8d",M[num]);
		printf("\n");
		
	}
	
	
}
