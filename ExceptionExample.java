
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class ExceptionExample
{
	public static void main(String[] args) {
		File file = new File("ExceptionExample2.java");
		//let's read the file using Scanner
		Scanner scanner = null; //just declare a Scanner variable
		//scanner = new Scanner(System.in); //to read from keyboard.
		
		//this line below possibly fails if the file does not exists.
		//if the file does not exists, Scanner constructor will generates FileNotFoundException
		try {
			scanner = new Scanner(file); //open the file to read via Scanner
		} catch(FileNotFoundException ex) {//ex is just a name of the Exception object
			//here we want to handle the exception.
			System.out.println("The file does not exist.");
			ex.printStackTrace();
			return;
		//} catch(Exception ex) { //catch all the exception types
		} finally { //this block will be run no matter what.
			System.out.println("I am in finally block.");
			scanner.close();
		}
		System.out.println("I am outside the finally block");
	}
}