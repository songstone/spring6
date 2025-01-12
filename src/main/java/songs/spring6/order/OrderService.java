package songs.spring6.order;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import songs.spring6.data.OrderRepository;

import java.math.BigDecimal;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final JpaTransactionManager transactionManager;

    public OrderService(OrderRepository orderRepository, JpaTransactionManager transactionManager) {
        this.orderRepository = orderRepository;
        this.transactionManager = transactionManager;
    }

    public Order createOrder(String id, BigDecimal total) {
        Order order = new Order(id, total);

        return new TransactionTemplate(transactionManager).execute(status -> {
            orderRepository.save(order);
            return order;
        });
    }
}
