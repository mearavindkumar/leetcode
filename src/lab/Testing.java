package lab;

interface I {
	static int speed = 12;
	String s = "speed";
}

class Animal {

	public void eat() throws NullPointerException {
		System.out.println("animal eats");
	}

}

class Dog extends Animal {

	void eat(String s) throws Exception {
		System.out.println("Dog eats " + s);
	}
}

class Person {
	int age;
	String name;

	public void read() {
		System.out.println("Person is reading");
	}

}

class SuperClass {
	public void method() {
		System.out.println("SuperClass");
	}
}

final class Sub extends SuperClass {
	@Override
	public void method() {
		System.out.println("SubClass");
	}
}

class Divider {
	double divide(int i, int j) {
		return i / j;
	}
}

class MainClass {
	MainClass() {
		System.out.println("MainClass");
	}
}

class SubClass extends MainClass {
	{
		System.out.println("i ");
	}
	static {
		System.out.println("s ");
	}

	SubClass(int i) {
		this();
		System.out.println("SubClass");
	}

	SubClass() {
		super();
		System.out.println("SubClass");
	}
}

class Parent {
	protected void go() throws java.io.FileNotFoundException {
		System.out.println("");
	}
}

class Child extends Parent {
	@Override
	protected void go() throws IndexOutOfBoundsException {
		System.out.println("");
	}
}

class Exam {
	Exam(String s) {
		System.out.println(s);
	}
}

class Square extends Testing {

}

public class Testing {

	static boolean b = false;

	public static void main(String[] args) {

	}

}
