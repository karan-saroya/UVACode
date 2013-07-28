#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main()
{
	bool sieve[1000001];
	for(int i=0;i<1000001;i++)
		sieve[i]=true;
	for(int i=2;i<=1000000;i++)
	{
		if((sieve[i] == true) )
		{
			for(int j=2*i;j<=1000000;j+=i)
			{
				sieve[j]=false;
			}
		}
	}
	sieve[0]=false;
	sieve[1]=false;
	bool temp_sieve[1000001];
	for(int i=0;i<=1000000;i++)
	{
		temp_sieve[i]=true;	
	}
	unsigned long l,u;
	while(scanf("%lu %lu",&l,&u)!=EOF)
	{
		
		unsigned long max=0,min=2147483647;
			if(u <=1000000)
			{
				
				int c1=0,c2=0,d1=0,d2=0;
				
				for(int i=l;i<=u;i++)
				{
					if(sieve[i] )
					{
						
						long j=0;
						bool flag=false;
						for( j=i+1;j<=u;j++)
						{
							if(sieve[j])
							{
								flag=true;
								break;
							}
						}
				
						 
						 if(flag == true && j-i > max)
						 {
							 max=j-i;
							 c1=i;
							 c2=j;
						 }
						 if(flag == true && j-i >0 && j-i<min)
							{
								min=j-i;
								
								d1=i;
								d2=j;
								
								
							}
						i=j-1;
					}
				}
				if(c1 == 0)
					printf("There are no adjacent primes.\n");
				
				else
					printf("%d,%d are closest, %d,%d are most distant.\n",d1,d2,c1,c2);
			}
			else if(l<=1000000 &&u > 1000000)
			{
				
				int first_l=l;
				int first_u=1000000;
				
				int sec_l=1000001;
				int sec_u=u;
				int c1=0,c2=0,d1=0,d2=0;
				
				for(int i=first_l;i<=first_u;i++)
				{
					if(sieve[i] )
					{
						
						long j=0;
						bool flag=false;
						for( j=i+1;j<=first_u;j++)
						{
							if(sieve[j])
							{
								flag=true;
								break;
							}
						}
				
						 
						 if(flag == true && j-i > max)
						 {
							 max=j-i;
							 c1=i;
							 c2=j;
						 }
						 if(flag == true && j-i >0 && j-i<min)
							{
								min=j-i;
								
								d1=i;
								d2=j;
								
								
							}
						i=j-1;
					}
					
					
					
					
					
				}
				
				
				
				
				for(int i=0;i<=1000000;i++)
					{
						temp_sieve[i]=true;	
					}
				int sqrt_u= round(sqrt(u))+1;
			for(long i=2;i<=sqrt_u;i++)
				{
					if(sieve[i])
					{
						unsigned long j=0;
						for( j=sec_l;j<=sec_u;j=j+1)
						{
							if(j%i == 0)
								break;
						}
						unsigned long k=0;
						for(k=j-sec_l;k<=u-sec_l;k+=i)
						{
						
							temp_sieve[k]=false;
							
						}
					}
					
				}
			unsigned long i=0;
			for(i=sec_l;i<=sec_u;i=i+1)
			{
				if(temp_sieve[i-sec_l])
				{
					unsigned long j=i+1;
					bool is_prime=false;
					for(j=i+1;j<=sec_u;j=j+1)
					{
						if(temp_sieve[j-l])
						{
							is_prime=true;
							break;
						}
						
					}
				if(is_prime && j-i>max)
				{
					max=j-i;
					c1=i;
					c2=j;
				}	
				if(is_prime && j-i<min && j-i >=1)    	
					{
						min=j-i;
						d1=i;
						d2=j;
					}
					i=j-1;
				}
				
				
			}	
				if(c1 == 0)
					printf("There are no adjacent primes.\n");
				
				else
					printf("%d,%d are closest, %d,%d are most distant.\n",d1,d2,c1,c2);
				
				
				
				
				
			}
			
			else
			{
				int c1=0,c2=0,d1=0,d2=0;
					for(int i=0;i<=1000000;i++)
					{
						temp_sieve[i]=true;	
					}
				int sqrt_u= round(sqrt(u))+1;
			for(long i=2;i<=sqrt_u;i++)
				{
					if(sieve[i])
					{
						unsigned long j=0;
						for( j=l;j<=u;j=j+1)
						{
							if(j%i == 0)
								break;
						}
						unsigned long k=0;
						for(k=j-l;k<=u-l;k+=i)
						{
						
							temp_sieve[k]=false;
							
						}
					}
					
				}
			unsigned long i=0;
			for(i=l;i<=u;i=i+1)
			{
				if(temp_sieve[i-l])
				{
					unsigned long j=i+1;
					bool is_prime=false;
					for(j=i+1;j<=u;j=j+1)
					{
						if(temp_sieve[j-l])
						{
							is_prime=true;
							break;
						}
						
					}
				if(is_prime && j-i>max)
				{
					max=j-i;
					c1=i;
					c2=j;
				}	
				if(is_prime && j-i<min && j-i >=1)    	
					{
						min=j-i;
						d1=i;
						d2=j;
					}
					i=j-1;
				}
				
				
			}	
				if(c1 == 0)
					printf("There are no adjacent primes.\n");
				
				else
					printf("%d,%d are closest, %d,%d are most distant.\n",d1,d2,c1,c2);
				
				
			}
	}	
}