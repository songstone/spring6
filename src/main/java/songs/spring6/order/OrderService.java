package songs.spring6.order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    Order createOrder(String id, BigDecimal total);

    List<Order> createOrders(List<OrderReq> reqs);
}
