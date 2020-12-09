import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.plaf.synth.SynthSpinnerUI;

import java.util.HashSet;

public class Library {
	private String name;
	private String phoneNum;
	private String email;
	private String address;
	private static Scanner input = new Scanner(System.in);

	private List<Book> bookshelf = new ArrayList<Book>();
	private List<eLearning> eLearningBS = new ArrayList<eLearning>();
	private Set<Borrower> borrowList = new HashSet<Borrower>();
	private Set<Admin> adminList = new HashSet<Admin>();

	public Library(String name, String phoneNum, String email, String address) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String libraryContact() {
		return "\nName: " + name + "\nPhone number: " + phoneNum + "\nE-mail: " + email + "\nAddress: " + address;
	}

	public Set<Borrower> searchName(String name) {
		Set<Borrower> borrowerSearch = new HashSet<Borrower>();
		for (Borrower borrower : borrowList) {
			if (borrower.getName().equals(name)) {
				borrowerSearch.add(borrower);
			}
		}
		if (borrowerSearch.isEmpty()) {
			System.out.println("\nDon't have this borrower.");
		}
		return borrowerSearch;
	}

	public List<Book> searchByTitle(String title) {
		List<Book> bookSearch = new ArrayList<Book>();
		for (Book book : bookshelf) {
			if (book.getTitle().equals(title)) {
				bookSearch.add(book);
			}
		}
		if (bookSearch.isEmpty()) {
			System.out.println("\nDon't have this book.");
		}
		return bookSearch;
	}

	public List<Book> searchByWriter(String writer) {
		List<Book> bookSearch = new ArrayList<Book>();
		for (Book book : bookshelf) {
			if (book.getWriter().equals(writer)) {
				bookSearch.add(book);
			}
		}
		if (bookSearch.isEmpty()) {
			System.out.println("\nDon't have this writer.");
		}
		return bookSearch;
	}

	public List<eLearning> searchBySubject(String subject) {
		List<eLearning> eLearningSearch = new ArrayList<eLearning>();
		for (eLearning ELearning : eLearningBS) {
			if (ELearning.getSubject().equals(subject)) {
				eLearningSearch.add(ELearning);
			}
		}
		if (eLearningSearch.isEmpty()) {
			System.out.println("\nDon't have this subject.");
		}
		return eLearningSearch;
	}

	public List<eLearning> searchByTeacher(String teacher) {
		List<eLearning> eLearningSearch = new ArrayList<eLearning>();
		for (eLearning ELearning : eLearningBS) {
			if (ELearning.getTeacher().equals(teacher)) {
				eLearningSearch.add(ELearning);
			}
		}
		if (eLearningSearch.isEmpty()) {
			System.out.println("\nDon't have this teacher.");
		}
		return eLearningSearch;
	}

	public void borrow(List<Book> book, Set<Borrower> borrower) {
		for (Book bookie : book) {
			if (bookie.reduceBook()) {
				System.out.println("Thank you, Borrow Book Complete.");
				System.out.println(bookie.toString());
				for (Borrower borrowerii : borrower) {
					System.out.println(borrowerii.toString());
				}
			} else {
				System.out.println("You can't BORROW this book.");
			}
		}
	}

	public void returnBook(List<Book> book, Set<Borrower> borrower) {
		for (Book bookie : book) {
			if (bookie.increaseBook()) {
				System.out.println("Thank you, Return Book Complete.");
				System.out.println(bookie.toString());
				for (Borrower borrowerii : borrower) {
					System.out.println(borrowerii.toString());
				}
			} else {
				System.out.println("You can't RETURN this book.");
			}
		}
	}

	public void study(List<eLearning> EL) {
		if (!EL.isEmpty()) {
			System.out.println("You are learning.");
			for (eLearning eLearn : EL) {
				System.out.println(eLearn.toString());
			}
		}
	}

	public void getAllBook() {
		for (Book book : bookshelf) {
			System.out.println(book.toString());
		}
	}

	public void getAllELearning() {
		for (eLearning ELearning : eLearningBS) {
			System.out.println(ELearning.toString());
		}
	}

