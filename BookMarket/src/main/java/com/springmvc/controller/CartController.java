package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Cart;
import com.springmvc.service.CartService;
import com.springmvc.domain.Book;
import com.springmvc.service.BookService;
import com.springmvc.exception.BookIdException;
import com.springmvc.domain.CartItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private BookService bookService;

    @GetMapping  
    public String requestCartId(HttpServletRequest request) {
        String sessionid = request.getSession(true).getId();
        return "redirect:/cart/"+ sessionid;
    }  
    //↑ requestCartId() 메서드는 웹 요청 url이 알맞게 들어오면 요청 처리 메서드로 사용자 요청을 처리합니다. 
    //↑ 세션 id값을 가져와 url cart/sessionid로 리다이렉션합니다. 

    @PostMapping  
    public @ResponseBody Cart create(@RequestBody Cart cart ) {
        return cartService.create(cart);
    }  
    //↑ create() 메서드는 http 메서드가 post 방식이면 매핑되는 요청 처리 메서드로, 사용자 요청을 처리합니다. 
    //↑ cart 클래스 정보를 http 요청 body로 전달받아 장바구니를 새로 생성하고 http 응답 body로 전달합니다. 

    @GetMapping( "/{cartId}") 
    public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model) {
        Cart cart = cartService.read(cartId);
        model.addAttribute("cart",cart);
        return "cart";
    } 
    //↑ requestCartList()메서드는 http 메서드가 get 방식이면 매핑되는 요청처리 메서드로, 사용자 요청을 처리합니다. 
    //↑ 요청 url에서 경로 변수 cartid에 대해 장바구니에 등록된 모든 정보를 읽어와 커맨드 객체 cart 속성에 등록합니다. 
    //↑ 뷰 이름을 cart로 반환하므로 jsp 파일은 cart.jsp가 됩니다. 

    @PutMapping("/{cartId}") 
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    } 
    //↑ read() 메서드는 http 메서드가 put 방식이면 매핑되는 요청 처리 메서드로 사용자 요청을 처리합니다. 
    //↑ read() 메서드는 요청 url에서 경로 변수인 장바구니 ID(cartId)에 대해 장바구니에 등록된 모든 정보를 가져옵니다. 
    
    @PutMapping("/add/{bookId}")  
    @ResponseStatus(value = HttpStatus.NO_CONTENT)  
    public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();  
        Cart cart = cartService.read(sessionId);  
        if(cart== null)
        	cart = cartService.create(new Cart(sessionId));
        Book book = bookService.getBookById(bookId);  
        if(book == null)
        	throw new IllegalArgumentException(new BookIdException(bookId));
        cart.addCartItem(new CartItem(book));  
        cartService.update(sessionId, cart);  
    } 
    //↑ addCartByNewItem() 메서드는 http 메서드가 put 방식입니다. 
    //↑ url경로가 /cart/add/{bookid}/ 이면 경로 변수에 bookid에 대해 해당 도서를 장바구니에 추가로 등록하고 장바구니를 갱신합니다. 
    
    @PutMapping("/remove/{bookId}")  
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartByItem(@PathVariable String bookId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();  
        Cart cart = cartService.read(sessionId);  
        if(cart== null)
            cart = cartService.create(new Cart(sessionId));
            Book book = bookService.getBookById(bookId);  
        if(book == null)
            throw new IllegalArgumentException(new BookIdException(bookId));
        cart.removeCartItem(new CartItem(book));  
        cartService.update(sessionId, cart);  
    }  
    //↑ removeByItem() 메서드는 http 메서드가 put 방식입니다.
    //↑ 요청 url이 /cart/remove/{bookid}/일 때 경로 변수 bookid에 대해 해당 도서를 장바구니에서 삭제하고 장바구니를 갱신합니다. 
    
    @DeleteMapping("/{cartId}")  
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCartList(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }  
    //↑ deleteCartList() 메서드는 http 메서드가 delete 방식일 때 요청 처리 메서드로 사용자 요청을 처리합니다. 
}