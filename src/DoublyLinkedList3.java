//Doubly Linked List Operation: Insertion after Specific Node Value of Linked List

class MyDoublyLinkedList3 {
	public Node head = null;
	public Node tail = null;

	class Node {
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
		// Create a new node
		Node newNode = new Node(data);
		// Checks if the list is empty
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			// newNode will be added after tail
			tail.next = newNode;
			newNode.previous = tail;
			// newNode will become new tail of the list
			tail = newNode;
		}
	}

	public void addNodeAfterSpecificNodeValue(int locationValue, int data) {
		// Checks if the list is empty
		if (head == null) {
			System.out.println("list is empty");
		}else if(locationValue==head.data && head==tail) {
			// Create a new node
			Node newNode = new Node(data);
			head.next=newNode;
			newNode.previous=head;
			tail=newNode;
		}else if(locationValue==tail.data) {
			// Create a new node
			Node newNode = new Node(data);
			newNode.previous = tail;
			tail.next = newNode;
			tail=newNode;
		}else {
			// Create a new node
			Node newNode = new Node(data);
			
			Node currentNode = head;
			Node locationNode = null;
			while (currentNode != null) {
				if (currentNode.data == locationValue) {
					locationNode = currentNode;
					break;
				}
				currentNode = currentNode.next;
			} 
			if (locationNode == null) {
				System.out.println("Location Value does not exist.");
			} else {
				newNode.next = locationNode.next;
				newNode.previous = locationNode;
				locationNode.next = newNode;
				newNode.next.previous = newNode;
			}
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
public class DoublyLinkedList3 {
	public static void main(String[] args) {
		MyDoublyLinkedList3 list = new MyDoublyLinkedList3();
		list.addNodeAtEnd(5);
		list.addNodeAtEnd(9);
		list.addNodeAtEnd(23);
		list.addNodeAtEnd(56);
		list.addNodeAtEnd(3);
		list.printListForward();
		list.addNodeAfterSpecificNodeValue(3, 87);
		list.printListForward();
	}
}
