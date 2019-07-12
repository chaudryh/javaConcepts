class MyQueue<T> {
	LinkNode<T> head;
	LinkNode<T> tail;
	void enqueue(T t) {
		//first, let's make a new node
		LinkNode<T> node = new LinkNode<T>(t);
		if(tail == null){
			//there is nothing in queue
			//make this node both tail and head
			head = node;
			tail = node;
		} else {
			//second, set next pointer of the current tail
			tail.next = node;
			//third, move tail to the new node
			tail = node;
		}
	}
	T dequeue() {
		if(head == null) {
			return null;
		}
		//first, let's save data so that we can return it.
		T data = head.info;
		//second, remove head item and update head pointer
		head = head.next;
		//finally, return the data
		return data;
	}
	T peek() {
		if(head == null) {
			return null;
		}
		return head.info;
	}
	boolean empty(){
		return head==null;
	}
	
	public static void main(String[] args){
		MyQueue<String> queue = new MyQueue<String>();
		queue.enqueue("hello");
		queue.enqueue("world");
		queue.enqueue("spam");
		
		while(queue.empty()==false) {
			System.out.println(queue.dequeue());
		}
	}
}