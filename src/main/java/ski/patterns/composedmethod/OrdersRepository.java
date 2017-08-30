package ski.patterns.composedmethod;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

class OrdersRepository {

    private Map<Long, Order> orders = new HashMap<>();

    {
        orders.put(42L, new Order(42, asList("Title 1", "Title 2"), LocalDate.of(2017, 8, 1)));
    }

    public Order getOrder(long orderId) {
        return orders.get(orderId);
    }

    public void update(Order order) {
        System.out.println("Saving order on date: " + order.completedDate);
    }
}
