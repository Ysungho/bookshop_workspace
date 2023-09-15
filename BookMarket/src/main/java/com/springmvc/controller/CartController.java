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
    //�� requestCartId() �޼���� �� ��û url�� �˸°� ������ ��û ó�� �޼���� ����� ��û�� ó���մϴ�. 
    //�� ���� id���� ������ url cart/sessionid�� �����̷����մϴ�. 

    @PostMapping  
    public @ResponseBody Cart create(@RequestBody Cart cart ) {
        return cartService.create(cart);
    }  
    //�� create() �޼���� http �޼��尡 post ����̸� ���εǴ� ��û ó�� �޼����, ����� ��û�� ó���մϴ�. 
    //�� cart Ŭ���� ������ http ��û body�� ���޹޾� ��ٱ��ϸ� ���� �����ϰ� http ���� body�� �����մϴ�. 

    @GetMapping( "/{cartId}") 
    public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model) {
        Cart cart = cartService.read(cartId);
        model.addAttribute("cart",cart);
        return "cart";
    } 
    //�� requestCartList()�޼���� http �޼��尡 get ����̸� ���εǴ� ��ûó�� �޼����, ����� ��û�� ó���մϴ�. 
    //�� ��û url���� ��� ���� cartid�� ���� ��ٱ��Ͽ� ��ϵ� ��� ������ �о�� Ŀ�ǵ� ��ü cart �Ӽ��� ����մϴ�. 
    //�� �� �̸��� cart�� ��ȯ�ϹǷ� jsp ������ cart.jsp�� �˴ϴ�. 

    @PutMapping("/{cartId}") 
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    } 
    //�� read() �޼���� http �޼��尡 put ����̸� ���εǴ� ��û ó�� �޼���� ����� ��û�� ó���մϴ�. 
    //�� read() �޼���� ��û url���� ��� ������ ��ٱ��� ID(cartId)�� ���� ��ٱ��Ͽ� ��ϵ� ��� ������ �����ɴϴ�. 
    
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
    //�� addCartByNewItem() �޼���� http �޼��尡 put ����Դϴ�. 
    //�� url��ΰ� /cart/add/{bookid}/ �̸� ��� ������ bookid�� ���� �ش� ������ ��ٱ��Ͽ� �߰��� ����ϰ� ��ٱ��ϸ� �����մϴ�. 
    
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
    //�� removeByItem() �޼���� http �޼��尡 put ����Դϴ�.
    //�� ��û url�� /cart/remove/{bookid}/�� �� ��� ���� bookid�� ���� �ش� ������ ��ٱ��Ͽ��� �����ϰ� ��ٱ��ϸ� �����մϴ�. 
    
    @DeleteMapping("/{cartId}")  
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCartList(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }  
    //�� deleteCartList() �޼���� http �޼��尡 delete ����� �� ��û ó�� �޼���� ����� ��û�� ó���մϴ�. 
}