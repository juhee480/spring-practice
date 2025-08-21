package hello.core.Order;

public interface OrderService {
    Order creatOrder(Long memberId, String itemName, int itemPrice);
}
