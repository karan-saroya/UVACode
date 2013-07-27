#include<stdio.h>
#include<stdlib.h>
int main()
{
	unsigned long num_cols,num_rows;
	int field=1;
	while(scanf("%lu %lu",&num_rows,&num_cols)!= EOF && num_rows != 0 && num_cols != 0)
	{
		const unsigned long rows= num_rows;
		const unsigned long cols= num_cols;
		char grid[rows][cols];
		char ngrid[rows][cols];
		for(unsigned long i=0;i<rows;i++)
		{
			for(unsigned long j=0;j<cols;j++)
			{
				scanf(" %c",&grid[i][j]);
			}
		}
		
		for(unsigned long i=0;i<rows;i++)
		{
			for(unsigned long j=0;j<cols;j++)
			{
				
				if(grid[i][j] == '*')
				{
					ngrid[i][j]='*';
					continue;
				}
				else
				{
					int counts=0;
					if(j >0 && j <cols)
					{
						if(grid[i][j-1] == '*')
							counts++;
						
					}
					if(i>0 && i < rows)
					{
						if(grid[i-1][j] == '*')
							counts++;
					}
					if(i <rows-1)
					{
						if(grid[i+1][j] == '*')
							counts++;
					}
					if(j < cols-1)
					{
						if(grid[i][j+1] == '*' )
							counts++;
					}
					
					if(i>0 && i<rows && j >0 && j<cols)
					{
						if(grid[i-1][j-1] == '*')
							counts++;
					} 
					
					if(i>0 && i< rows && j<cols-1)
					{
						if(grid[i-1][j+1] == '*')
							counts++;
					}
					if(i<rows-1 && j>0 && j<cols)
					{
						if(grid[i+1][j-1] == '*')
							counts++;
					}
					if(i<rows-1 && j<cols-1)
					{
						if(grid[i+1][j+1] == '*')
							counts++;
						
					}
					
					ngrid[i][j]=counts+48;
					
				}
				
				
			}
		}
		
		
		if(field == 1)
			printf("Field #%lu:\n",field);
		else
			printf("\nField #%lu:\n",field);
		field++;
		for(unsigned long i=0;i<rows;i++)
		{
			for(unsigned long j=0;j<cols;j++)
			{
				printf("%c",ngrid[i][j]);
			}
			printf("\n");
		}
		
		
		
		
	}
	return 0;
}
