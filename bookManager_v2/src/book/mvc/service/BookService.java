package book.mvc.service;

import java.sql.*;
import java.util.ArrayList;

import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import static common.JDBCTemplate.*;
public class BookService {

	private BookDao bdao = new BookDao();
	
	public BookService() {}
	
	public int insertBook(Book b) {
		Connection conn = getConnection();
		int result = bdao.insertBook(conn, b);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int deletBook(int bookId) {
		Connection conn = getConnection();
		int result = bdao.deletBook(conn, bookId);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateBook(Book b) {
		Connection conn = getConnection();
		int result = bdao.updateBook(conn, b);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public Book selectBook(int bookId) {
		Connection conn = getConnection();
		Book b = bdao.selectBook(conn, bookId);
		close(conn);
		return b;
	}
	
	public ArrayList<Book> selectAllBooks() {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectAllBooks(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Book> searchBookTitle(String bookTitle) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.searchBookTitle(conn, bookTitle);
		close(conn);
		return list;
	}
}
