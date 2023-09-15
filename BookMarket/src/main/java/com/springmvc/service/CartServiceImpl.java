package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.domain.Cart;
import com.springmvc.repository.CartRepository;
import com.springmvc.exception.CartException;
@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    public Cart create(Cart cart) {  
        return cartRepository.create(cart);
    }  
    //↑ create() 메서드는 장바구니 저장소 객체에서 생성한 장바구니를 가져와 반환합니다. 

    public Cart read(String cartId) {  
        return cartRepository.read(cartId);
    }  
    //↑ read() 메서드는 저장소 객체에서 장바구니 ID에 대해 장바구니에 등록된 모든 정보를 가져와 반환합니다. 
    
    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }
    
    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }
    
    public Cart validateCart(String cartId) {  
        Cart cart = cartRepository.read(cartId);
        if(cart==null || cart.getCartItems().size()==0) {
            throw new CartException(cartId);
        } 
        return cart;
    } 
    //↑ validateCart() 메서드는 장바구니 ID에 대한 장바구니 저장소 객체에서 장바구니 정보를 가져와 반영합니다. 
    //↑ 장바구니 저장소 객체에 장바구니 ID가 없으면 예외 처리로 CartException() 메서드를 호출함. 
}