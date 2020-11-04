public class Computer implements Runnable{
	ThreadSafeQueue inBound;
	ThreadSafeQueue outBound;
	public Computer(ThreadSafeQueue in, ThreadSafeQueue out){
		this.inBound = in;
		this.outBound = out;
	}

	@Override
	public void run(){

	}

}
