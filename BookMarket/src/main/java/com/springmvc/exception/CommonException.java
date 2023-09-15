package com.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice 
//↑ 전역 예외 처리를 위한 @ControllerAdvice를 선언
public class CommonException {  
	//↑ 모든 컨트롤러의 예외 처리 클래스
    @ExceptionHandler(RuntimeException.class)  
    //↑ 예외 클래스 RuntimeException을 설정
    private ModelAndView handleErrorCommon(Exception e) {  
    	//↑ 컨트롤러에서 발생되는 예외 처리 메서드 handleErrorCommon() 메서드
        ModelAndView modelAndView = new ModelAndView();  
        //↑ ModelAndView 클래스의 modelAndView  인스턴스 생성
        modelAndView.addObject("exception", e );  
        //↑ 모델 속성 exception에서 예외 처리 클래서 RuntimeException을 저장
        modelAndView.setViewName("errorCommon");  
        //↑ 뷰 이름으로 errorCommon을 설정하여 errorCommon.jsp  파일을 출력
        return modelAndView; 
        //↑ ModelAndView 클래스의 modelAndView 인스턴스를 반환
    }  
} 
