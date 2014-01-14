#include<stdio.h>
#include<stdlib.h>
int grid[10][100];
int memo[10][100];
int paths[10][100][100];
int main()
{
		int rows, cols;
		while(scanf("%d %d",&rows,&cols) != EOF) 
		{
			 	for(int i=0;i<rows;i++)
				 {
				 	for(int j=0;j<rows;j++)
				 		{
				 			scanf("%d",&grid[i][j]);
				 			memo[i][j] = -1;
				 		}
				 }		
				 
				 memo[0][0] = grid[0][0];			
				 int min=0;
				 
		}
		
	
}
int tsp(int curr_x, int curr_y)
{
	
}
