#include<stdio.h>
#include<stdlib.h>
int sieve[32000];

int main()
{
	time_t time,time1;
	
	for(int i=0;i<32000;i++)
	{
		sieve[i]=0;
	}
		for(int i=2;i<32000;i++)
		{
			if(sieve[i]  != -1)
			{
			
				for(int j=2*i;j<32000;j+=i)
				{
					sieve[j]=-1;
				}
			}
		}
	long long num1,num2,u,l,num_cases;
	scanf("%lld",&num_cases);
	for(long long  i=0;i<num_cases;i++)
	{
		scanf("%lld %lld",&num1,&num2);
		if(num1 >= num2)
		{
			l=num2;
			u=num1;
		}
		else
		{
			l=num1;
			u=num2;
		}
		
		long long prod=0;
		long long num=0;
		for( long long  j=l;j<=u;j++)
		{
			long long number=j;
			long long temp_prod=1;
			
		
		  
			for(int i=2;i<32000 && number > 1;i++)
		  {
		  	
			if(sieve[i] != -1)
			{
				if(number%i ==0)
				{
					
					int count=0;
					while(number%i == 0)
					{
						count++;
						number=number/i;
					}
					temp_prod*=(count+1);
				}
				
				
			}
			
		 }
	   
		  if(number > 1 )
		 { 
		 	temp_prod*=2;
		 }
		 if(temp_prod > prod)
		 	{
		 		prod=temp_prod;
		 		num=j;
		 	}
		  
		
		
		
		
		}
		printf("Between %lld and %lld, %lld has a maximum of %lld divisors.\n",num1,num2,num,prod);
	
    }
    

    return 0;

}


