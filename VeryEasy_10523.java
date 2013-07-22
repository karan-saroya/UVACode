import java.io.*;
import java.util.*;
import java.math.BigInteger;
class Main 
{
	public static void main(String[] args) throws Exception
	{
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		while( (line = buf.readLine()) != null)
		{
			StringTokenizer st = new StringTokenizer(line);
			int n= Integer.parseInt(st.nextToken());
			int a= Integer.parseInt(st.nextToken());
			BigInteger bi = BigInteger.ZERO;
			BigInteger prod= BigInteger.ONE;
			BigInteger b_a= BigInteger.valueOf(a);
			for(int i=1;i<=n;i++)
			{
				prod=prod.multiply(b_a);
				bi= bi.add(prod.multiply(BigInteger.valueOf(i)));
			}
			System.out.println(bi);
			
		}
		
	}

}
