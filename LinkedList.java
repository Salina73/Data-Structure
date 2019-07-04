import java.io.*;
import java.util.*;

public class LinkedList {
	  Node head;
	  static class Node
	  {
		  String data;
		  Node next;
		  Node(String d) 
		  {
			  data = d;
			  next=null;
			} 
	  }	   

	private static LinkedList insert(LinkedList list, String data) {
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
	        return list;
	}
	
	private static LinkedList searchKey(LinkedList list, String key) {
		Node currentNode=list.head,prev=null;
		 if (currentNode != null && key.compareTo(currentNode.data)==0)
		 { 
	            list.head = currentNode.next; 
	            System.out.println(key + " is found hence it is deleted........"); 
	            return list; 
	      }
		 while (currentNode != null && key.compareTo(currentNode.data)!=0) 
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
	
	private static void printList(LinkedList list) {
		Node currentNode=list.head;
		System.out.print("LinkedList: "); 
		 while (currentNode != null) { 
	            System.out.print(currentNode.data + " ");
	            currentNode = currentNode.next;       
	        } 
	}
	
	public static void main(String[] args) throws IOException 
	   {
	      File f1=new File("/home/admin265/Documents/Binary/input"); 
	      FileReader fr = new FileReader(f1); 
	      BufferedReader br = new BufferedReader(fr); 
	     Scanner s1=new Scanner(System.in);
	  	  String[] words=new String[10];
	      LinkedList list = new LinkedList();
	      String s;     
	      while((s=br.readLine())!=null)   
	      {
	        words = s.split(" "); 
	      }
	      int d=words.length;
	     for(int i=0;i<d;i++)
	      list = insert(list, words[i]);
	     System.out.print("Enter the string that you want to search: ");
	     String key=s1.nextLine();
	     searchKey(list,key);
	     printList(list);
	   }
}
	   
