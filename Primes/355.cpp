#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
int main()
{
	
	int base[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	int o_base,n_base;
	char number[32];
	while(scanf("%d %d %s",&o_base,&n_base,number) != EOF)
	{
		
		int length=strlen(number);
		bool invalid=false;
		for(int i=0;i<length;i++)
		{
			if(number[i] > base[o_base-1])
			{
				invalid=true;
				break;
			}
			
		}
		if(invalid)
		{
			printf("%s is an illegal base %d number\n",number,o_base);
		}
		else
		{
			int count=0;
			unsigned long long base_10=0;
			for(int i=length-1;i>=0;i--)
			{
				if(number[i] >=65)
				{
					base_10+=(number[i]-65 + 10)*pow(o_base,count);
					count++;
				}
				else
				{
					base_10+=(number[i]-48)*pow(o_base,count);
					count++;
				}
			}
		//	printf("%llu base 10 number\n",base_10);
			unsigned long long a=base_10;
			int num_digits=0;
			while(a!=0)
			{
				num_digits++;
				a=a/n_base;
			}
			
		   //printf("%d digits",num_digits);
			if(base_10 == 0)
			{
				char n_num[2]={'0','\0'};
				printf("%s base %llu = %s base %d\n",number,o_base,n_num,n_base);
			}
			else
			{
				
				char n_num[num_digits+1];
				n_num[num_digits]='\0';
			
				for(int i=num_digits-1;i>=0;i--)
				{
					int b=base_10%n_base;
					n_num[i]=base[b];
					base_10=base_10/n_base;
				}
			
				printf("%s base %llu = %s base %d\n",number,o_base,n_num,n_base);
			}  
		}
	}
	return 0;
}
