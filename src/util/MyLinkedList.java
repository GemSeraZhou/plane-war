package util;
/**
 * ��������ʵ��
 * @author Administrator
 *
 * 
 */

public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head,tail;
	
	public MyLinkedList(){
		
	}
	
	public MyLinkedList(E[] objects){
		super(objects);
	}
	/**
	 * ��ȡ��һ��Ԫ��
	 * @return E
	 */
	public E getFirst(){
		if(size == 0){
			return null;
		}
		else{
			return head.element;
		}
	}
	/**
	 * ��ȡ���һ��Ԫ��
	 * @return E
	 */
	public E getLast(){
		if(size==0)
			return null;
		else return tail.element;
	}
	/**
	 * ���Ԫ�ص���ͷ
	 * @param e �����Ԫ��
	 */
	public void addFirst(E e){
		Node<E> newNode = new Node<E>(e);
		newNode.next = head;
		head = newNode;
		size++;
		
		if(tail == null)
			tail = head;
	}
	/**
	 * ���Ԫ�ص���β
	 * size==0ʱ������㣬tail,headָ���½ڵ�
	 * @param e �����Ԫ��
	 */
	public void addLast(E e){
		Node<E> newNode= new Node<E>(e);
		if(tail==null){
			head = tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = tail.next;
		}
		
		size++;
	}
	/**
	 * ���Ԫ�ص�indexλ,indexС�ڵ���0,index==0����ӵ���ͷ,indexС�ڵ���size��ӵ���β
	 */
	public void add(int index,E e){
		if(index == 0) addFirst(e);
		else if (index>=size) addLast(e);
		else{
			Node<E> current = head;
			for(int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}
	/**
	 * ɾ����ͷ
	 * size == 0ʱ����null
	 * @return E
	 */
	public E removeFirst(){
		if(size == 0) return null;
		else{
			Node<E> temp = head;
			head = head.next;
			if(size == 1)
				tail = null;
			size--;
			return temp.element;
		}
	}
	/**
	 * ɾ����β
	 * size==0ʱ����null
	 * @return E
	 */
	public E removeLast(){
		if(size == 0) return null;
		else if(size == 1)
		{
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else {
			Node<E> current = head;
			
			for(int i = 0; i < size-2; i++)
				current = current.next;
			
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}
	/**
	 * ɾ��ָ��λ��
	 * indexС��0||index���ڵ���sizeʱ,����null
	 */
	public E remove(int index){
		if(index<0||index>=size) return null;
		else if(index == 0) return removeFirst();
		else if(index == size-1) return removeLast();
		else{
			Node<E> previous = head;
			
			for(int i = 1; i < index; i++){
				previous = previous.next;
			}
			
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}
	/**
	 * �������鳤��
	 * @return size
	 */
	public int length(){
		return size;
	}
	/**
	 * ��ӡ��������
	 * @return string
	 */
	public String tostring(){
		StringBuffer result = new StringBuffer("[");
		
		Node<E> current = head;
		for(int i = 0; i < size; i++){
			result.append(current.element);
			current = current.next;
			if(current != null){
				result.append(", ");
			}
			else {
				result.append("]");
			}
		}
		
		return result.toString();
	}
	/**
	 * �������
	 */
	public void clear(){
		head = tail = null;
		size = 0;
	}
	
	public boolean contains(E e) {
		System.out.println("Implementaton left as an exercise");
		return true;
	}
	/**
	 * ��ȡָ��λ��Ԫ�أ�����E
	 * indexС��0||index����sizeʱ������null
	 */
	public E get(int index) {
		if(index<0||index>size) return null;
		if(index == 0) return head.element;
		Node<E> temp = head;
		for(int i = 0; i < index; i++)
			temp = temp.next;
		return temp.element;
	}
	
	public int indexOf(E e) {
		System.out.println("Not implementation");
		return 0;
	}
	
	public int lastIndexOf(E e){
		System.out.println("Not implementation");
		return 0;
	}
	
	public E set(int index,E e){
		System.out.println("Not implementation");
		return null;
	}
	
	@Override
	public int lastIndex(E e) {
		System.out.println("Not implementation");
		return 0;
	}
	/**
	 * ����ڵ㣬Ԫ����element,next,elementΪ���ݣ�nextָ����һ�����
	 * @author Administrator
	 *
	 * @param <E>
	 */
	private static class Node<E>{
		E element;
		Node<E> next;
		
		public Node(E element){
			this.element = element;
		}
	}


}

