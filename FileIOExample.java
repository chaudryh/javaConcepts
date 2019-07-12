import java.io.*;
import java.util.Scanner;

class MyRecord implements Serializable{
	String name;
	int age;
}

class FileIOExample {
	static String filename = "FileIOExample.java";
	public static void main(String[]args) {
		{
			/*//FILE is like an icon of a file - it has information about the file
			//but no content.
			File file = new File(filename);
			System.out.println(file.getPath());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getName());
			System.out.println(file.getParent());
			System.out.println("Exist: " + file.exists() + ", canRead: " + file.canRead());
			
			File curdir = new File(".");
			System.out.println("List of files::");
			for(File f: curdir.listFiles()) {
				System.out.println("\t" + f.getName());
			}*/
		}
		{
			/*//FileReader - a primitive text reader. 
			//it can ready character by character.
			File file = new File(filename);
			try {
				FileReader reader = new FileReader(file);
				int c;
				while((c = reader.read()) != -1) { System.out.print((char)c);}
				reader.close();
			}catch(IOException ex) { 
				ex.printStackTrace(); 
			}*/
		}
		{
			/*//FileWriter - a primitive text writer.
			File file = new File("temp.txt");
			try {
				FileWriter writer = new FileWriter(file);
				writer.write("Hello world.");
				writer.close();
			}catch(IOException ex) { 
				ex.printStackTrace(); 
			}*/
		}
		{
			/*//BufferedReader - it bufferes data so that it does not have to
			//access the file often. It can read line by line.
			File file = new File(filename);
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String c;
				while((c = reader.readLine()) != null) { System.out.println(c);}
				reader.close();
			}catch(IOException ex) { 
				ex.printStackTrace(); 
			}*/
		}
		{
			/*//BufferedWriter - it buffers data so that it does not have to 
			//access the file often. 
			BufferedWriter writer=null;
			File file = new File("temp.txt");
			try {
				writer = new BufferedWriter(new FileWriter(file));
				for(int i=0; i<3; ++i) {
					writer.write("hello world");
					writer.newLine();
				}
				writer.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}*/
		}
		{
			//Scanner - versatile reader. It can handle not only file but also
			//keyboard and String. It can parse String to int and double.
			/*Scanner scanner = null;
			File file = new File(filename);
			try {
				scanner = new Scanner(file);
				while(scanner.hasNext()) {
					String s = scanner.next();
					System.out.print(s);
				}
				scanner.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}*/
		}
		{
			/*//FileInputStream - a raw data reader.
			FileInputStream istream = null;
			File file = new File(filename);
			try {
				istream = new FileInputStream(file);
				byte[] data = new byte[istream.available()];
				int n = istream.read(data); //read the entire file
				System.out.println(n + "bytes read.");
				System.out.println(data);
			istream.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}*/
		}
		{
			//FileOutputStream - a raw data writer
			/*FileOutputStream ostream = null;
			File file = new File("raw.data");
			try {
				ostream = new FileOutputStream(file);
				for(int i=0; i<1000; ++i) {
					ostream.write(i); //write each byte
				}
				ostream.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}*/
		}
		{
			/*//Serialization (to write objects to a file) and 
			//de-Serialization (to read objects from a file).
			
			//ObjectInputStream - used to de-serialize. it is constructed via FileInputStream.
			ObjectInputStream is = null;
			File file = new File("saved.data");
			MyRecord o = null;
			if(file.exists()) {
				try {
					is = new ObjectInputStream(new FileInputStream(file));
					o = (MyRecord) is.readObject(); //restore the object. Need to cast.
					is.close();
				} catch(IOException ex) { 
					ex.printStackTrace(); 
				} catch (ClassNotFoundException ex) { 
					ex.printStackTrace(); 
				}
				System.out.println("Welcome " + o.name + " of " + o.age + " years old.");
			} else { //no previous serialization. Get input from the keyboard.
				o = new MyRecord();
				Scanner scanner = new Scanner(System.in);
				System.out.print("Your name: ");
				o.name = scanner.next();
				System.out.print("Your age: ");
				o.age = scanner.nextInt();
			}
			
			//ObjectOutputStream - used to serialize. it is constructed via FileOutputStream.
			ObjectOutputStream os = null;
			try {
				os = new ObjectOutputStream(new FileOutputStream(file));
				os.writeObject(o); //save the object to saved.data
				os.close();
			} catch(IOException ex) { 
				ex.printStackTrace(); 
			}
			System.out.println("Your data has been saved.");
			*/
		}
	}
}