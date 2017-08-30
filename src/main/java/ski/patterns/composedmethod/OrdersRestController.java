package ski.patterns.composedmethod;

import java.time.LocalDate;
import java.time.Period;

// Bunch of REST annotations goes here
public class OrdersRestController {

    private final EmailService emailService;
    private final OrdersRepository ordersRepository;

    // using constructor injection
    public OrdersRestController(EmailService emailService, OrdersRepository ordersRepository) {
        this.emailService = emailService;
        this.ordersRepository = ordersRepository;
    }

    // Assume @Post("/order/complete/{orderId}") or whatever you use to expose REST API
    public void completeOrder(long orderId) {
        Order order = ordersRepository.getOrder(orderId);
        LocalDate date = LocalDate.now();
        order.setCompletionDate(date);
        int days = Period.between(order.orderDate, date).getDays();
        ordersRepository.update(order);
        // notify the customer!
        StringBuilder sb = new StringBuilder();
        sb.append("Your order:\n");
        for (int i = 0; i < order.lineItems.size(); ++i) {
            sb.append(String.format("%d. %s%n", i+1, order.lineItems.get(i)));
        }
        sb.append("It took us ").append(days).append(" days to complete the order!");
        sb.append("Warm greetings!\nThe team!");
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.setRecipient(order.customerEmail());
        emailTemplate.setBody(sb.toString());
        emailService.send(emailTemplate);
    }

    // other REST API methods...

    public static void main(String[] args) {
        OrdersRestController exe = new OrdersRestController(new EmailService(), new OrdersRepository());
        exe.completeOrder(42);
    }

}
