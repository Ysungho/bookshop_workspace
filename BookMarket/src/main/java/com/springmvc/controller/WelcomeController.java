package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
// @controller�� �����Ͽ� �ڹ� Ŭ���� WelcomeController�� ��Ʈ�ѷ����� ��Ÿ��
public class WelcomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET) 
	//@RequestMapping �� Ŭ���̾�Ʈ ��û url�� /home �̸� WelcomeController ��Ʈ�ѷ��� welcome()�޼��忡 ���ε�. 
    public String welcome(Model model) { 
        model.addAttribute("greeting", "Welcome to BookMarket"); 
        model.addAttribute("strapline", "Welcome to Web Shopping Mall!");  
        //addAttribute()�޼���� Model Ÿ�� ��ü�� ��� �޼���� �̸� �̿��Ͽ� �信 ������ ������ ����. 
        return "welcome";  
        // Ŭ���̾�Ʈ ��ó�� url�� ���� ó���� ����� ����ڿ��� �����ִ� ����. 
        // ���� �� �������� ��µǴ� �� �������� welcome.jsp�� �ȴ�. 
    } 
	// welcome()�޼���� Ŭ���̾�Ʈ�� ��û url ó���� ���� ����ϴ� ��û ó�� �޼�����
}
