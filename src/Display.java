
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Display implements Runnable{
	ThreadSafeQueue task;
	ThreadSafeQueue results;
	Terminal terminal;;
	Display(ThreadSafeQueue task, ThreadSafeQueue results)throws Exception{
		this.task = task;
		this.results = results;
		DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
		terminal = defaultTerminalFactory.createTerminal();
		terminal.clearScreen();
	}
	@Override
	public void run( ){
		try{
			terminal.setCursorPosition(0,1);
			terminal.putCharacter('3');
			terminal.setCursorPosition(1,1);
			terminal.putCharacter('.');
			terminal.flush();
			Digit curr;
			int row, col, i = 0;
			while(i < 1024){
				
				curr = results.dequeue();
				if(curr != null){
					row = ((curr.getNum() - 1) / 64) + 1;
					col = ((curr.getNum() - 1) % 64) + 2;
					terminal.setCursorPosition(col, row);
					terminal.putCharacter((char)(curr.getPi() + '0'));
					//terminal.putCharacter('1');
					terminal.flush();
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
