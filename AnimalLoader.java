import java.util.ArrayList;
import java.util.Scanner;
import java.lang.InstantiationException;
import java.lang.ClassNotFoundException;
import java.lang.IllegalAccessException;

interface Pet {
	void beFriendly(); 
	void play();
}

abstract class Animal {
	abstract void eat();
}

abstract class Feline extends Animal {

}

abstract class Canine extends Animal {
	
}

class Hippo extends Animal {
	void eat() {
		System.out.println("Hippo is eating.");
	}
}

class Cat extends Feline implements Pet {
	void eat() {
		System.out.println("Cat is eating.");
	}
	public void beFriendly() {
		System.out.println("Cat is not really friendly but trying to be.");
	}
	public void play() {
		System.out.println("Cat can be playful sometimes.");
	}
}

class Dog extends Canine implements Pet {
	void eat() {
		System.out.println("Dog is eating.");
	}
	public void beFriendly() {
		System.out.println("Dog is friendly. That's what they do.");
	}
	public void play() {
		System.out.println("Dog plays all the time.");
	}
}

class AnimalLoader {
	public static void main(String[] args) {
		//1. ask the user which animal to load
		System.out.print("Enter the type of Animal: ");
		Scanner scanner = new Scanner(System.in); //scanner for the keyboard.
		String animalType = scanner.next();
		
		try {
			//2. instantiate the Animal object
			//dynamically load the Animal class 
			Class animalClass = Class.forName(animalType); 
			//instantiate the Animal object
			Animal animal = (Animal)animalClass.newInstance();
			
			//3. call its eat() method.
			animal.eat();
		} catch(ClassNotFoundException ex) {
			System.out.println("The class " + animalType + " does not exist.");
		} catch(InstantiationException ex) {
			System.out.println("It failed to instantiate " + animalType);
		} catch(IllegalAccessException ex) {
			System.out.println("What you are doing is illegal!");
		}finally {
			scanner.close();
		}
	}
}