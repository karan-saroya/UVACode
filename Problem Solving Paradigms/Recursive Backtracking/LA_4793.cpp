#include<stdio.h>
#include<stdlib.h>
#include<math.h>
bool flag[8][8];
int ways=0;
void num_ways(int curr_x, int curr_y, int r1,int c1,int r2,int c2,int r3,int c3,int rows,int cols,int node_no)
{
		if(curr_x > rows || curr_y > cols || curr_x < 0 || curr_y < 0 )
			return;
		else if(flag[curr_x][curr_y])
			return;	
		else if(curr_x == 0 && curr_y ==1 && node_no == ((rows+1)*(cols+1)))
		{
			ways++;
			
		}
		else if(curr_x == 0 && curr_y ==1 && node_no != ((rows+1)*(cols+1)))
		{
			return;
		}
		else if(curr_x == r1 && curr_y ==c1 && node_no != ((rows+1)*(cols+1))/4)
		{
			return;
		}
		else if(curr_x == r2 && curr_y ==c2 && node_no != ((rows+1)*(cols+1))/2)
		{
			return;
		}
		
		else if(curr_x == r3 && curr_y ==c3 && node_no != 3*((rows+1)*(cols+1))/4)
		{
			return;
		}
		else if(node_no == ((rows+1)*(cols+1)) && !(curr_x == 0 || curr_y ==1))
			return;
		else if(node_no == ((rows+1)*(cols+1))/4 )
		{
			
			 if(flag[r1][c1] == false && (curr_x == r1  && curr_y == c1 ))
			{
				flag[r1][c1]=true;
				if(curr_x+1 <= rows && curr_y <= cols && curr_x+1 >=0 && curr_y>=0 && flag[curr_x+1][curr_y] == false)
					num_ways(curr_x+1,curr_y,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x-1 <= rows && curr_y <= cols && curr_x-1 >=0 && curr_y>=0 && flag[curr_x-1][curr_y] == false)
					num_ways(curr_x-1,curr_y,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x <= rows && curr_y+1 <= cols && curr_x >=0 && curr_y+1>=0 && flag[curr_x][curr_y + 1] == false)
					num_ways(curr_x,curr_y+1,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x <= rows && curr_y-1 <= cols && curr_x >=0 && curr_y-1>=0 && flag[curr_x][curr_y - 1] == false)
					num_ways(curr_x,curr_y-1,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				flag[r1][c1]=false;
			}
			else
				return;
		}
		else if(node_no == ((rows+1)*(cols+1))/2 )
		{
			 if(flag[r2][c2] == false && (curr_x == r2  && curr_y == c2 ))
			{
				
				flag[r2][c2]=true;
				if(curr_x+1 <= rows && curr_y <= cols && curr_x+1 >=0 && curr_y>=0 && flag[curr_x+1][curr_y] == false)
					num_ways(curr_x+1,curr_y,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x-1 <= rows && curr_y <= cols && curr_x-1 >=0 && curr_y>=0 && flag[curr_x-1][curr_y] == false)
					num_ways(curr_x-1,curr_y,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x <= rows && curr_y+1 <= cols && curr_x >=0 && curr_y+1>=0 && flag[curr_x][curr_y + 1] == false)
					num_ways(curr_x,curr_y+1,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x <= rows && curr_y-1 <= cols && curr_x >=0 && curr_y-1>=0 && flag[curr_x][curr_y - 1] == false)
					num_ways(curr_x,curr_y-1,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				flag[r2][c2]=false;
				
			}
			else
				return;
		}
		else if(node_no == 3*((rows+1)*(cols+1))/4 )
		{
			 if(flag[r3][c3] == false && (curr_x == r3  && curr_y == c3 ))
			{
				
				flag[r3][c3]=true;
				if(curr_x+1 <= rows && curr_y <= cols && curr_x+1 >=0 && curr_y>=0 && flag[curr_x+1][curr_y] == false)
					num_ways(curr_x+1,curr_y,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x-1 <= rows && curr_y <= cols && curr_x-1 >=0 && curr_y>=0 && flag[curr_x-1][curr_y] == false)
					num_ways(curr_x-1,curr_y,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x <= rows && curr_y+1 <= cols && curr_x >=0 && curr_y+1>=0 && flag[curr_x][curr_y + 1] == false)
					num_ways(curr_x,curr_y+1,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x <= rows && curr_y-1 <= cols && curr_x >=0 && curr_y-1>=0 && flag[curr_x][curr_y - 1] == false)
					num_ways(curr_x,curr_y-1,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				flag[r3][c3]=false;
			}
			else
				return;
		}
		
		else
		{
			if(node_no < (rows+1)*(cols+1)/4)
			{
				
				int moves = abs(curr_x -r1) + abs(curr_y-c1);
				if(moves > (rows+1)*(cols+1)/4-node_no)
					return;
				
			}
			else if(node_no < (rows+1)*(cols+1)/2)
			{
				
				int moves = abs(curr_x -r2) + abs(curr_y-c2);
				if(moves > (rows+1)*(cols+1)/2-node_no)
					return;
				
			}
			else if(node_no < 3*(rows+1)*(cols+1)/4)
			{
				int moves = abs(curr_x -r3) + abs(curr_y-c3);
				if(moves > 3*(rows+1)*(cols+1)/4-node_no)
					return;
				
			}
			else 
			{
				int moves = abs(curr_x -0) + abs(curr_y-1);
				if(moves > (rows+1)*(cols+1)-node_no)
					return;
				
			}
			
			flag[curr_x][curr_y]=true;
				if(curr_x+1 <= rows && curr_y <= cols && curr_x+1 >=0 && curr_y>=0 && flag[curr_x+1][curr_y] == false)
					num_ways(curr_x+1,curr_y,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x-1 <= rows && curr_y <= cols && curr_x-1 >=0 && curr_y>=0 && flag[curr_x-1][curr_y] == false)
					num_ways(curr_x-1,curr_y,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x <= rows && curr_y+1 <= cols && curr_x >=0 && curr_y+1>=0 && flag[curr_x][curr_y + 1] == false)
					num_ways(curr_x,curr_y+1,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
				if(curr_x <= rows && curr_y-1 <= cols && curr_x >=0 && curr_y-1>=0 && flag[curr_x][curr_y - 1] == false)
					num_ways(curr_x,curr_y-1,r1,c1,r2,c2,r3,c3,rows,cols,node_no+1);
			flag[curr_x][curr_y]=false;
		}
	
	
}
int main()
{
		int rows,cols,cases=1;
		time_t ptr,ptr1;
		while(scanf("%d %d",&rows,&cols)!= EOF&& rows!=0)
		{
			ways=0;
			int r1,c1,r2,c2,r3,c3;
			scanf("%d %d %d %d %d %d",&r1,&c1,&r2,&c2,&r3,&c3);
		
			num_ways(0,0,r1,c1,r2,c2,r3,c3,rows-1,cols-1,1);
			printf("Case %d: %d\n",cases,ways);
			cases++;
			
		}
		
		
		return 0;
}
