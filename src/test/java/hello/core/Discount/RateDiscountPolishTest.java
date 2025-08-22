package hello.core.Discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolishTest {

    RateDiscountPolish discountPolish = new RateDiscountPolish();

    @Test
    @DisplayName("VIP는 10퍼 할인이 되어야 함.")
    void vip_o() {
        //given
        Member member = new Member(1l, "Member Vip", Grade.VIP);
        //when
        int discount = discountPolish.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        //given
        Member member2 = new Member(2L, "Member basic", Grade.BASiC);

        //when
        int discount2 = discountPolish.discount(member2, 10000);

        //then
        assertThat(discount2).isEqualTo(0);
    }

}