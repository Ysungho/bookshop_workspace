package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
// @controller를 선언하여 자바 클래스 WelcomeController가 컨트롤러임을 나타냄
public class WelcomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET) 
	//@RequestMapping 은 클라이언트 요청 url이 /home 이면 WelcomeController 컨트롤러의 welcome()메서드에 매핑됨. 
    public String welcome(Model model) { 
        model.addAttribute("greeting", "Welcome to BookMarket"); 
        model.addAttribute("strapline", "Welcome to Web Shopping Mall!");  
        //addAttribute()메서드는 Model 타입 객체의 멤버 메서드로 이를 이용하여 뷰에 전달할 정보를 담음. 
        return "welcome";  
        // 클라이언트 요처이 url에 대해 처리된 결과를 사용자에게 보여주는 뷰임. 
        // 따라서 웹 브라우저에 출력되는 웹 페이지는 welcome.jsp가 된다. 
    } 
	// welcome()메서드는 클라이언트의 요청 url 처리를 직접 담당하는 요청 처리 메서드임
}
