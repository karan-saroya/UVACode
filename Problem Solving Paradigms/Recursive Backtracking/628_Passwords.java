import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		while((line = buf.readLine())!= null && !line.equals(""))
		{
			int dic_len= Integer.parseInt(line);
			String dic[] = new String[dic_len];
			for(int i=0;i<dic_len;i++)
			{
				dic[i]=buf.readLine();
			}
			int num_rules = Integer.parseInt(buf.readLine());
			System.out.println("--");
			long prev=System.currentTimeMillis();
			for(int i=0;i<num_rules;i++)
			{
				give_arr(buf.readLine(),dic,"",0);
			}


		}
	}
	static void give_arr(String pattern,String[] dic,String word, int curr_pos)
	{
		if(curr_pos == pattern.length()-1)
		{
			if(pattern.charAt(curr_pos) == '0')
			{
				for(int i=0;i<=9;i++)
				{

					System.out.println(word+i);
				}
				return;
			}
			else
			{
				for(int i=0;i<dic.length;i++)
				{
					System.out.println(word+dic[i]);
				}
				return;
			}
		}
		else
		{
			if(pattern.charAt(curr_pos) == '0')
			{
				for(int i=0;i<=9;i++)
				{
					give_arr(pattern, dic, word+i, curr_pos+1);
				}

			}
			else
			{
				for(int i=0;i<dic.length;i++)
				{
					give_arr(pattern, dic, word+dic[i],curr_pos+1);
				}

			}
		}

	}
}
