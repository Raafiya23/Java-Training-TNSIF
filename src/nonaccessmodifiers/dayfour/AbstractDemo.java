package nonaccessmodifiers.dayfour;

abstract class Shape {
	
	abstract void draw();
	
	void disp() {
		
	}
}

public class AbstractDemo extends Shape {
	
	void draw() {
		System.out.println("Drawing a Circle...");
	}
	
	public static void main(String[] args) {
		
		AbstractDemo ad = new AbstractDemo();
		ad.draw();
		
		//Shape s = new AbstractDemo();
		
	}

}
