package com.springmvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.springmvc.exception.BookIdException;
import com.springmvc.service.BookService;
import com.springmvc.domain.Book;

public class BookIdValidator implements ConstraintValidator<BookId, String>{

    @Autowired
    private BookService bookService;

    public void initialize(BookId constraintAnnotation) {  // @BookId 정보 초기화 메서드  
    	//↑ initialize() 메서드는 사용자 정의 애너테이션 @BookId의 관련 정보르 ㄹ읽어 초기화 작업을 수행함. 
    }  
    public boolean isValid(String value, ConstraintValidatorContext context) {  // 유효성 검사 메서드  
        Book book;
        try {
            book = bookService.getBookById(value);
        } catch (BookIdException e) {
            return true;
        }
        if(book!= null) {
            return false;
        }
        return true;
    } 
    //↑ isValid() 메서드는 도메인 클래스 Book의 bookid 속성 값을 읽어 유효성 검사를 수행함
    //↑ 여기에 bookService.getBookById() 메서드로 입력된 도서 ID가 이미 있다면 BookIdException 예외를 발생시킴. 
}