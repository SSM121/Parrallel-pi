import java.io.IOException;
import java.lang.System;
import java.lang.Runtime;



public class ParallelPi{
	/* 0 = forward
	 * 1 = reverse
	 * 2 = random */
	static int order = 0;
	static int workers;

	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		workers = Runtime.getRuntime().availableProcessors();
		if(args.length > 0){
			if(args[0].compareTo("-reverse") == 0){
				order = 1;
			}
			else 
			{
				if(args[0].compareTo("-random") == 0){
					order = 2;
				}
				else
				{
					System.out.println("Usage: ParallelPi [-reverse|-random]");
					System.exit(1);
				}
			}
		}
		ThreadSafeQueue task = new ThreadSafeQueue();
		ThreadSafeQueue result = new ThreadSafeQueue();
		for(int i = 1; i <= 1024; i++){
			task.enqueue(new Digit(i));
		}
		switch(order){
			case 1:
				task.reverse();
				break;
			case 2:
				task.random();
				break;
		}
		try{
			Display display = new Display(task, result);
			//System.out.format("The number of works is: %d\n", workers);
			for(int i = 0; i < workers; i++)
			{
				new Thread(new Computer(task, result), "Computer: " + i).start();
			}
			Thread write = new Thread(display, "Display");
			write.start();
			write.join();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
 
        	long timeElapsed = endTime - startTime;
		System.out.format("\nIt took %d milliseconds to calculate pi\n", timeElapsed);
	}
}


