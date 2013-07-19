
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
class Main
{
	public static void main(String[] args) throws Exception
	{
		double ax,ay,bx,by,cx,cy;
		BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
		String read="";
		int counter=0;
		while((read=buf.readLine()) != null)
		{

			StringTokenizer st= new StringTokenizer(read);
			ArrayList<Double> coor_list= new ArrayList<Double>();
			while(st.hasMoreTokens())
			{
				coor_list.add(Double.parseDouble(st.nextToken()));
			}
			ax=coor_list.get(0);
			ay=coor_list.get(1);
			bx=coor_list.get(2);
			by=coor_list.get(3);
			cx=coor_list.get(4);
			cy=coor_list.get(5);

			if(!((ax ==0 && ay==0) || (bx ==0 && by == 0) || (cy == 0 && cx == 0)))
			{
				double D = 2*(ax*(by-cy)+bx*(cy-ay)+cx*(ay-by));
				double Ux = ((ax*ax+ay*ay)*(by-cy)+ (bx*bx+by*by)*(cy-ay) +(cx*cx+cy*cy)*(ay-by))/D;
				double Uy = ((ax*ax+ay*ay)*(cx-bx)+ (bx*bx+by*by)*(ax-cx) +(cx*cx+cy*cy)*(bx-ax))/D;

				double R = Math.sqrt((Ux-ax)*(Ux-ax) + (Uy-ay)*(Uy-ay));

				DecimalFormat format = new DecimalFormat("#0.000");
				String first="",second="",third="";
				if(Ux >=0.0)
					first="(x - "+format.format(Ux)+")^2";
				else
					first="(x + "+format.format(-Ux)+")^2";
				if(Uy >=0.0)
					second="(y - "+format.format(Uy)+")^2";
				else
					second="(y + "+format.format(-Uy)+")^2";
				third=" = "+format.format(R)+"^2";


				System.out.println(first+" + "+second+third);

				first="x^2 + y^2";
				double c=-2*Ux;
				if(c >=0.0)
					second=" + "+format.format(c)+"x";
				else
					second=" - "+format.format(-c)+"x";

				double d=-2*Uy;
				if(d >=0.0)
					third=" + "+format.format(d)+"y";
				else
					third=" - "+format.format(-d)+"y";

				String fourth="";
				double e=Ux*Ux+Uy*Uy-R*R;
				if(e >=0.0)
					fourth=" + "+format.format(e)+" = 0";
				else
					fourth=" - "+format.format(-e)+" = 0";

				System.out.println(first + second +third+ fourth);

			}
			else
			{
				if(bx == 0 && by == 0)
				{
					bx=ax;
					by=ay;
					ax=0;
					ay=0;
				}
				else if(cx == 0 && cy == 0)
				{
					cx=ax;
					cy=ay;
					ax=0;
					ay=0;
				}

				double D= 2*(bx*cy-by*cx);
				double Ux= (cy*(bx*bx+by*by)-by*(cx*cx+cy*cy))/D;
				double Uy= (bx*(cx*cx+cy*cy)-cx*(bx*bx+by*by))/D;
				System.out.println(Ux + " "+ Uy);
				double R = Math.sqrt((Ux-ax)*(Ux-ax) + (Uy-ay)*(Uy-ay));

				DecimalFormat format = new DecimalFormat("#0.000");
				String first="",second="",third="";
				if(Ux >=0.0)
					first="(x - "+format.format(Ux)+")^2";
				else
					first="(x + "+format.format(-Ux)+")^2";
				if(Uy >=0.0)
					second="(y - "+format.format(Uy)+")^2";
				else
					second="(y + "+format.format(-Uy)+")^2";
				third=" = "+format.format(R)+"^2";


				System.out.println(first+" + "+second+third);

				first="x^2 + y^2";
				double c=-2*Ux;
				if(c >=0.0)
					second=" + "+format.format(c)+"x";
				else
					second=" - "+format.format(-c)+"x";

				double d=-2*Uy;
				if(d >=0.0)
					third=" + "+format.format(d)+"y";
				else
					third=" - "+format.format(-d)+"y";

				String fourth="";
				double e=Ux*Ux+Uy*Uy-R*R;
				if(e >=0.0)
					fourth=" + "+format.format(e)+" = 0";
				else
					fourth=" - "+format.format(-e)+" = 0";

				System.out.println(first + second +third+ fourth);


			}

			System.out.println("");
		}




	}


}
