// 저장소 객체 생성
package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;

public interface BookRepository {
	 List<Book> getAllBookList();
	 List<Book> getBookListByCategory(String category);
	 Set<Book> getBookListByFilter(Map<String, List<String>> filter);
	 Book getBookById(String bookId);
	 // ↑ 도서 id와 일치하는 도서를 검색하는 메서드
	 void setNewBook(Book book);
	 void setUpdateBook(Book book);
	 void setDeleteBook(String bookID);
}
