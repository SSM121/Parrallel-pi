import java.util.LinkedList;
import java.util.Collections;
//queue that is a thread protected linked list
public class ThreadSafeQueue{
	private LinkedList<Digit> qList; //the actual data

	ThreadSafeQueue(){ // a constructor
		qList = new LinkedList<Digit>();
	}
	public boolean isEmpty() { return qList.isEmpty(); } //checks if empty
	public synchronized void enqueue(Digit item) { qList.addLast(item); } //adds object to array
	public synchronized Digit dequeue() { //get an item off the list. only one thread can pull at a time.
		if (qList.isEmpty()) return null;
		else return qList.removeFirst();
	}
	public void random(){ //shuffles the list
		Collections.shuffle(qList);
	}
	public void reverse(){ //reveses the list
		Collections.reverse(qList);
	}
	public String toString(){ //while not needed for the assignment this was for debugging
		return qList.toString();
	}

}
