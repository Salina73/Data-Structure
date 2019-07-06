import java.util.*;

public class BankingCashCounter 
{
	public static Node front, rear;
	public static int size;
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			front=null;
			rear=null;
			size=0;
			next=null;
		}		
	}
	private boolean isEmpty()
	{
		return(size==0);		
	}
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		char ans;
		int x=0;
		int cash=0;
		BankingCashCounter q=new BankingCashCounter(); 
		System.out.println("Welcome to Bank.....");
		System.out.println();
		System.out.println("***** Cash Counter *****");		
		do 
		{
			System.out.println();
			System.out.println("What you want to do?");
			System.out.println("1.Deposite 2.Withdraw ");
			int n=s.nextInt();
			System.out.println();
			switch(n)
			{
			case 1:
				System.out.println("How many amount you to deposite?");
				int d=s.nextInt();
				q.insert(d);
				cash=cash+d;
				System.out.println();
				x++;
				break;
			case 2:
				System.out.println("How many amount you to withdraw?");
				int d1=s.nextInt();//
				q.remove();
				cash=cash-d1;
				System.out.println();
				x++;
				break;
			}
			System.out.println("Next (If next is not available enter n/N)");
			ans=s.next().charAt(0);
		}while(ans=='Y'||ans=='y');
		if(cash==0)
			System.out.println("Expression is balanced");
		else
		{
			System.out.println("Expression is not balanced");
			System.out.println("Remaining cash is "+cash);
		}
		System.out.println("Total number of people are "+x);	
	}

	private void insert(int data) 
	{
		 Node oldRear = rear;
		 rear = new Node(data);
		 rear.data = data;
		 rear.next = null;
		 if (isEmpty()) 
		 {
		 front = rear;
		 }
		 else 
		 {
		 oldRear.next = rear;
		 }
		 size++;
	 }	
	private int remove() 
	{ 
	 int data = front.data;
	 front = front.next;
	 if (isEmpty()) 
	 {
	 rear = null;
	 }
	 size--;
	 return data;
	}
}

