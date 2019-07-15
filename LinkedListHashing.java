package com.bridgelab;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class LinkedHash 
{
    int value;
    LinkedHash next;
    LinkedHash(int v) 
    {
    	this.value = v;
    	this.next = null;
    }
}

public class LinkedListHashing 
{

	private static LinkedHash[] table;
	 public LinkedListHashing() 
	  {
	        table = new LinkedHash[11];
	        for (int i = 0; i < 11; i++)
	            table[i] = null;
	    } 
	    public void makeEmpty()
	    {
	        for (int i = 0; i < 11; i++)
	        	table[i] = null;

	    }
	
	public static void main(String[]args) throws Exception
	{
		File f1=new File("/home/admin1/Documents/Binary/input1"); 
	      FileReader fr = new FileReader(f1); 
	      BufferedReader br = new BufferedReader(fr); 
	      List<Integer>list1 = new ArrayList<Integer>();
	      Scanner s1=new Scanner(System.in); 
	      LinkedListHashing  list = new LinkedListHashing();
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
	          insert(ret,ret[i]);
	      }  
	     
	}
	private static void insert(int[] ret, int value) {
		int hash = value % 11;
        if (table[hash]== null)
        {
            table[hash] = new LinkedHash(value);
        }
        else 
        {
            LinkedHash h = table[hash];

            while (h.next != null)
            	h = h.next;
              h.next = new LinkedHash(value);
        }
        return;
	}

    public void printHashTable()
    {
    	for (int i = 0; i < 11; i++)
        {
            System.out.print("\nBucket "+ (i + 1) +" : ");
            LinkedHash h = table[i];
            while (h != null)
            {
                System.out.print(h.value +" ");
                h = h.next;
            }            
        }
    }
}
