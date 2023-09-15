package com.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice 
//�� ���� ���� ó���� ���� @ControllerAdvice�� ����
public class CommonException {  
	//�� ��� ��Ʈ�ѷ��� ���� ó�� Ŭ����
    @ExceptionHandler(RuntimeException.class)  
    //�� ���� Ŭ���� RuntimeException�� ����
    private ModelAndView handleErrorCommon(Exception e) {  
    	//�� ��Ʈ�ѷ����� �߻��Ǵ� ���� ó�� �޼��� handleErrorCommon() �޼���
        ModelAndView modelAndView = new ModelAndView();  
        //�� ModelAndView Ŭ������ modelAndView  �ν��Ͻ� ����
        modelAndView.addObject("exception", e );  
        //�� �� �Ӽ� exception���� ���� ó�� Ŭ���� RuntimeException�� ����
        modelAndView.setViewName("errorCommon");  
        //�� �� �̸����� errorCommon�� �����Ͽ� errorCommon.jsp  ������ ���
        return modelAndView; 
        //�� ModelAndView Ŭ������ modelAndView �ν��Ͻ��� ��ȯ
    }  
} 
