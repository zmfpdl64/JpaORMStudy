package jpa.study.domain.persistance.eleven.service;

import jpa.study.domain.persistance.eleven.domain.*;
import static jpa.study.domain.persistance.eleven.domain.Order.OrderStatus;
import jpa.study.domain.persistance.eleven.repository.OrderRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static jpa.study.domain.persistance.eleven.domain.Order.createOrder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DisplayName("주문 서비스 테스트")
@Transactional
@SpringBootTest
class OrderServiceTest {

    @PersistenceContext
    EntityManager em;
    private OrderService sut;
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceTest(OrderService sut, OrderRepository orderRepository) {
        this.sut = sut;
        this.orderRepository = orderRepository;
    }

    @Test
    void order() throws Exception{
        ///given
        Member member = createMember();
        Item item = createBook("시골 JPA", 10_000, 10); // 제목, 가격, 수량
        int orderCount = 2;

        //when
        Long orderId = sut.order(
                member.getId(),
                item.getId(),
                orderCount
                );
        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getStatus()); //"상품 주문시 상태는 ORDER",
        assertEquals( 1, getOrder.getOrderItems().size());//"주문한 상품 종류 수가 정확해야 한다.",
        assertEquals(10_000 * 2, getOrder.getTotalPrice()); // 주문 가격은 가격 * 수량이다.
        assertEquals(8, item.getStockQuantity()); // 주문 수량 만큼 재고수량이 줄어야 한다.
    }

    @DisplayName("상품주문_재고수량초과")
    @Test
    public void 상품주문_재고수량초과() {
        //given
        Member member = createMember();
        Item item = createBook("JPA JPA", 10_000, 10);

        //when

        //then
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> {
                    item.removeStock(11);
                })
                .withMessage("수량이 부족합니다.");

    }

    @DisplayName("주문취소")
    @Test
    void 주문취소했을때() {

        //given
        Member member = createMember();
        Item item = createBook("시골쥐 JPA", 10_000, 10);
        Long orderId = sut.order(member.getId(), item.getId(), 5);
        Order order = orderRepository.findOne(orderId);

        //when
        sut.cancleOrder(orderId);

        //then
        assertThat(order.getStatus()).isEqualTo(OrderStatus.CANCEL); //취소 상태로 변경
        assertThat(10).isEqualTo(item.getStockQuantity()); // 주문 재고수량 주문하기 전으로 되돌리기


    }

    @Test
    void findOrders() {
    }



    private Member createMember(){
        Member member = new Member();
        member.setName("kim");
        member.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(member);
        return member;
    }
    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        book.setPrice(price);
        em.persist(book);
        return book;
    }


}