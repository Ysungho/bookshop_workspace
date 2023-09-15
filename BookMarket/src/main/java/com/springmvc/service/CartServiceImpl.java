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
    //�� create() �޼���� ��ٱ��� ����� ��ü���� ������ ��ٱ��ϸ� ������ ��ȯ�մϴ�. 

    public Cart read(String cartId) {  
        return cartRepository.read(cartId);
    }  
    //�� read() �޼���� ����� ��ü���� ��ٱ��� ID�� ���� ��ٱ��Ͽ� ��ϵ� ��� ������ ������ ��ȯ�մϴ�. 
    
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
    //�� validateCart() �޼���� ��ٱ��� ID�� ���� ��ٱ��� ����� ��ü���� ��ٱ��� ������ ������ �ݿ��մϴ�. 
    //�� ��ٱ��� ����� ��ü�� ��ٱ��� ID�� ������ ���� ó���� CartException() �޼��带 ȣ����. 
}