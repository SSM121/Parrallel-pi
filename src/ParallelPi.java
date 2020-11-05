import java.io.IOException;
import java.lang.System;
import java.lang.Runtime;



public class ParallelPi{
	/* 0 = forward
	 * 1 = reverse
	 * 2 = random */
	static int order = 0; //keeps track of which kind of order
	static int workers; //keeps track of how many work threads

	public static void main(String[] args){
		//get the start time in millis
		long startTime = System.currentTimeMillis();
		//get the number of processors you can use
		workers = Runtime.getRuntime().availableProcessors();
		//parse the command line and set order to the appropriate value
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
		//create 2 queues one for items to be calculated and one with items that need to be printed.
		ThreadSafeQueue task = new ThreadSafeQueue();
		ThreadSafeQueue result = new ThreadSafeQueue();
		//fill the task queue with the digits 1 - 1024
		for(int i = 1; i <= 1024; i++){
			task.enqueue(new Digit(i));
		}
		//sort the queue from parsed command line
		switch(order){
			case 1:
				task.reverse();
				break;
			case 2:
				task.random();
				break;
		}
		try{
			//create a dislay object that takes care of laterna
			Display display = new Display(result);
			//System.out.format("The number of works is: %d\n", workers);
			//create work object threads and let them begin calculating digits of pi 
			for(int i = 0; i < workers; i++)
			{
				new Thread(new Computer(task, result), "Computer: " + i).start();
			}
			//create a thread to control the display objects and start it
			Thread write = new Thread(display, "Display");
			write.start();
			write.join();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//get end time in millis. caclulated the difference and print
		long endTime = System.currentTimeMillis();
 
        	long timeElapsed = endTime - startTime;
		System.out.format("\nIt took %d milliseconds to calculate pi\n", timeElapsed);
	}
}


