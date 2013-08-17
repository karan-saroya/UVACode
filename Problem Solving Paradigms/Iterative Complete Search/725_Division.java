import java.io.*;
import java.util.*;
class Main
{
	static int count[]= new int[10];
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		int cases=0;
		while((line = buf.readLine())!= null && Integer.parseInt(line)!=0)
		{
			if(cases == 0 )
				cases++;
			else
				System.out.println("");
			TreeMap<String,String> tmap = new TreeMap<String,String>();
			int n = Integer.parseInt(line);
			for(int i=1234;i*n<=98765;i++)
			{
				for(int j=0;j<count.length;j++)
					count[j]=0;
				if(count_dig(i,n))
				{

					if((i+"").length() == 4 && (i+"").indexOf("0") == -1 && (i*n+"").indexOf("0") == -1)
						tmap.put(i*n+"", "0"+i);
					else
						tmap.put(i*n+"", i+"");
				}

			}
			if(tmap.size() == 0)
			{
				System.out.println("There are no solutions for "+n+".");
			}
			else
			{
				Set set=tmap.entrySet();
				Iterator iter=set.iterator();
				while(iter.hasNext())
				{
					Map.Entry<String, String> entry = (Map.Entry<String,String>)iter.next();
					System.out.println(entry.getKey()+" / "+entry.getValue()+" = "+n);
				}
			}
		}
	}
	static boolean count_dig(int num,int n)
	{
		String number = num+"";
		for(int i=0;i<number.length();i++)
			count[(int)number.charAt(i)-48]++;
		number = num*n+"";
		for(int i=0;i<number.length();i++)
			count[(int)number.charAt(i)-48]++;
		boolean flag=true;
		for(int i=0;i<count.length;i++)
		{
			if(count[i] != 1)
			{
				flag=false;
				break;
			}
		}
		if(flag ==  false && (num+"").length() == 4 && (count[0]) == 0)
		{
			flag=true;
			count[0]=1;
			for(int i=0;i<count.length;i++)
			{
				if(count[i] != 1)
				{
					flag=false;
					break;
				}
			}

		}
		return flag;
	}

}
