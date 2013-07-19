#include<stdio.h>
#include<stdlib.h>
int main()
{
	int r,n;
	int cases=1;
	while(scanf("%d %d",&r,&n)!= EOF && r!= 0 && n != 0)
	{
		if(n+n*26 <= r)
		{
			if(n+ n*26 ==  r)
				printf("Case %d: 26\n",cases);
			else
				printf("Case %d: impossible\n",cases);
		}
		else
		{
			if( r-n <=0)
			{
				printf("Case %d: 0\n",cases);
			}
			else
			{
				r=r-n;
				int i=0;
				for( i=1;i<=26;i++)
				{
					
						r=r-n;
						if(r <= 0)
							break;
				
				}
				printf("Case %d: %d\n",cases,i);
			}
		}
		
		
		cases++;
	}
	
	
	
	return 0;
	
}
