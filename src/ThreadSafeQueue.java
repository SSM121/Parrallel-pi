import java.util.LinkedList;
import java.util.Collections;

public class ThreadSafeQueue{
	private LinkedList qList;

	ThreadSafeQueue(){
		qList = new LinkedList();
	}
	public boolean isEmpty() { return qList.isEmpty(); } //checks if empty
	public void enqueue(Object item) { qList.addLast(item); } //adds object to array
	public synchronized Object dequeue() { //get an item off the list. only one thread can pull at a time.
		if (qList.isEmpty()) return null;
		else return qList.removeFirst();
	}
	public void random(){
		Collections.shuffle(qList);
	}
	public void reverse(){
		Collections.reverse(qList);
	}
	public String toString(){
		return qList.toString();
	}

}
