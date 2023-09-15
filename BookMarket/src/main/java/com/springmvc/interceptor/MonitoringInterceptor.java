package com.springmvc.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitoringInterceptor implements HandlerInterceptor {

    ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();

    public Logger logger = LoggerFactory.getLogger(this.getClass());  
    //↑Logger 객체를 가져옴

    public boolean preHandle(HttpServletRequest request,  
                             HttpServletResponse response,
                             Object handler) throws Exception {
    	//↑ HandlerInterceptor 인터페이스 메서드, 컨트롤러를 호출하기 전에 실행됨. 
        StopWatch stopWatch = new StopWatch(handler.toString());
        stopWatch.start(handler.toString());
        stopWatchLocal.set(stopWatch);
        logger.info("접근한 URL 경로 : " + getURLPath(request)); 
        //↑ 로그 메시지를 출력
        logger.info("요청 처리 시작 시각 : " + getCurrentTime());  
        //↑ 로그 메시지를 출력
        return true;
    } 
    
    public void postHandle(HttpServletRequest arg0,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception { 
    	//↑ HandlerInterceptor 인터페이스 메서드이며, 컨트롤러를 호출하여 처리한 후에 실행됨
        logger.info("요청 처리 종료 시각 : " + getCurrentTime()); 
        //↑ 로그 메시지를 출력
    }  
    
    public void afterCompletion(HttpServletRequest request,
                               HttpServletResponse response,
                               Object handler, 
                               Exception exception) throws Exception {  
    	//↑ HandlerInterceptor 인터페이스 메서드이며, 뷰에 최종 결과를 반환한 후에 실행됨
        StopWatch stopWatch = stopWatchLocal.get();
        stopWatch.stop();
        logger.info("요청 처리 소요 시간 : " + stopWatch.getTotalTimeMillis()+ " ms");  
        //↑ 로그 메시지를 출력
        stopWatchLocal.set(null);
         logger.info("==========================================");
         //↑ 로그 메시지를 출력
    }  
    
    private String getURLPath(HttpServletRequest request) {  
    	//↑ 요청 url과 쿼리문을 얻어오는 메서드
        String currentPath = request.getRequestURI();
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : "?" + queryString;
        return currentPath+queryString;
    } 
    
    private String getCurrentTime() {  
    	//↑ 현재 날짜를 얻어오는 메서드
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }  
}