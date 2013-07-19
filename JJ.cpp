#include<stdio.h>
#include<stdlib.h>
int main()
{
	int num;
	while(scanf("%d",&num)!= EOF)
	{
		const int size=num;
		int diff[size];
		int numb[size];
		for(int i=0;i<num;i++)
			{
				diff[i]=0;
				numb[i]=0;
			}
		
		for(int i=0;i<num;i++)
		{
			int temp;
			scanf("%d",&temp);
			numb[i]=temp;
		}	
		for(int i=0;i<num-1;i++)
		{
			int dif= numb[i]-numb[i+1];
			if(dif <0)
				dif=-dif;
			diff[dif]=dif;
		}
		bool is_jolly=true;
		for(int i=1;i<num;i++)
			{
				if(diff[i]!= i)
				{
					printf("Not jolly\n");
					is_jolly=false;
					break;
				}
				
			}
		if(is_jolly)
			printf("Jolly\n");
	}
	
	return 0;
}
