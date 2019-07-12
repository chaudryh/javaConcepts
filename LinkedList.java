class LinkedList<T>{
	LinkNode<T> head;
	int size;
	//this utility method return a node at the given index
	private LinkNode<T> getNode(int index){
		LinkNode<T> p = head;
		for(int i =0; i<index; ++i){
			p = p.next;
		}
		return p;
		
	}
	void insert(int index, T t){
		LinkNode<T> node = new LinkNode<T>(t);
		if(index == 0){
			node.next = head;
			head = node;
		}else if(index==size){
			LinkNode<T> p = getNode(index-1);
			p.next = node;
		}else{
			LinkNode<T> p = getNode(index-1);
			LinkNode<T> q = getNode(index);
			p.next = node;
			node.next = q;
		}
		size = size +1; //maintain size
	}
	T remove(int index){
		if(index>= size){
			return null;
		}
		T data = null;
		if(index ==0){
			data = head.info;
			head = head.next;
			return data;
		}else{
			LinkNode<T> p = getNode(index-1);
			LinkNode<T> q = getNode(index);
			p.next = q.next;
			data = q.info;
		}
		size = size -1;
		return data;
	}
	T get(int index){
		return getNode(index).info;
	}
	int size(){
		return size;
	}
	public static void main(String[] args){
		LinkedList<String> list = new LinkedList<String>();
		list.insert(0, "hello");
		list.insert(1, "world");
		list.insert(1, "spam");
		for(int i =0; i<3; ++i){
			System.out.println(list.get(i));
		}
	}
}