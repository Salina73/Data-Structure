//printing queue

private static void printlist(Node front) 
	{
        System.out.print("\nQueue = ");
        if (size == 0)
        {
        	System.out.print("Empty\n");
        	return ;
        }
        Node ptr = front;
        while (ptr != rear.next)
        {
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();        
    }		
	}