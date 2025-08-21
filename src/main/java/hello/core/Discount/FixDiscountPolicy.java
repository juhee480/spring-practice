package hello.core.Discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
