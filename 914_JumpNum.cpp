#include<stdio.h>
#include<stdlib.h>
bool sieve[1000001];
int diff[1000001];
int main()
{
	for(int i=0;i<1000001;i++)
		sieve[i]=true;
	sieve[0]=false;
	sieve[1]=false;
	for(int i=2;i<1000001;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<1000001;j+=i)
				sieve[j]=false;
		}
	}
	int num_cases=0;
	scanf("%d",&num_cases);
	for(int i=0;i<num_cases;i++)
	{
		int low=0,  high=0;
		scanf("%d %d",&low,&high);
		const int max_diff=high-low +1;
		
		
		for(int k=0;k<1000001;k++)
			diff[k]=-1;
		int prev=0, next=0;
		int j=0;
		for(j=low;j<=high;j++)
		{
			if(sieve[j])
				{
					prev=j;
					break;
				}
		}
		if(j> high)
		{
			printf("No jumping champion\n");
			continue;
		}
		else
		{
			bool flg=false;
			for(int k=j+1;k<=high;k++)
			{
				if(sieve[k])
				{
					diff[k-prev]++;
					prev=k;
					flg=true;
				}
			}
			if(!flg)
				{
				
					printf("No jumping champion\n");
					continue;	
				}
			else
			{
				int max=-1;
				int pos=0;
				for(int k=0;k<max_diff;k++)
				{
					if(diff[k]>max)
					{
						max=diff[k];
						pos=k;
					}
				}
				int count=0;
				for(int k=0;k<max_diff;k++)
				{
					if(diff[k]==max)
					{
						count++;
					}
				}
				if(count > 1)
				{
					printf("No jumping champion\n");
				}
				else
				{
					printf("The jumping champion is %d\n",pos);
				}
				
			}
		}
		
	}
	
}