package book.mvc.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import book.mvc.controller.BookController;
import book.mvc.model.vo.*;
public class BookMenu {

	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	public BookMenu() {}
	
	public void displayMenu() {
		int no;

		do {
			System.out.println("---------------------------");
			System.out.println("\n**** 도서 관리 프로그램 ****");
			System.out.println();
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 아이디로 조회");
			System.out.println("5. 도서 제목으로 조회");
			System.out.println("6. 도서 목록 전체 조회");
			System.out.println("9. 끝내기");
			System.out.println("번호 선택 : ");
			no = sc.nextInt();

			switch (no) {
			case 1: bc.insertBook(inputBook());
					break;
			case 2: bc.updateBook(inputBookUpdate());
					break;
			case 3: bc.deleteBook(inputBookId());
					break;
			case 4: this.displayBook(bc.searchBook(inputBookId()));
					break;
			case 5: this.displayBooks(bc.searchBookTitle(inputBookTitle()));
					break;
			case 6: this.displayBooks(bc.selectAll());
					break;
			case 9:
				System.out.println("\n종료(y), 취소(n) : ");
				if (sc.next().toUpperCase().charAt(0) == 'Y')
					return; // main() 으로 돌아감
				else
					break; // 메뉴 다시 반복
			default:
				System.out.println("없는 번호 입니다.");
				System.out.println("다시 입력하세요 .\n");
			}
		} while (true);
	}
	
	public Book inputBook() {
		Book b = new Book();
		System.out.println("도서명 입력 : ");
		b.setTitle(sc.next());
		System.out.println("작가명 입력 : ");
		b.setAuthor(sc.next());
		System.out.println("출판사 입력 : ");
		b.setPublisher(sc.next());
		System.out.println("출판일 입력[yyyy-MM-dd] : ");
		b.setPublisherDate(Date.valueOf(sc.next()));
		System.out.println("가격 입력 : ");
		b.setPrice(sc.nextInt());
		
		return b;
	}
	
	
	public Book inputBookUpdate() {
		Book b = new Book();
		System.out.println("변경할 도서번호 입력 : ");
		b.setBookId(sc.nextInt());
		System.out.println("변경할 도서명 : ");
		b.setTitle(sc.next());
		
		return b;
	}
	public int inputBookId() {
		System.out.println("검색/삭제할 도서 아이디 입력 : ");
		return sc.nextInt();
	}
	public String inputBookTitle() {
		System.out.println("검색할 도서 제목 입력 : ");
		return sc.next();
	}
	public void displayBooks(List<Book> list) {
		for(Book b:list) {
			System.out.println(b);
		}
	}
	public void displayBook(Book b) {
		System.out.println(b);
	}
	public void displayError(String message) {
		
	}
}
