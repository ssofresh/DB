package book.mvc.model.vo;

import java.sql.Date;

public class Book {

	private int bookId;
	private String title;
	private String author;
	private String publisher;
	private Date publisherDate;
	private int price;
	
	public Book() {}

	public Book(int bookId, String title, String author, String publisher, Date publisherDate, int price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publisherDate = publisherDate;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublisherDate() {
		return publisherDate;
	}

	public void setPublisherDate(Date publisherDate) {
		this.publisherDate = publisherDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.bookId+", "+this.title+", "+this.author+", "+this.publisher+", "+this.publisherDate+", "+this.price;
	}
}
