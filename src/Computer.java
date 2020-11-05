public class Computer implements Runnable{
	ThreadSafeQueue inBound;
	ThreadSafeQueue outBound;
	//create a runnable that knows about the tasks and reults queue
	public Computer(ThreadSafeQueue in, ThreadSafeQueue out){
		this.inBound = in;
		this.outBound = out;
	}

	@Override
	public void run(){
		Digit curr;
		Bpp bpp = new Bpp();
		//while there are still tasks take one and calulate pi
		while((curr = inBound.dequeue()) != null){ 
			curr.addPi(bpp.getDecimal(curr.getNum()) / 100000000);
			outBound.enqueue(curr);
		}
		//System.out.println("Computer done!");
	}

}
