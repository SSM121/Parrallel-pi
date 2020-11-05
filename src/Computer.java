public class Computer implements Runnable{
	ThreadSafeQueue inBound;
	ThreadSafeQueue outBound;
	public Computer(ThreadSafeQueue in, ThreadSafeQueue out){
		this.inBound = in;
		this.outBound = out;
	}

	@Override
	public void run(){
		Digit curr;
		Bpp bpp = new Bpp();
		while((curr = inBound.dequeue()) != null){
			curr.addPi(bpp.getDecimal(curr.getNum()) / 100000000);
			outBound.enqueue(curr);
		}
		//System.out.println("Computer done!");
	}

}
