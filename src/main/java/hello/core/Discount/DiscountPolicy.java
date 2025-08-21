package hello.core.Discount;

import hello.core.Member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