	public void getAllBorrower() {
		for (Borrower borrower : borrowList) {
			System.out.println(borrower.toString());
		}
	}

	public void getAllAdmin() {
		for (Admin admin : adminList) {
			System.out.println(admin.toString());
		}
	}

	public void printBookResult(List<Book> bookSearch) {
		for (Book book : bookSearch) {
			System.out.println(book.toString());
		}
	}

	public void printELResult(List<eLearning> ESearch) {
		for (eLearning EL : ESearch) {
			System.out.println(EL.toString());
		}
	}

	public void printBRResult(Set<Borrower> BRSearch) {
		for (Borrower BR : BRSearch) {
			System.out.println(BR.toString());
		}
	}

	public void user() {
		System.out.println("\nWelcome to the " + getName());
		System.out.println("[0] = Contact Us");
		System.out.println("[1] = Register");
		System.out.println("[2] = Borrow Book");
		System.out.println("[3] = Return Book");
		System.out.println("[4] = Study E-Learning");
		System.out.println("[5] = Search Book Title");
		System.out.println("[6] = Search Book Writer");
		System.out.println("[7] = Search E-LEarning Subject");
		System.out.println("[8] = Search E-Learning Teacher");
		System.out.println("[9] = See All Book");
		System.out.println("[10] = See All E-Learning");
		System.out.println("[11] = Login Admin Mode");
		System.out.println("[12] = Exit");
		System.out.println("Please input number to continue: ");
		int select = input.nextInt();
		input.nextLine();

		switch (select) {
		case 0:
			System.out.println("Contact Us");
			System.out.println(libraryContact());
			whatNext();
			break;
		case 1:
			System.out.println("Register");
			System.out.println("Name: ");
			String bn = input.nextLine();
			System.out.println("Phone Number: ");
			String bp = input.nextLine();
			System.out.println("E-mail: ");
			String be = input.nextLine();
			borrowList.add(new Borrower(bn, bp, be));
			System.out.println("Complete!!");
			whatNext();
			break;
		case 2:
			System.out.println("Borrow Book");
			System.out.println("Title: ");
			String bt = input.nextLine();
			System.out.println("Name: ");
			String bn2 = input.nextLine();
			borrow(searchByTitle(bt), searchName(bn2));
			whatNext();
			break;
		case 3:
			System.out.println("Return Book");
			System.out.println("Title: ");
			String bt2 = input.nextLine();
			System.out.println("Name: ");
			String bn3 = input.nextLine();
			returnBook(searchByTitle(bt2), searchName(bn3));
			whatNext();
			break;
		case 4:
			System.out.println("Study E-Learning");
			System.out.println("Subject: ");
			String sj = input.nextLine();
			study(searchBySubject(sj));
			whatNext();
			break;
		case 5:
			System.out.println("Search Book Title");
			System.out.println("Title: ");
			String bt3 = input.nextLine();
			printBookResult(searchByTitle(bt3));
			whatNext();
			break;
		case 6:
			System.out.println("Search Book Writer");
			System.out.println("Writer: ");
			String wr = input.nextLine();
			printBookResult(searchByWriter(wr));
			whatNext();
			break;
		case 7:
			System.out.println("Search E-LEarning Subject");
			System.out.println("Subject: ");
			String sj2 = input.nextLine();
			printELResult(searchBySubject(sj2));
			whatNext();
			break;
		case 8:
			System.out.println("Search E-LEarning Teacher");
			System.out.println("Teacher: ");
			String te = input.nextLine();
			printELResult(searchByTeacher(te));
			whatNext();
			break;
		case 9:
			System.out.println("See All Book");
			getAllBook();
			whatNext();
			break;
		case 10:
			System.out.println("See All E-Learning");
			getAllELearning();
			whatNext();
			break;
		case 11:
			System.out.println("Login Admin Mode");
			System.out.println("Please enter the Password: ");
			String id = input.nextLine();

			for (Admin admin : adminList) {
				if (id.equals(admin.getId())) {
					admin();
				} else {
					System.out.println("Wrong Password!!");
					whatNext();
				}
			}
		case 12:
			break;
		}
	}

