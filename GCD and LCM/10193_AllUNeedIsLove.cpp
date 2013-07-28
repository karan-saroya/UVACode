#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int to_int(char str[])
{
	int length = strlen(str);
	int mul=1;
	int sum=0;
	for(int i=length-1;i>=0;i--)
	{
		sum+=mul*(str[i]-48);
		mul*=2;
	}
	return sum;
}
int gcd(int num1, int num2)
{
	return ((num2 == 0) ?  num1 : gcd(num2,num1%num2) );
}
int main()
{
	int  num_cases;
	scanf("%d",&num_cases);
	char str[32];
	for(int i=0;i<num_cases;i++)
	{
		scanf("%s",str);
		int num1=to_int(str);
		scanf("%s",str);
		int num2=to_int(str);
		if(gcd(num1,num2) > 1)
			printf("Pair #%d: All you need is love!\n",i+1);
		else
			printf("Pair #%d: Love is not all you need!\n",i+1);
	} 
	
 
	
}

