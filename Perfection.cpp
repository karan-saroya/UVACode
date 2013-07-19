#include<stdlib.h>
#include<stdio.h>
#include<math.h>
int main()
{
	unsigned long num;
	printf("PERFECTION OUTPUT\n");
	while(scanf("%lu",&num)!= EOF && num != 0)
	{
		if(num%2 == 0)
		{
				unsigned long sum=0;
			for(int i=2;i<num;i++)
			{
				if(num%i == 0)
					sum+=i;
			}
			sum++;
			if(sum > num)
			{
				printf("%5lu  ABUNDANT\n",num);
			}
			else if(sum < num)
			{
				printf("%5lu  DEFICIENT\n",num);
			}
			else
			{
				printf("%5lu  PERFECT\n",num);
			}
			
		}
		else
		{
			unsigned long sum=0;
			if(num == 1)
			 {
			 	printf("%5lu  DEFICIENT\n",num);	
			 }
			 else
			 {
			 
				for(int i=3;i<num;i+=2)
				{
					if(num%i == 0)
						sum+=i;
				}
				sum++;
				if(sum > num)
				{
					printf("%5lu  ABUNDANT\n",num);
				}
				else if(sum < num)
				{
					printf("%5lu  DEFICIENT\n",num);
				}
				else
				{
					printf("%5lu  PERFECT\n",num);
				}
			}
		}
	}
	printf("END OF OUTPUT\n");
	
	return 0;
}