	public void admin() {
		System.out.println("\nHello Admin!!");
		System.out.println("[0] = Add Book");
		System.out.println("[1] = Add E-Learning");
		System.out.println("[2] = See All User");
		System.out.println("[3] = See All Admin");
		System.out.println("[4] = Home Page");
		System.out.println("[5] = Exit");

		System.out.println("Please input number to continue: ");
		int select = input.nextInt();
		input.nextLine();

		switch (select) {
		case 0:
			System.out.println("Add Book");
			System.out.println("Title: ");
			String title = input.nextLine();
			System.out.println("Writer: ");
			String writer = input.nextLine();
			System.out.println("Publisher: ");
			String publisher = input.nextLine();
			System.out.println("Price: ");
			double price = input.nextDouble();
			System.out.println("Number In Stock: ");
			int num = input.nextInt();
			bookshelf.add(new Book(title, writer, publisher, price, num));
			whatNext();
			break;
		case 1:
			System.out.println("Add E-Learning");
			System.out.println("Subject: ");
			String sj = input.nextLine();
			System.out.println("Teacher: ");
			String te = input.nextLine();
			System.out.println("Chapter ");
			int ch = input.nextInt();
			System.out.println("Total Hours: ");
			double hr = input.nextDouble();
			eLearningBS.add(new eLearning(sj, te, ch, hr));
			whatNext();
			break;
		case 2:
			System.out.println("See All User");
			getAllBorrower();
			whatNext();
			break;
		case 3:
			System.out.println("See All Admin");
			getAllAdmin();
			whatNext();
			break;
		case 4:
			user();
		case 5:
			break;
		}
	}

	public void whatNext() {
		System.out.println("\nWhat do you want to do next?");
		System.out.println("[0] = Home Page");
		System.out.println("[1] = Exit");
		System.out.println("Please input number to continue: ");
		int select = input.nextInt();
		input.nextLine();
		switch (select) {
		case 0:
			user();
			break;
		case 1:
			break;
		}
	}

	public void readFile() {
		String[] bookdata;
		String[] eldata;
		String[] brdata;

		BufferedReader reader = null;

		// BookShelf
		try {
			File file = new File("bookshelf.txt");
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			String line = null;

			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.isEmpty())
					continue;
				bookdata = line.split(",");
				Book book = new Book(bookdata[0], bookdata[1], bookdata[2], Double.parseDouble(bookdata[3]),
						Integer.parseInt(bookdata[4]));
				bookshelf.add(book);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// E-Learning
		try {
			File file = new File("elearning.txt");
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			String line = null;

			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.isEmpty())
					continue;
				eldata = line.split(",");
				eLearning el = new eLearning(eldata[0], eldata[1], Integer.parseInt(eldata[2]),Double.parseDouble(eldata[3]));
				eLearningBS.add(el);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Borrower
		try {
			File file = new File("borrowerlist.txt");
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			String line = null;

			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.isEmpty())
					continue;
				brdata = line.split(",");
				Borrower br = new Borrower(brdata[0], brdata[1], brdata[2]);
				borrowList.add(br);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void writeFile() {
		BufferedWriter writer = null;
		//Borrower
		try {
			File file = new File("borrowerlist.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (Borrower borrower : borrowList) {
				writer.write(borrower.getName()+","+borrower.getPhoneNum()+","+borrower.getEmail());
				writer.newLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//BookShelf
		try {
			File file = new File("bookshelf.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (Book book : bookshelf) {
				writer.write(book.getTitle()+","+book.getWriter()+","+book.getPublisher()+","+book.getPrice()+","+book.getCurrentNum());
				writer.newLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//E-Learning
		try {
			File file = new File("elearning.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (eLearning el : eLearningBS) {
				writer.write(el.getSubject()+","+el.getTeacher()+","+el.getChapter()+","+el.getTimeTotal());
				writer.newLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Library hogward = new Library("Hogwarts Library", "069-919-191", "Hogwarts_Library@gmail.com",
				"Platform 9 and 3/4");
		Admin a1 = new Admin("KunsaiJunG", "11221122");
		hogward.adminList.add(a1);
		
		// Main Controller
		hogward.readFile();
		hogward.user();
		hogward.writeFile();
	}
}
