package com.springmvc.service;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	 @Autowired
	 private BookRepository bookRepository;
	 
	 public List<Book> getAllBookList() { 
	        // TODO Auto-generated method stub
		 return bookRepository.getAllBookList();
		 // ↑도서 목록 가져오기: 저장된 도서 목록 정보를 가져오는 getAllBook() 메서드를 작성함. 
	 } 
	 
	 
	 public List<Book> getBookListByCategory(String category) {
		 //↑ getBookListByCategory() 메서드는 웹 요청 url에 포함된 경로 변수의 값을 저장소 객체에 전달한 후 실행하여 결과를 반환.
		 //↑ getBookListByCategory() 메서드는 웹 요청 url로 전송된 경로 변수의 값과 도서목록의 도서분야를 비교하여 일치하는 도서 정보를 저장한 후 반환. 
		 //↑ 도서 분야와 일치하는 도서 목록을 저장소 객체에서 가져오는 getBookBCategory()메서드
	      List<Book> booksByCategory = bookRepository.getBookListByCategory(category);  
	      //↑ 저장소 객체에서 매개변수 category와 일치하는 도서 목록을 가져와 booksByCategory에 저장
	      return booksByCategory;  
	      //↑ 도서 목록이 저장된 bookByCategory를 반환
	 }  
	 
	 public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		 //↑ getBookListByFilter() 메서드는 도서 출판사 및 도서 분야를 포함한 웹 정보 url에 대해 도서를 검색하여 도서 목록을 반환함. 
		 //↑ getBookListByFilter() 메서드는 웹 요청 url에서 메트릭스 변수에 해당되는 publisher 및 category와 일치하는 도서를 검색하여 해당 도서 목록을 반환함. 
	      Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter); 
	      return booksByFilter;
	 }
	 
	 public Book getBookById(String bookId) {
	        Book bookById = bookRepository.getBookById(bookId);
	        return bookById;
	 }
	 
	 public void setNewBook(Book book) {  
		 //↑ 신규 도서 정보를 저장소 객체에 저장하는 메서드
	        bookRepository.setNewBook(book);  
	        //↑ 저장소 객체의 setNewBook() 메서드를 호출
	 }  
	 public void setUpdateBook(Book book) {  
	        bookRepository.setUpdateBook(book);
	 } 
	 
	  public void setDeleteBook(String bookID) { 
	        bookRepository.setDeleteBook(bookID);
	    }
	  //↑ setDeleteBook() 메서드는 요청 도서 id에 대한 해당 도서를 데이터베이스에서 삭제함. 
}
