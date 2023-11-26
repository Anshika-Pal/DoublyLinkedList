//Doubly Linked List Operation: Insertion at End

class MyDoublyLinkedList1{
	public Node head = null;    
    public Node tail = null; 
    
	class Node{
		int data;
		Node next;
		Node previous;
		public Node(int data) {    
            this.data = data;    
            this.next = null;  
            this.previous = null;     
        }
	} 
	public void addNodeAtEnd(int data) {  
		//Create a new node  
		Node newNode = new Node(data);
		//Checks if the list is empty   
        if (head == null) {
        		head = newNode;
        		tail = newNode;
        }else {    
            //newNode will be added after tail    
        		tail.next = newNode;    
        		newNode.previous=tail;
            //newNode will become new tail of the list    
            tail = newNode;
        }    
    }    
	public void printListForward() {    
        if(head == null) {    
            System.out.println("Linked List is empty"); 
        }else { 
        	System.out.println("Nodes of Doubly linked list: ");    
	        
        	//currentNode will point to head    
            Node currentNode = head;   
	        while(currentNode != null) {     
	            System.out.print(currentNode.data + " ");    
	            currentNode = currentNode.next;    
	        }    
	        System.out.println();
        }
    }   
    
    public void printListBackward() {    
          
        if(head == null) {    
            System.out.println("Linked List is empty"); 
        }else {    
	        System.out.println("Nodes of Doubly linked list: ");    
	        
	        //currentNode will point to tail    
	        Node currentNode = tail;  
	        while(currentNode != null) {     
	            System.out.print(currentNode.data + " ");    
	            currentNode = currentNode.previous;    
	        }    
	        System.out.println();
        }
    }
}
public class DoublyLinkedList1 {
	public static void main(String[] args) {
		MyDoublyLinkedList1 list=new MyDoublyLinkedList1();
		list.addNodeAtEnd(5);
		list.addNodeAtEnd(9);
		list.addNodeAtEnd(23);
		list.addNodeAtEnd(56);
		list.addNodeAtEnd(3);
		list.printListForward();
		list.printListBackward();
	}
}
