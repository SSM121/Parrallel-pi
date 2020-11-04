import java.io.IOException;
import java.lang.System;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


public class ParallelPi{
	/* 0 = forward
	 * 1 = reverse
	 * 2 = random */
	static int order = 0;
	public static void main(String[] args){
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
		DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
		Terminal terminal = null;
		try{
			terminal = defaultTerminalFactory.createTerminal();
			terminal.clearScreen();

		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}


class digit{
	int digit;
	digit(int d){
		this.digit = d;
	}

}