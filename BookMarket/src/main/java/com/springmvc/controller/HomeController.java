package com.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
// 컨트롤러: @Controller는 자바 클래스 HomeController가 컨트롤러임을 알려줍니다.
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// 요청 매핑: @RequestMapping은 설정된 파라미터와 같은 요청이 있을 때 home() 메서드를 수행시키는 역할을 합니다. 
	// 웹 클라이언트에서 들어온 요청에 해당하는 비즈니스 로직을 찾아 줍니다. 
	// value 파라밑는 요청 url이고, method 파라미터는 get이나 post 방식을 설정하며 기본 값은 get 방식으로 생략할 수 있습니다.
	
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		// 뷰로 값 전달: 비지니스 로직을 수행한 결과를 뷰에 보냅니다. 
		// model.addAttribute()는 serverTime 이라는 이름으로 formattedDate를 전송하는 것을 의미합니다. 
		
		return "home";
		// 수행 결과를 어디로 전송할지 설정하는 곳 입니다. 
		// home 은 home.jsp 파일을 의미합니다. 
	}
	//요청 처리 메서드: home()은 요청 처리 메서드 입니다. 
	
}
