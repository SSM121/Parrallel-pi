//simple class for keeping track of a digits loacation and value of pi
public class Digit{
	int digit;
	int pi;
	Digit(int d){
		this.digit = d;
	}
	public void addPi(int x){
		this.pi = x;
	}
	public int getPi(){
		return this.pi;
	}
	public int getNum(){
		return this.digit;
	}

}
