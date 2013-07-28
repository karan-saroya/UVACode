#include<stdio.h>
#include<stdlib.h>
int gcd(int num1, int num2)
{
	return (num2 == 0 ? num1 : gcd(num2,num1%num2));
}
int main()
{
	int num=0;
	while(scanf("%d",&num)!=EOF && num != 0)
	{
		int sum=0;
		for(int i=1;i<num;i++)
		{
			for(int j=i+1;j<=num;j++)
			{
				sum+=gcd(i,j);
			}
		}
		printf("%d\n",sum);
	}
	
}


