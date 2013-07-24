#include<stdio.h>
#include<stdlib.h>
bool sieve[1000000];
int reverse(int number)
{
	char str[32];
	int a=number;
	int count=0;
	while(a!=0)
	{
		str[count++]=48+a%10;
		a=a/10;
	}
	str[count]='\0';
	
	return atoi(str);
	
}
int main()
{
	for(int i=0;i<1000000;i++)
		sieve[i]=true;
	
	for(int i=2;i<1000000;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<1000000;j+=i)
			{
				sieve[j]=false;
			}
		}
	}
	
	sieve[0]=false;
	sieve[1]=false;
	int num=0;
	int cases=0;
	while(scanf("%d",&num)!= EOF)
	{
		/*if(cases == 0)
			cases++;
		else
			printf("\n");
		*/
		if(!sieve[num])
		{
			printf("%d is not prime.\n",num);
			continue;
		}
		else
		{
			int rev=reverse(num);
			if(sieve[rev] && rev!= num )
			{
				printf("%d is emirp.\n",num);
			}
			else
			{
				printf("%d is prime.\n",num);
			}
			
		}
		
	}
	
	
}