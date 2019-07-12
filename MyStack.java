class MyStack<T>{
	LinkNode<T> top;
	void push(T t){
		//first, make LinkNode for this new data
		LinkNode<T> node = new LinkNode<T>(t);
		//second, link up this new node to the stack
		node.next = top;
		//third, update top to node
		top = node;
		
	}
	T pop(){
		if(top==null){
			return null;
		}
		//first keep the data to return
		T data = top.info;
		//second, remove the top item from the stack
		top = top.next;
		return data;
	}
	T peek(){
		if(top ==null) {
			return null;
		}else {
			return top.info;
		}
	}
	//returns true if stack is empty
	boolean empty(){
		return top == null;
		
	}
	public static void main(String[] args){
		MyStack<String> stack = new MyStack<String>();
		stack.push("hello");
		stack.push("world");
		stack.push("spam");
		while(stack.empty() == false){
			System.out.println(stack.pop());
			
		}
	}
}