//Doubly Linked List Operation:  Deletion at Specific Node Value

class MyDoublyLinkedList6 {
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

	public void deleteNodeAtSpecificNodeValue(int locationValue) {
		// Checks if the list is empty
		if (head == null) {
			System.out.println("list is empty");
		} else if (locationValue == head.data && head == tail) {
			head=tail=null;
		} else if (locationValue == head.data ) {
			head=head.next;
			head.previous=null;
		} else if (locationValue == tail.data ) {
			tail=tail.previous;
			tail.next=null;
		} else {
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
				locationNode.previous.next=locationNode.next;
				locationNode.next.previous=locationNode.previous;
			}
		}
	}

	public void printListForward() {
		if (head == null) {
			System.out.println("Linked List is empty");
		} else {
			System.out.println("Nodes of Doubly linked list: ");

			// currentNode will point to head
			Node currentNode = head;
			while (currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.next;
			}
			System.out.println();
		}
	}

	public void printListBackward() {

		if (head == null) {
			System.out.println("Linked List is empty");
		} else {
			System.out.println("Nodes of Doubly linked list: ");

			// currentNode will point to tail
			Node currentNode = tail;
			while (currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.previous;
			}
			System.out.println();
		}
	}
}
public class DoublyLinkedList6 {
	public static void main(String[] args) {
		MyDoublyLinkedList6 list = new MyDoublyLinkedList6();
		list.addNodeAtEnd(5);
		list.addNodeAtEnd(9);
		list.addNodeAtEnd(35);
		list.addNodeAtEnd(95);
		list.addNodeAtEnd(75);

		list.deleteNodeAtSpecificNodeValue(5);

		list.printListForward();
		list.printListBackward();
	}
}
