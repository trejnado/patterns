package ski.patterns.composedmethod;

import java.time.LocalDate;
import java.util.List;

class Order {

    final long id;
    final List<String> lineItems;
    final LocalDate orderDate;
    LocalDate completedDate;

    public Order(long id, List<String> lineItems, LocalDate orderDate) {

        this.id = id;
        this.lineItems = lineItems;
        this.orderDate = orderDate;
    }

    public void setCompletionDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }

    public String customerEmail() {
        return "customer1@somedomain.com";
    }
}
