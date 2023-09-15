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
// ��Ʈ�ѷ�: @Controller�� �ڹ� Ŭ���� HomeController�� ��Ʈ�ѷ����� �˷��ݴϴ�.
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// ��û ����: @RequestMapping�� ������ �Ķ���Ϳ� ���� ��û�� ���� �� home() �޼��带 �����Ű�� ������ �մϴ�. 
	// �� Ŭ���̾�Ʈ���� ���� ��û�� �ش��ϴ� ����Ͻ� ������ ã�� �ݴϴ�. 
	// value �Ķ�ش� ��û url�̰�, method �Ķ���ʹ� get�̳� post ����� �����ϸ� �⺻ ���� get ������� ������ �� �ֽ��ϴ�.
	
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		// ��� �� ����: �����Ͻ� ������ ������ ����� �信 �����ϴ�. 
		// model.addAttribute()�� serverTime �̶�� �̸����� formattedDate�� �����ϴ� ���� �ǹ��մϴ�. 
		
		return "home";
		// ���� ����� ���� �������� �����ϴ� �� �Դϴ�. 
		// home �� home.jsp ������ �ǹ��մϴ�. 
	}
	//��û ó�� �޼���: home()�� ��û ó�� �޼��� �Դϴ�. 
	
}
