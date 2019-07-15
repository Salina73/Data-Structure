public class Prime2D 
{
	public static void main(String[] args) 
	{
	    prime();
	}
	private static void prime() {
		int l,k,c=0,i=1;
		int[] a=new int[1000];
		a[0]=2;
        for(l=2;l<=1000;l++)
        {
               for(k=2;k<l;k++)
               {
                   if(l%k==0)
                   {
                       c=0;
                       break;
                   }
                   else
                   {
                       c=1; 		
                   }
               }
               if(c==1)
               {
                   a[i]=l;
                   i++;            
               }
         }
        System.out.println();
        System.out.println();
       dime(a);  
	}
	private static void dime(int[] a) {
		int d=0;
		int[][] b=new int[10][a.length];
		for(int i=0;i<10;i++)
		{
			int g=d;
			d=d+100;
			for(int j=0;j<a.length;j++)
			{
				if(a[j]<=d && a[j]>=g)
				{
					b[i][j]=a[j];
					System.out.print(b[i][j]+" ");
				}
				else if(a[j]>d)
					j=a.length;	
			}
			  System.out.println();
		}	
	}	
}


