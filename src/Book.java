import java.util.Objects;
import java.util.ArrayList;

public class Book {
	private String title;
	private String writer;
	private String publisher;
	private double price;
	private int numInStock;
	private int currentNum;

	public Book(String title, String writer, String publisher, double price, int numInStock) {
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.numInStock = numInStock;
		currentNum = numInStock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumInStock() {
		return numInStock;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	public int getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}

	public String toString() {
		return "\n[Book Information] \n\nTitle: " + title + "\nWriter: " + writer + "\nPublisher: " + publisher
				+ "\nPrice: " + price + "\nCurrent Book Number: " + currentNum;
	}

	public boolean reduceBook() {
		if (currentNum <= 0) {
			System.out.println("\nThere is no book now, Sorry.");
			return false;
		} else {
			currentNum--;
			return true;
		}
	}

	public boolean increaseBook() {
		if(currentNum >= numInStock) {
			System.out.println("\nBook is already full.");
			return false;
		}
		else {
			currentNum++;
			return true;
		}
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Book book = (Book) o;
		return Double.compare(book.getPrice(), getPrice()) == 0 && getNumInStock() == book.getNumInStock()
				&& currentNum == book.currentNum && Objects.equals(getTitle(), book.getTitle())
				&& Objects.equals(getWriter(), book.getWriter()) && Objects.equals(getPublisher(), book.getPublisher());
	}
}
