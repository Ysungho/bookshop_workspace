package com.springmvc.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import javax.validation.Constraint;

@Constraint(validatedBy = BookIdValidator.class) 
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented  
//↑ 위에 모든 애너테이션에 관한 설명
//↑ 사용자 정의 애너테이션 @BookId는 Method, Field, Annotation_type을 정의하며 이는 런타임할 때 적용됨
//↑ 도메인 클레스에 @BookId가 부여된 멤버 변수는 BookIdValidator 클래스로 유효성 검사를 수행함. 
public @interface BookId {
	//↑ @BookId는 필수 속성(message, groups, payload)을 포함함. 
	//↑ @BookId에 대한 유효성 검사를 할 때 오류가 발생하면 메시지 리소스파일 message.properties에 설정된 BookId.NewBook.bookId의 메시지를 출력함. 
	String message() default "{BookId.NewBook.bookId}";  
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};  
}