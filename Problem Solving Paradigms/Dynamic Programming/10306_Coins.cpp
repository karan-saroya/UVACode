#include<stdio.h>
#include<stdlib.h>
#define MAX 2000000
int value[40];
int it_v[40];
int memo[310][310];
int num_coins;
int MinCoins(int bal, int curr_value, int curr_it_v, int coins)
	{
		if((bal*bal) == ((curr_value*curr_value) + curr_it_v*curr_it_v))
		{
			return coins;
		}
		else if((bal*bal) < (curr_value*curr_value) + curr_it_v*curr_it_v)
		{
			return MAX;
		}
		else
		{
			if(memo[curr_value][curr_it_v]!= -1)
			{
				return memo[curr_value][curr_it_v];
			}
			int min = MAX;
			for(int i=0;i<num_coins;i++)
			{
				if((bal*bal) >= (curr_value*curr_value) + curr_it_v*curr_it_v)
					{
						int temp = MinCoins(bal,curr_value+value[i],curr_it_v+it_v[i],coins+1);
						if(temp < min)
							min = temp;
					}
			}
			memo[curr_value][curr_it_v] = min;
			return min;
		}
		
		
	}
int main()
{
	int num_cases =0;
	scanf("%d",&num_cases);
	for(int i=0;i<num_cases;i++)
	{
		 scanf("%d",&num_coins);
		 int bal=0;
		 scanf("%d",&bal);
		 for(int j=0;j<num_coins;j++)
		 {
		 	scanf("%d%d",&value[j],&it_v[j]);
		 }
		 for(int j=0;j<301;j++)
		 {
		 	for(int k=0;k<301;k++)
		 		memo[j][k] = -1;
		 }
		 
		 int ans= MinCoins(bal,0,0,0);
		 if(ans == MAX)
		 	printf("not possible\n");
		else
			printf("%3d",ans);
	}
	
	
}
