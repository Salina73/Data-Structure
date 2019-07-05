import java.util.*;
public class Calender
{
	public static void main(String[] args)
	   {
			Scanner s=new Scanner(System.in);
			int m,y;
			System.out.println("Enter month: ");
			m=s.nextInt();
			System.out.println("Enter year: ");
			y=s.nextInt();	
			System.out.println();
			int d=dayOfWeek(m,y);
			int[][] calender=compute(d,m);
			display(calender,m,y);
	   }

	private static int dayOfWeek(int m, int y) {
		int d=1;
		int y0= y-(14 - m) / 12;System.out.println();
		int x = y0 + y0/4 - y0/100 + y0/400;
		int m0 = m + 12 * ((14 - m) / 12) - 2;
		int d0 = (d + x + 31*m0 / 12)%7;
		return d0;
	}

	private static int[][] compute(int d0, int m) {
		int[] a= {31,29,31,30,31,30,31,31,30,31,30,31};
		int x=a[m];
		int[][] cal=new int[5][7];
		int d1=1;
		
		for(int i=d0;i<7;i++)
		{
			if(x>0)
			{
			cal[0][i]=d1;
			d1++;
			}
			x--;
		}
		for(int i=1;i<5;i++)
		{
			for(int j=0;j<7;j++)
			{

				if(x>0)
				{
				cal[i][j]=d1;
			    d1++;
				}
				x--;
			}
		}
		return cal;
	}

	
	

	private static void display(int[][] cal, int m, int y) {
		
		String[] days ={ " Sun "," Mon ", " Tue ", " Wed ", " Thu "," Fri "," Sat " }; 
		
		String[] months ={"January", "February", "March", "April", "May", "June",
							"July", "August", "September", "October", "November", "December"}; 
		
		System.out.println(" Java Calender "+m+" "+y);
	
		for(int k=0;k<months.length;k++)
		{
			if(m==k)
			System.out.println(" "+months[k-1]+" "+y);
		}
		
		for(int i=0;i<7;i++)
		{
			System.out.print(days[i]);
		}
		System.out.println();
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(cal[i][j]<10)
				System.out.print(" "+cal[i][j]+"   ");
				else if(cal[i][j]>=10)
					System.out.print(" "+cal[i][j]+"  ");
			}
			System.out.println();
		}
		
	}

}
