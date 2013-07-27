import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{

	  ArrayList<String> six=new ArrayList<String>();
	  for(int i=0;i<1000000;i++)
	  {
		  int l_d=i%10;
		  if( (l_d == 0 || l_d == 1|| l_d==4|| l_d == 5  || l_d==6 || l_d==9 ) && Math.sqrt(i) == Math.rint(Math.sqrt(i)))
		  {
			  int digits=num_digits(i);
			  String num=""+i;
			  if(digits < 6)
			  {
				  for(int j=0;j<6-digits;j++)
				  {
					  num="0"+num;
				  }
			  }
			  int f_num= Integer.parseInt(num.substring(0,num.length()/2));
			  int s_num= Integer.parseInt(num.substring(num.length()/2));

			  if((Math.pow((f_num%10 + s_num%10)%10,2))%10 == i%10)
			  {
				  if((f_num+s_num)*(f_num+s_num) == i)
					  six.add(num);


			  }

		  }
	  }

	  ArrayList<String> eight=new ArrayList<String>();
	  for(int i=0;i<100000000;i++)
	  {
		  int l_d=i%10;
		  if( (l_d == 0 || l_d == 1|| l_d==4|| l_d == 5  || l_d==6 || l_d==9 ) && Math.sqrt(i) == Math.rint(Math.sqrt(i)))
		  {
			  int digits=num_digits(i);
			  String num=""+i;
			  if(digits < 8)
			  {
				  for(int j=0;j<8-digits;j++)
				  {
					  num="0"+num;
				  }
			  }
			  int f_num= Integer.parseInt(num.substring(0,num.length()/2));
			  int s_num= Integer.parseInt(num.substring(num.length()/2));

			  if((Math.pow((f_num%10 + s_num%10)%10,2))%10 == i%10)
			  {
				  if((f_num+s_num)*(f_num+s_num) == i)
					  eight.add(num);


			  }

		  }
	  }

	  ArrayList<String> four=new ArrayList<String>();
	  for(int i=0;i<10000;i++)
	  {
		  int l_d=i%10;
		  if( (l_d == 0 || l_d == 1|| l_d==4 || l_d == 5 || l_d==6 || l_d==9 ) && Math.sqrt(i) == Math.rint(Math.sqrt(i)))
		  {
			  int digits=num_digits(i);
			  String num=""+i;
			  if(digits < 4)
			  {
				  for(int j=0;j<4-digits;j++)
				  {
					  num="0"+num;
				  }
			  }
			  int f_num= Integer.parseInt(num.substring(0,num.length()/2));
			  int s_num= Integer.parseInt(num.substring(num.length()/2));

			  if((Math.pow((f_num%10 + s_num%10)%10,2))%10 == i%10)
			  {
				  if((f_num+s_num)*(f_num+s_num) == i)
					  four.add(num);


			  }

		  }
	  }

	  ArrayList<String> two=new ArrayList<String>();
	  for(int i=0;i<1000;i++)
	  {
		  int l_d=i%10;
		  if( (l_d == 0 || l_d == 1|| l_d==4|| l_d == 5 || l_d==6 || l_d==9 ) && Math.sqrt(i) == Math.rint(Math.sqrt(i)))
		  {
			  int digits=num_digits(i);
			  String num=""+i;
			  if(digits < 2)
			  {
				  for(int j=0;j<2-digits;j++)
				  {
					  num="0"+num;
				  }
			  }
			  int f_num= Integer.parseInt(num.substring(0,num.length()/2));
			  int s_num= Integer.parseInt(num.substring(num.length()/2));

			  if((Math.pow((f_num%10 + s_num%10)%10,2))%10 == i%10)
			  {
				  if((f_num+s_num)*(f_num+s_num) == i)
					 two.add(num);


			  }

		  }
	  }

		BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
		String num="";
		while((num = buf.readLine()) != null)
		{
			int number = Integer.parseInt(num);
			if(number == 2)
			{
				for(int i=0;i<two.size();i++)
					System.out.println(two.get(i));
			}
			else if(number == 4)
			{
				for(int i=0;i<four.size();i++)
					System.out.println(four.get(i));
			}
			else if(number == 6)
			{
				for(int i=0;i<six.size();i++)
					System.out.println(six.get(i));
			}
			else
			{
					for(int i=0;i<eight.size();i++)
						System.out.println(eight.get(i));

			}

		}





	}

	static int num_digits(int num)
	{
		if(num == 0)
			return 1;
		int count=0;
		while(num!=0)
		{
			count++;
			num=num/10;
		}
		return count;
	}

}
