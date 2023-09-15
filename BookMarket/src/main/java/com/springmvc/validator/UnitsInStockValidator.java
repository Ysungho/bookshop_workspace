package com.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import com.springmvc.domain.Book;

@Component
public class UnitsInStockValidator implements Validator{
    public boolean supports(Class<?> clazz) {  // Book Ŭ������ ��ȿ�� �˻� ���θ� ���� �޼��� 
    	//�� Validator �������̽��� supports() �޼���� �־��� Book Ŭ������ ���� ��ȿ�� �˻� ���θ� ������. 
        return Book.class.isAssignableFrom(clazz);
    }  

    public void validate(Object target, Errors errors) {  // Book Ŭ������ ��ȿ�� �˻� �޼���
        Book book = (Book) target;
        if(book.getUnitPrice()>=10000 && book.getUnitsInStock()>99) {
            errors.rejectValue("unitsInStock", "UnitsInStockValidator.message");  // ���� ��ü�� �Ӽ��� �޽��� ����
        }
    } 
    //�� Validator �������̽��� validate() �޼���� �־��� Book Ŭ������ ���� ��ȿ�� �˻縦 �õ���.
    //�� ���� ������ 1���� �̻��̰�, ��� 99���� �ʰ��ϸ� ��ȿ�� �˻縦 �� �� ������ �߻���
    //�� �׷��� Errors ��ü�� rejectValue() �ż��尡 �޽��� ���ҽ� ���Ͽ� ������ ���� �ڵ� UnitInStockValidator.message�� �޽����� �����. 
}