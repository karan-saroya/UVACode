import java.io.*;
import java.math.BigInteger;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf=  new BufferedReader(new InputStreamReader(System.in));
		String line="";
		BigInteger bi;
		BigInteger st = BigInteger.valueOf(17);
		while((line = buf.readLine())!= null && !(bi= new BigInteger(line)).equals(BigInteger.ZERO))
		{
			if(bi.mod(st).equals(BigInteger.ZERO))
				System.out.println("1");
			else
			{
				System.out.println("0");
			}

		}

	}

}
