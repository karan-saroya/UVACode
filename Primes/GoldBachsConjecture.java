import java.io.*;
import java.util.*;
class Main
{
	static int sieve[];
	public static void main(String[] args) throws Exception
	{
		sieve = new int[1000001];
		for(int i=2;i<1000001;i++)
		{
			if(sieve[i]!= -1)
			{
				for(int j=2*i;j<1000001;j+=i)
				{
					sieve[j]=-1;
				}

			}
		}
		BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
		String line="";
		while((line=buf.readLine()) != null && Integer.parseInt(line) != 0)
		{
			int number=Integer.parseInt(line);
			for(int i=2;i<=number/2;i++)
			{
				if(sieve[i] != -1 && sieve[number-i] !=-1)
				{
					System.out.println(number+" = "+i+" "+"+"+" "+(number-i));
					break;
				}

			}


		}



	}

}
