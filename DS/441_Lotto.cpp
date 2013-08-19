#include<stdio.h>
#include<stdlib.h>
int main()
{
	int num_len=1;
	int num_cases=0;
	while(scanf("%d",&num_len)!= EOF && num_len != 0)
	{
		if(num_cases == 0)
			num_cases++;
		else
			printf("\n");
		const int length = num_len;
		
		int array[length];
		for(int i=0;i<num_len;i++)
		{
			scanf("%d",array+i);
		}
		
		for(int i=0;i<num_len;i++)
		{
				for(int j=i+1;j<num_len;j++)
				{
					
						for(int k=j+1;k<num_len;k++)
						{
							
								for(int l=k+1;l<num_len;l++)
								{
									
										for(int m=l+1;m<num_len;m++)
										{
											
												for(int n=m+1;n<num_len;n++)
												{
													
														
														printf("%d %d %d %d %d %d\n",array[i],array[j],array[k],array[l],array[m],array[n]);
													
												}
												
											
											
											
										}
										
									
								}
							
						}
						
				}
			
		}
		
	}
	return 0;
}
