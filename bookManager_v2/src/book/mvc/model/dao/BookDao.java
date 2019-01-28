package book.mvc.model.dao;

import java.sql.*;

import java.util.ArrayList;

import book.mvc.model.vo.Book;
import static common.JDBCTemplate.*;

public class BookDao {

	public BookDao() {}
	
	public int insertBook(Connection conn, Book b) {
		int result=0;
		PreparedStatement pstmt = null;
		
		/*String query = "insert into book values (seq_bid.nextval, '"+b.getTitle()+"', '"+b.getAuthor()+"'"
				+ "								, '"+b.getPublisher()+"', '"+b.getPublisherDate()+"', "+b.getPrice()+")";*/
		String query = "insert into book values (seq_bid.nextval, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPublisher());
			pstmt.setDate(4, b.getPublisherDate());
			pstmt.setInt(5, b.getPrice());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Book> selectAllBooks(Connection conn) {
		ArrayList<Book> list = new ArrayList<Book>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from book";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Book b = new Book();
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublisherDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int deletBook(Connection conn, int bookId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from book where book_id = ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Book selectBook(Connection conn, int bookId) {
		Book b = new Book();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from book where book_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublisherDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}

	public ArrayList<Book> searchBookTitle(Connection conn, String bookTitle) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from book where title like '%'||?||'%'";
		System.out.println(bookTitle);
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookTitle);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book();
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublisherDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int updateBook(Connection conn, Book b) {
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println(b.getTitle());
		//String query = "update book set title = '"+b.getTitle()+"' where book_id = "+b.getBookId();
		String query = "update book set title = ? where book_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setInt(2, b.getBookId());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
}
