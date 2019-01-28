package book.mvc.controller;

import java.util.ArrayList;

import book.mvc.model.vo.Book;
import book.mvc.service.BookService;
import book.mvc.view.BookMenu;

public class BookController {

	private BookService bservice = new BookService();
			
	public BookController() {}

	public void insertBook(Book b) {
		int result = bservice.insertBook(b);
		if(result > 0)
			System.out.println("도서 추가 성공");
		else 
			System.out.println("도서 추가 실패 다시 하세요.");
	}
	public void updateBook(Book b) {
		int result = bservice.updateBook(b);
		
		if(result > 0)
			System.out.println("수정 성공 ");
		else 
			System.out.println("수정 실패 다시 시도하세요.");
	}
	public void deleteBook(int bookId) {
		int result = bservice.deletBook(bookId);
		
		if(result > 0)
			System.out.println("도서 삭제 성공");
		else 
			System.out.println("도서 삭제 실패 다시 하세요.");		
	}
	public Book searchBook(int bookId) {
		Book b = bservice.selectBook(bookId);
		
		if(b == null){
			System.out.println("해당 도서 정보 없음");
			new BookMenu().displayMenu();
		}
		
		return b;	
	}
	public ArrayList<Book> searchBookTitle(String bookTitle) {
		ArrayList<Book> list = bservice.searchBookTitle(bookTitle);
		
		if(list.size()==0) {
			System.out.println("해당 도서 정보 없음.");
			new BookMenu().displayMenu();
		}
		
		return list;
	}
		
	public ArrayList<Book> selectAll() { 
		ArrayList<Book> list = bservice.selectAllBooks();
		
		return list;
	}
}
