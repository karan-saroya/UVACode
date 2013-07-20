
import java.io.*;
import java.math.BigInteger;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(buf.readLine());
		for(int i=0;i<cases;i++)
		{
			String numbers= buf.readLine();

			BigInteger num1=new BigInteger(new StringBuffer(numbers.substring(0,numbers.indexOf(" "))).reverse().toString());
			BigInteger num2=new BigInteger(new StringBuffer(numbers.substring(numbers.indexOf(" ") + 1)).reverse().toString());
			num1=num1.add(num2);
			System.out.println(new BigInteger(new StringBuffer(num1.toString()).reverse().toString()));

		}

	}

}
