package hello.core.Order;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    OrderService orderService = new  OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.creatOrder(memberId, "itemA", 10000);
        Assertions.assertThat(1000).isEqualTo(order.getDiscountPrice());
    }

}
