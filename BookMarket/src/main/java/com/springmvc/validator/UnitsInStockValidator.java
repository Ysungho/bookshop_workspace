package com.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import com.springmvc.domain.Book;

@Component
public class UnitsInStockValidator implements Validator{
    public boolean supports(Class<?> clazz) {  // Book 클래스의 유효성 검사 여부를 위한 메서드 
    	//↑ Validator 인터페이스의 supports() 메서드는 주어진 Book 클래스에 대한 유효성 검사 여부를 결정함. 
        return Book.class.isAssignableFrom(clazz);
    }  

    public void validate(Object target, Errors errors) {  // Book 클래스의 유효성 검사 메서드
        Book book = (Book) target;
        if(book.getUnitPrice()>=10000 && book.getUnitsInStock()>99) {
            errors.rejectValue("unitsInStock", "UnitsInStockValidator.message");  // 오류 객체의 속성과 메시지 저장
        }
    } 
    //↑ Validator 인터페이스의 validate() 메서드는 주어진 Book 클래스에 대해 유효성 검사를 시도함.
    //↑ 도서 가격이 1만원 이상이고, 재고가 99권을 초과하면 유효성 검사를 할 때 오류가 발생함
    //↑ 그러면 Errors 객체의 rejectValue() 매서드가 메시지 리소스 파일에 설정된 오류 코드 UnitInStockValidator.message의 메시지를 출력함. 
}