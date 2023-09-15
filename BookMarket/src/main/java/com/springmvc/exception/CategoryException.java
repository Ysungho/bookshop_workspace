package com.springmvc.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="��û�� ���� �о߸� ã�� �� �����ϴ�.")  
//�� ���ܰ� �߻��ϸ� �� �������� ���� �ڵ� 404�� ���� �޽����� �����.
public class CategoryException extends RuntimeException{

}
