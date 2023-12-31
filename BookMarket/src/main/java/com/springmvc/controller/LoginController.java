package com.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {

    @GetMapping("/login")  
    //↑ 시큐리티 설정 파일에 login-page="/login"으로 요청할 때 매핑함. 
    public String login() {  
    	//↑ 웹 요처이 url이 /login일 때 요청 처리 메서드 
        return "login";  
        //↑ 뷰 이름 login으로 반환하여 login.jsp 파일을 출력함
    }  

    @GetMapping("/loginfailed")  
    //↑ 시큐리티 설정 파일에 authentication-failure-url="/loginfailed"로 요청할 때 매핑함
    public String loginerror(Model model) {  
    	//↑ 웹 요청 url이 /loginfailed일 때 요청 처리 메서드
        model.addAttribute("error", "true");  
        //↑ 모델 속성 error에 true 값을 저장함
        return "login"; 
        //↑ 뷰 이름 login으로 반환하여 login.jsp 파일을 출력함. 
    } 
    
    @GetMapping("/logout")
    public String logout(Model model) {  
    	//↑ 웹 요청이 /logout일 때 요청 처리 메서드
        return "login";  
        //↑ 뷰 이름 login으로 반환하여 login.jsp 파일을 출력
    } 
}