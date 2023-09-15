package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.domain.Book;
import com.springmvc.domain.Order;
import com.springmvc.repository.BookRepository;
import com.springmvc.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    public void confirmOrder(String bookId, long quantity) {  
        Book bookById = bookRepository.getBookById(bookId);
        if(bookById.getUnitsInStock() < quantity){
            throw new IllegalArgumentException("품절입니다. 사용가능한 제고수 :"+ bookById.getUnitsInStock());
        }
        bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
    }  
    //↑ confirmOrder() 메서드는 도서 재고 수에 대한 도서 주문 가능 여부를 처리함
    //↑ 주문 도서 수가 재소 수보다 많으면 IllegalArgumentException 예외를 발생시킴. 

    public Long saveOrder(Order order) { 
        Long orderId = orderRepository.saveOrder(order);
        cartService.delete(order.getCart().getCartId());
        return orderId;
    } 
    //↑ saveOrder() 메서드는 주문 내역에 Order 저장소 객체에 저장하고, 현재 장바구니 정보를 삭제한 후 주문 내역 id를 반환함. 
}