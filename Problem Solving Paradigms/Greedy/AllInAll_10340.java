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
			StringTokenizer tok = new StringTokenizer(line);
			String s= tok.nextToken();
			String t = tok.nextToken();
			if(t.equals(s))
			{
				System.out.println("Yes");
			}
			else if(t.length() < s.length())
			{
				System.out.println("No");
			}
			else
			{
				int k=0;
				for(int i=0;i<t.length() && k < s.length();i++)
				{
					if(t.charAt(i) == s.charAt(k))
						k++;
				}
				if(k == s.length())
					System.out.println("Yes");
				else
					System.out.println("No");
			}

		}

	}

}
