import java.awt.Point;
import java.io.*;
import java.util.*;
class Main
{
	static int min_length=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int cases= Integer.parseInt(buf.readLine());
		for(int j=0;j<cases;j++)
		{
			min_length=Integer.MAX_VALUE;
			StringTokenizer tok = new StringTokenizer(buf.readLine());
			int rows= Integer.parseInt(tok.nextToken());
			int cols = Integer.parseInt(tok.nextToken());
			tok = new StringTokenizer(buf.readLine());
			int s_x = Integer.parseInt(tok.nextToken());
			int s_y = Integer.parseInt(tok.nextToken());

			int total_points = Integer.parseInt(buf.readLine());
			Point[] list = new Point[total_points];
			boolean[] flag= new boolean[total_points];

			for(int i=0;i<total_points;i++)
			{
				tok= new StringTokenizer(buf.readLine());
				list[i]=(new Point(Integer.parseInt(tok.nextToken()),Integer.parseInt(tok.nextToken())));
			}
			cal_small(list,new Point(s_x,s_y),flag,0,0,new Point(s_x,s_y));
			System.out.println("The shortest path has length "+min_length);

		}
	}
	static void cal_small(Point[] list,Point prev,boolean[] flag,int curr_length,int curr_point,Point start)
	{
		if(curr_length > min_length)
		{
			return;
		}
		else if(curr_point == list.length)
		{
			if(curr_length+ Math.abs(start.x-prev.x)+ Math.abs(start.y-prev.y)  < min_length)
			{
				min_length=curr_length+Math.abs(start.x-prev.x)+ Math.abs(start.y-prev.y);
			}
			return;
		}
		else
		{
			for(int i=0;i<list.length;i++)
			{
				if(flag[i] == false && curr_length+Math.abs(list[i].x-prev.x) + Math.abs(list[i].y-prev.y) <min_length)
				{
					flag[i]=true;
					cal_small(list,list[i],flag,curr_length+Math.abs(list[i].x-prev.x) + Math.abs(list[i].y-prev.y),curr_point+1,start);

					flag[i]=false;
				}
			}

		}

	}

}
