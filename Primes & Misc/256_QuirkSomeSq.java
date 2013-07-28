import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		ArrayList<String> eight = new ArrayList<String>();
		eight.add("00000000");
		eight.add("00000001");
		eight.add("04941729");
		eight.add("07441984");
		eight.add("24502500");
		eight.add("25502500");
		eight.add("52881984");
		eight.add("60481729");
		eight.add("99980001");
		ArrayList<String> two = new ArrayList<String>();
		two.add("00");
		two.add("01");
		two.add("81");
		ArrayList<String> four = new ArrayList<String>();
		four.add("0000");
		four.add("0001");
		four.add("2025");
		four.add("3025");
		four.add("9801");

		ArrayList<String> six = new ArrayList<String>();
		six.add("000000");
		six.add("000001");
		six.add("088209");
		six.add("494209");
		six.add("998001");

		BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));

		String num="";
		while((num= buf.readLine()) != null)
		{
			int number=Integer.parseInt(num);
			if(number  == 2)
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


}
