#include<stdio.h>
#include<stdlib.h>
bool sieve[100000];
int main()
{
	for(int i=0;i<100000;i++)
		sieve[i]=true;
	for(int i=2;i<100000;i++)
	{
		if(sieve[i])
		{
			for(int j=2*i;j<100000;j+=i)
				sieve[j]=false;
		}
	}
	sieve[0]=false;
	sieve[1]=false;
	
	int num1,num2;
	int cases=0;
	while(scanf("%d %d",&num1,&num2)!= EOF && !(num1  == 0 && num2 == 0) )
	{
		if(num1 > num2)
			{
				int temp=num2;
				num2=num1;
				num1=temp;
			}
		int cand[32000];
		int count=0;
		for(int i=num1;i<=num2;i++)
		{
			if(sieve[i])
			{
			
				int  j=0;
				for(j=i+1;j<=num2;j++)
				{
					if(sieve[j])
						break;
					
				}
				int k=j+1;
				int last=j;
				while(k<=num2)
				{
					if(sieve[k])
					{
						if(k-last != j-i)
						{
							break;
						}
						else
						{
							
							cand[count++]=k;
							last=k;			
						}
						
					}
					k++;
				}
				//printf("%d\n",cand[count-1]);
				
				
				
				if(count != 0)
				{
					bool nots=false;
					int k=cand[count-1]+1;
					while(true)
					{
						if(sieve[k])
						{
							if(k-cand[count-1] == j-i)
							{
								nots=true;
								
							}
							
							break;
						}
						k++;
					}
					k=i-1;
					while(k>=0)
					{
						if(sieve[k])
						{
							if(i-k == j-i)
							{
								nots=true;
							}

							
							break;
						}
						k--;
					}
					if(!nots)
					{
					
						printf("%d %d",i,j);
						for(int k=0;k<count;k++)
						{
							printf(" %d",cand[k]);
						}
						printf("\n");
						i=cand[count-1]-1;
					}
				}
				count=0;
				
				
			}
			
		}
		
	}
	
}


