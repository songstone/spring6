package songs.spring6;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import songs.spring6.order.Order;
import songs.spring6.order.OrderService;
import songs.spring6.order.OrderServiceImpl;

import java.math.BigDecimal;

public class OrderClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
        OrderService service = beanFactory.getBean(OrderServiceImpl.class);

        Order order = service.createOrder("0100", BigDecimal.TEN);
        System.out.println(order);
    }
}
