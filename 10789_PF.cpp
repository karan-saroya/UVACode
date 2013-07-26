#include<stdio.h>
#include<stdlib.h>
#include<string.h>
bool sieve[10000];
int main()
{
	for(int i=0;i<10000;i++)
		sieve[i]=true;
	for(int i=2;i<10000;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<10000;j+=i)
				sieve[j]=false;
		}
	}
	sieve[1]=false;
	sieve[0]=false;
	char str[2048];
	int up_count[26];
	int num_count[10];
	int low_count[26];
	int num_cases=0;
	scanf("%d",&num_cases);
	for(int i=0;i<num_cases;i++)
	{
		for(int j=0;j<10;j++)
			num_count[j]=0;
		for(int j=0;j<26;j++)
			up_count[j]=0;
		for(int j=0;j<26;j++)
			low_count[j]=0;
		
	
		scanf("%s",str);
		int length=strlen(str);
		for(int j=0;j<length;j++)
		{
			if(str[j] <=57 && str[j] >=48)
			{
				num_count[str[j]-48]++;
			}
			else if(str[j] <=90 && str[j] >=65)
			{
				up_count[str[j]-65]++;
			}
			else if(str[j] >=57 )
			{
				low_count[str[j]-97]++;
			}
			
			
		}
		printf("Case %d: ",i+1);
		int count=0;
		for(int j=0;j<10;j++)
		{
			if(sieve[num_count[j]])
			{
				
					printf("%c",j+48);
				count++;
			}
		}
		for(int j=0;j<26;j++)
		{
			if(sieve[up_count[j]])
			{
				printf("%c",j+65);
				count++;
			}
		}
		for(int j=0;j<26;j++)
		{
			if(sieve[low_count[j]])
			{
				printf("%c",j+97);
				count++;
			}
		}
		if(count == 0)
			printf("empty");
		printf("\n");
		
	}
	
}
