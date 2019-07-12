import java.util.ArrayList;

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

class Cat extends Feline implements Pet{
	void eat() {
		System.out.println("Cat is eating.");
	}
	public void beFriendly() {
		System.out.println("Cat is not really friendly, but trying to be.");
	}
	public void play(){
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
	public void play(){
		System.out.println("Dog plays all the time.");
	}
}

class AnimalChecker {
	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Hippo());
		animals.add(new Cat());
		animals.add(new Dog());
		//animals.add(new Animal());
		for (Animal animal: animals) {
			animal.eat();
			if(animal instanceof Pet) {
				Pet p = (Pet) animal;
				p.beFriendly();
				p.play();
			}
		}
		
		System.out.println(); //blank line
		Pet[] pets = new Pet[2];
		pets[0] = new Cat();
		pets[1] = new Dog();
		for (Pet pet: pets) {
			pet.beFriendly();
			pet.play();
			if (pet instanceof Animal) { //make sure pet extend Animal class
			Animal a = (Animal) pet; //cat pet to an Animal so that we can call methods in Animal
			a.eat();
			}
		}
		
	}
}
