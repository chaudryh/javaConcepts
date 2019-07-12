import java.util.ArrayList;
import java.util.Scanner;

class FriendsList {
	public static void main(String[] args) {
		ArrayList<String> friends = new ArrayList<String>();
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter friends' names. quit to end.");
		while (true) {
			String name = scanner.next();
			if(name.equals("quit")){
				break;
			}
			friends.add(name);
		}	
		System.out.println(); //insert a new line
		for (int i = 0; i<friends.size();++i){
			System.out.println("Friend #" + (i+1) + ": " + friends.get(i));
		}
		System.out.println("We make the first friend uppercase.");
		friends.set(0, friends.get(0).toUpperCase());
		for(String friend: friends) {
			System.out.println("Friend " + friend);
		}
		System.out.println("Let's remove one friend: ");
		String name = scanner.next();
		friends.remove(name); //remove this particular object
		System.out.println(friends);
		
		System.out.print("Let's remove another friend. ");
		name = scanner.next();
		int index = friends.indexOf(name);
		friends.remove(index); //remove an item at this index
		System.out.println(friends);
		
	}
}