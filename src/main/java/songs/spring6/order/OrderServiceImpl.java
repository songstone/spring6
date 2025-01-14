package songs.spring6.order;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(String id, BigDecimal total) {
        Order order = new Order(id, total);
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> createOrders(List<OrderReq> reqs) {
        return reqs.stream()
            .map(req -> createOrder(req.no(), req.total()))
            .toList();
    }
}