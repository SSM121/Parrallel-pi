
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Display implements Runnable{
	//holds list of items to be calculated
	ThreadSafeQueue task;
	//holds a list of items that have been calculated
	ThreadSafeQueue results;
	//laterna terminal object
	Terminal terminal;
	//constructor that takes in references to the 2 main lists
	Display(ThreadSafeQueue results)throws Exception{
		
		this.results = results;
		//creates a laterna terminal
		DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
		terminal = defaultTerminalFactory.createTerminal();
		terminal.clearScreen();
	}
	@Override
	public void run( ){
		try{
			//write the 3. in the terminal
			terminal.setCursorPosition(0,1);
			terminal.putCharacter('3');
			terminal.setCursorPosition(1,1);
			terminal.putCharacter('.');
			terminal.flush();
			Digit curr;
			int row, col, i = 0;
			//loop while we have not calulated 1024
			while(i < 1024){
				//try to dequeue
				curr = results.dequeue();
				//if it is successful
				if(curr != null){
					//calculate the relative row and column of the element
					row = ((curr.getNum() - 1) / 64) + 1;
					col = ((curr.getNum() - 1) % 64) + 2;
					//sets cursor at postion and puts the char there
					terminal.setCursorPosition(col, row);
					terminal.putCharacter((char)(curr.getPi() + '0'));
					//terminal.putCharacter('1');
					terminal.flush();
					//increment the count of successes
					i++;
				}
			}
			//System.out.format("Laterna finished printing %d numbers\n", i);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
