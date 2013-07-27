#include<stdio.h>
#include<stdlib.h>
#include<string.h>
unsigned long length=1;
unsigned long cycle(unsigned long num);

int main()
{
    char string[1024]="";
    unsigned long num1,num2;
    while(scanf("%lu %lu",&num1,&num2)!= EOF && (num1 !=0 && num2!=0))
    {
    	unsigned long max=0;
    	int number=0;
    	unsigned long low_lim,upp_lim;
    	if(num1 <= num2)
    	{
    		low_lim=num1;
    		upp_lim=num2;
    	}
    	else
    	{
    		low_lim=num2;
    		upp_lim=num1;
    	}
    	for(int i=low_lim;i<=upp_lim;i++)
    	{
    		
    		long ans=cycle(i);
    		if(ans > max)
    		{
    			
    			max=ans;
    			number=i;
    		}
    		length=1;
    		
    	}
    	printf("%lu %lu %lu\n",num1,num2,max);

    	
    }
    
	return 0;
    
}
unsigned long cycle(unsigned long num)
{
	if(num == 1)
		return length;
	else if(num%2 == 0)
	{
			length++;
			return cycle(num/2);
	}
	else
	{
			length++;
			return cycle(3*num+1);
	}
	
	

}
