import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		while((line = buf.readLine())!= null && !line.equals("#"))
		{

			ArrayList<String> list = new ArrayList<String>();
			list.add(line);
			while((line=buf.readLine())!= null && line.charAt(0) != 'e')
				list.add(line);
			int line_num=0;
			int min=1000;
			for(int i=0;i<list.size();i++)
			{
				HashMap<String,String> hmap = new HashMap<String,String>();

				line=list.get(i);
				int count=0;
				StringTokenizer tok =new StringTokenizer(line,",");
				while(tok.hasMoreTokens())
				{
					String temp=tok.nextToken();
					hmap.put(temp.charAt(0)+"", temp.charAt(2)+"");
				}
				for(int j=0;j<list.size();j++)
				{
					if(j != i)
					{
						tok= new StringTokenizer(list.get(j),",");
						while(tok.hasMoreTokens())
						{
							String temp=tok.nextToken();
							if(!hmap.get(temp.charAt(0)+"").equals(temp.charAt(2)+""))
								count++;
						}
					}
				}
				if(count < min)
				{
					min=count;
					line_num=i+1;
				}

			}
			System.out.println(line_num);


		}

	}

}
