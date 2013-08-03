import java.util.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num_cases=Integer.parseInt(buf.readLine());
		ArrayDeque<Character> deck= new ArrayDeque<Character>();
		for(int i=0;i<num_cases;i++)
		{
			boolean not=false;
			String line= buf.readLine();
			for(int j=0;j<line.length();j++)
			{
				if(line.charAt(j) == ')')
				{
					while(deck.peekLast() != null && deck.peekLast()!= '(' )
					{
						deck.removeLast();
					}
					if(deck.peekLast() == null)
							{

									not=true;
									break;
							}
					else
							deck.removeLast();


				}
				else if(line.charAt(j) == ']')
				{
					while(deck.peekLast() != null && deck.peekLast()!= '['  )
					{
						deck.removeLast();
					}
					if(deck.peekLast() == null)
							{

								not=true;
								break;

							}
					else
							deck.removeLast();


				}
				else
				{
					deck.addLast(line.charAt(j));


				}
			}

			if(not|| deck.size() != 0)
			{
				System.out.println("No");
			}
			else
				System.out.println("Yes");

			deck.removeAll(deck);

		}

	}

}
