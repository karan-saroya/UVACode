#include<stdio.h>
#include<stdlib.h>
bool sieve[20000001];
int first[100000];
int sec[100000];
int main()
{

	for(int i=0;i<20000001;i++)
		sieve[i]=true;
	for(int i=2;i<20000001;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<20000001;j+=i)
			{
				sieve[j]=false;
			}
		}
	}
	int count=0;
	for(int i=2;i<19999999&& count < 100000;i++)
	{
		if(sieve[i] && sieve[i+2])
		{
			first[count]=i;	
			sec[count]=i+2;
			count++;
		}
	}
	
	int pair_num=0;
	while(scanf("%d",&pair_num)!= EOF)
	{
		pair_num=pair_num-1;
		printf("(%d, %d)\n",first[pair_num],sec[pair_num]);
		
	}
	
	
	
	
}

