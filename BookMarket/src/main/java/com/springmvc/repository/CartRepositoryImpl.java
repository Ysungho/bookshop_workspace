package com.springmvc.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.springmvc.domain.Cart;

@Repository
public class CartRepositoryImpl implements CartRepository{

    private Map<String, Cart> listOfCarts;

    public CartRepositoryImpl() {
        listOfCarts = new HashMap<String,Cart>();
    }

    public Cart create(Cart cart) {  
        if(listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("장바구니를 생성할 수 없습니다. 장바구니 id(%)가 존재합니다", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }  
    //↑ crate() 메서드는 새로운 장바구니를 생성하여 장바구니 ID를 등록하고 생성된 장바구니 객체를 반환합니다
    //↑ 동일한 장바구니 ID가 존재하면 예외처리를 위해 IllegalArgumentException() 메서드를 호출합니다. 

    public Cart read(String cartId) { 
        return listOfCarts.get(cartId);
    } 
    //↑ read() 메서드는 장바구니 ID를 이용하여 장바구니에 등록된 모든 정보를 가져와 반환합니다.
    
    public void update(String cartId, Cart cart) {
        if(!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("장바구니 목록을 갱신할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다",cartId));  // 장바구니 ID가 존재하지 않은 경우 예외 처리
        }
        listOfCarts.put(cartId, cart);
    }
    public void delete(String cartId) {
        if(!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("장바구니 목록을 삭제할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다",cartId));  // 장바구니 ID가 존재하지 않으면 예외 처리
        }
        listOfCarts.remove(cartId);
    }
}