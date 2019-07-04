import java.io.*;
import java.util.*;

public class OrderedLinkedList {
	  Node head;
	  static class Node
	  {
		  int data;
		  Node next;
		  Node(int d) 
		  {
			  data = d;
			  next=null;
		  } 
	  }	   
	
	public static void main(String[] args) throws IOException 
	   {
		 File f1=new File("/home/admin265/Documents/Binary/input1"); 
	      FileReader fr = new FileReader(f1); 
	      BufferedReader br = new BufferedReader(fr); 
	      List<Integer>list1 = new ArrayList<Integer>();
	      Scanner s1=new Scanner(System.in); 
	      OrderedLinkedList list = new OrderedLinkedList();
	      String line;
	      while((line = br.readLine())!= null){   
	      String [] r = line.split(",");

	      for(int i = 0; i < r.length; i++){
	       int val = Integer.parseInt(r[i]);
	      list1.add(val);
	      }
	      }
	      br.close();
	      int d=list1.size();
	      int[] ret = new int[d];
	      for (int i=0; i < d; i++)
	      {
	          ret[i] = list1.get(i).intValue();
	          list = insert(list,  ret[i]);
	      }    
	     System.out.print("Enter the string that you want to search: ");
	     int key=s1.nextInt();
	     searchKey(list,key);
	     printList(list);
	   }

	private static OrderedLinkedList insert(OrderedLinkedList list, int data) {
		Node new_node = new Node(data); 
        new_node.next = null; 
        
        if (list.head == null)
        { 
            list.head = new_node; 
        } 
        else
        {
        	Node last=list.head;
        	
        while (last.next != null)
        { 
         last = last.next; 
        }
        last.next=new_node;
        }
        sort(list);
		return list;
	}
	private static OrderedLinkedList sort(OrderedLinkedList list) {
		Node currentNode=list.head, index=null;
		int temp;
		if(list.head==null)
			return list ;
		else
		{
			while(currentNode != null)
			{
				index=currentNode.next;
				while(index!=null)
				{
				if(currentNode.data>index.data)
				{
					temp=currentNode.data;
					currentNode.data=index.data;
					index.data=temp;
				}
				index=index.next;
				}
				currentNode=currentNode.next;
			}
		}
		return list;
	}

	private static OrderedLinkedList searchKey(OrderedLinkedList list, int key) {
		Node currentNode=list.head,prev=null;
		 if (currentNode != null && currentNode.data == key)
		 { 
	            list.head = currentNode.next; 
	            System.out.println(key + " is found hence it is deleted........"); 
	            return list; 
	      }
		 while (currentNode != null && currentNode.data != key) 
		 { 
	            prev = currentNode; 
	            currentNode = currentNode.next; 
	      } 
		  if (currentNode != null)
		  {   
	            prev.next = currentNode.next; 
	            System.out.println(key + " is found hence it is deleted........"); 
	      } 
		  if (currentNode == null) { 
	            // Display the message 
	            System.out.println(key + " not found hence it is added......");
	            list = insert(list, key);
	        } 
		return list;	
	}
	private static void printList(OrderedLinkedList list) 
	{
		Node currentNode=list.head;
		System.out.print("LinkedList: "); 
		 while (currentNode != null)
		 { 
	            System.out.print(currentNode.data + " ");
	            currentNode = currentNode.next;       
	        } 	
	}
}

	

	