#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main()
{
	unsigned long n,k;
	while(scanf("%lu %lu",&n,&k)!= EOF)
	{
		unsigned long  sum=n;
		unsigned long  num_butts=n;
		unsigned long num_cig;
		while(num_butts >= k )
		{
			num_cig=num_butts/k;
			sum+=num_cig;
			num_butts=num_butts%k+num_cig;
		
			
		}
	
		printf("%lu\n",sum);
	}	
	return 0;	
}
