#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>
unsigned long gcd(unsigned long num1, unsigned long num2);
int main()
{


	double number;
	int j;
	char string[32];
	unsigned long cases=1;
	while(scanf("%d",&j)!= EOF && j != -1)
	{
		scanf("%s",string);
		const int length=strlen(string);
	/*	if(atof(string) >=1.0)
		{
			double number= atof(string)-(int)(atof(string));
			sprintf(string,"%lf",number);
		}
		*/
		int k=0;
	
		const int index=strchr(string,'.')-string;
		
		for(int i=length-j-1;i>index;i--)
		{
				k++;
		}
		//printf("%d",k);
		bool excep=false;
		if(length-1-index < j)
		{
			const int add=j-(length-1-index);
			char n_string[length+add+1];
			for(int i=0;i<length;i++)
				n_string[i]=string[i];
			
			for(int i=length;i<length+add;i++)
				n_string[i]='0';
			n_string[length+add]='\0';
		  //printf("%s",n_string);
			char n_num_str[length+add+j+1];
			
			for(int i=0;i<length+add;i++)
			{
				n_num_str[i]=n_string[i];
			}
			for(int i=length+add,last=length+add-j;i<length+add+j;i++,last++)
			{
				n_num_str[i]=n_string[last];
			}
			n_num_str[length+add+j]='\0';
			
			double orig_x=atof(n_string);
			double x= atof(n_num_str);
			unsigned long num,denom;
			int k=0;
			double d=(pow(10,k+j)*x -pow(10,k)*orig_x);
			d+=0.00000001;
			num   = (unsigned long )round(d);
			denom = (unsigned long)round(pow(10,k+j) - pow(10,k));
			unsigned long divisor; 
			while( (divisor=gcd(num,denom)) != 1)
			{
				 	num=num/divisor;
				 	denom=denom/divisor;
		    }
			
		
				printf("Case %lu: %lu/%lu\n",cases,num,denom);
			cases++;
			
			
		}
		else
		{
		
			char n_num[length+j+1];
		
			for(int i=0;i<length;i++)
			{
				n_num[i]=string[i];
			}
			for(int i=length,last=length-j;i<length+j;i++,last++)
			{
				n_num[i]=string[last];
			}
			n_num[length+j]='\0';
			double orig_x=atof(string);
			double x= atof(n_num);
			unsigned long num,denom;
			if( j != 0  && k > 0)
			{
				double d=(pow(10,k+j)*x -pow(10,k)*orig_x);
			   	
				num   = (unsigned long )round(d);
				denom = (unsigned long)round(pow(10,k+j) - pow(10,k));
				 
				 
			}
		//printf("%lu",num);
			else if(j == 0)
			{
				 num   = (unsigned long)round(pow(10,k)*orig_x);
				 denom = (unsigned long)round(pow(10,k));
			}
			else if(j !=0 && k==0)
			{
			
					double d=(pow(10,k+j)*x -pow(10,k)*orig_x);
				   	num   = (unsigned long)round(d);
					denom = (unsigned long)round(pow(10,k+j) - pow(10,k));
				 
				 
				
			
			}
			unsigned long divisor; 
			while( (divisor=gcd(num,denom)) != 1)
			{
				 	num=num/divisor;
				 	denom=denom/divisor;
		    }
			
			
				printf("Case %lu: %lu/%lu\n",cases,num,denom);
			cases++;
		}
	}
	return 0;
}
unsigned long gcd(unsigned long num1, unsigned long num2)
{
	if(num2 == 0)
		return num1;
	else
		gcd(num2,num1%num2);
	
	
}