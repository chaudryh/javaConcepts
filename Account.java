import java.util.Scanner;

class Account {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public void setPassword(String p) {
		password = p;
	}
	public boolean login(String pword) {
		if(password.equals(pword)) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		Account account = new Account();
		account.setName("Bob");
		account.setPassword("Marley");
		
		Scanner scanner =  new Scanner(System.in);
		System.out.print(account.getName() + ", type your password: ");
		String password = scanner.next();
		if(account.login(password)) {
			System.out.println("Login successful.");
		} else {
			System.out.println("Login failed.");
		}	
	}
}