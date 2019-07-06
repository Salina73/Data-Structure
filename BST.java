import java.util.*;
public class BST 
{
		static Node root;
		static class Node
		{
			int data;
			Node left;
			Node right;
			Node(int d)
			{
				data=d;
				right=null;
				left=null;
			}
		}
		public void insert(int data) {
			root=insert(root,data);	
			
			
		}
		private Node insert(Node root, int data) {
			if(root==null)
				root=new Node(data);
			
			if(data<root.data)
				root.left=insert(root.left,data);
			else if(data>root.data)
				root.right=insert(root.right,data);
			else
				return root;
			return root;
			
		}
		
		private static void printList(Node root) {
			
			 if (root!= null)
			 {
			        printList(root.left);
			        System.out.print(" " + root.data);
			        printList(root.right);
			    }
		}
		private static void totalBST(int n)
		{
			int d=fact(n);
			int d1=fact(n+1);
			int d2=fact(2*n);
			int total=d2/(d1*d);
			System.out.println();
			System.out.println("Total number of trees from "+n+ " nodes are: "+total); 
		}
	
	private static int fact(int n) 
	{
		int temp=1;
		while(n>1)
		{
			temp=temp*n;
		 	n=n-1;
		}	
		return temp;			
	}
	public static void main(String[] args)
	   {
			Scanner s=new Scanner(System.in);
			BST bst=new BST();
			System.out.println("Welcome to the binary world......\n");
			System.out.println("How many nodes you want to insert:");
			int n=s.nextInt();
			System.out.println("Enter the elements:");
			for(int i=0;i<n;i++)
				bst.insert(s.nextInt());
			System.out.print("Tree becomes: "); 
			BST.printList(root);
			totalBST(n);

	   }
}
