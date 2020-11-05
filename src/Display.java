
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Display implements Runnable{
	
	Display()throws Exception{
		DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
		Terminal terminal = null;
		terminal = defaultTerminalFactory.createTerminal();
		terminal.clearScreen();
	}
	@Override
	public void run(){

	}
}
