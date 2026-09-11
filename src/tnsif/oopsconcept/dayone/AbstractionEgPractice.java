package tnsif.oopsconcept.dayone;

abstract class Phone{
	
	abstract void click();

}

class Camera extends Phone{
	
	void click() {
		System.out.println("Photo is taken...");
	}
}

public class AbstractionEgPractice {

	public static void main(String[] args) {
		
		Camera c = new Camera();
		c.click();
		
		Phone p = new Camera();

	}

}
