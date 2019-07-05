import java.util.*;
public class BalancedParenthesis 
{
	public static void main(String[]args)
	{
		Scanner s =new Scanner(System.in);
		System.out.println("Enter the expression you want to check if it is balanced or not:");
		String s1=s.nextLine();
		char[] input=s1.toCharArray();
		if(check(input))
			System.out.println("Parenthesis are balanced");
		else
			System.out.println("Parenthesis are not balanced");
	}
	static class stack
	{
		int top=-1;
		char[] item=new char[50];
		
		public void push(char c)
		{
			if(top==49)
				System.out.println("Stack is full.....");
			else
				item[++top]=c;
		}

		public boolean isEmpty()
		{
			if(top==-1)
				return true;
			else
				return false;
		}

		public char pop() 
		{
			if(top==-1)
			{
				System.out.println("Underflow error");
				return '\0';
			}
			else
			{
				char element=item[top];
				top--;
				return element;
			}
		}
		
	}
	

	private static boolean check(char[] input) {
		stack stack=new stack();
		int d=input.length;
		for(int i=0;i<d;i++)
		{
			if(input[i]=='(' || input[i]=='{' || input[i]=='[' )
				stack.push(input[i]);
			if(input[i]==')' || input[i]=='}' || input[i]==']' )
			{
				if(stack.isEmpty())
					return false;
				else if(!MatchingBrackets(stack.pop(),input[i]))
					return false;
					
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}

	private static boolean MatchingBrackets(char c1 , char c2) 
	{
		if(c1=='(' && c2==')')
			return true;
		else if(c1=='[' && c2==']')
			return true;
		else if(c1=='{' && c2=='}')
			return true;
		else
			return false;
	}
}
