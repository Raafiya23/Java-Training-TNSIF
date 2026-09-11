package nonaccessmodifiers.dayfour;

final public class FinalDemo {
	
	final int x = 100;
	
	final void show() {
		System.out.println("The value of x: "+x);
	}

	public static void main(String[] args) {
		
		FinalDemo fd = new FinalDemo();
		//fd.x = 200;
		fd.show();
		
	}

}

/*class Demo extends FinalDemo{
	void show() {
		System.out.println("Printing the show method");
	}
}*/
