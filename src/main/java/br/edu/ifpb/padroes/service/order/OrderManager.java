package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.log.LogHandler;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.mail.EmailNotificationOrderCancel;
import br.edu.ifpb.padroes.service.mail.EmailNotificationOrderRefused;
import br.edu.ifpb.padroes.service.payment.PaymentService;
import br.edu.ifpb.padroes.service.mail.EmailNotificationOrderSucess;

public class OrderManager {

    public OrderManager(Order order) {
        this.order = order;
    }

    private Order order;

    private EmailNotificationOrderSucess emailNotificationOrderSucess = new EmailNotificationOrderSucess();
    private EmailNotificationOrderCancel emailNotificationOrderCancel = new EmailNotificationOrderCancel();
    private EmailNotificationOrderRefused emailNotificationOrderRefused = new EmailNotificationOrderRefused();

    private PaymentService paymentService = new PaymentService();

    private LogService logService = new LogService(new LogHandler(LogHandler.LogHandlerType.FILE));

    public void payOrder(PaymentService.PaymentType paymentType) {
        order.setStatus(Order.OrderStatus.IN_PROGRESS);
        try {
            paymentService.doPayment(paymentType);
            order.setStatus(Order.OrderStatus.PAYMENT_SUCCESS);
            emailNotificationOrderSucess.sendMailNotification(String.format("Order %d completed successfully", order.getId()));
            logService.info("payment finished");
        } catch (Exception e) {
            logService.error("payment refused");
            order.setStatus(Order.OrderStatus.PAYMENT_REFUSED);
            emailNotificationOrderRefused.sendMailNotification(String.format("Order %d refused", order.getId()));
        }
    }

    public void cancelOrder() {
        order.setStatus(Order.OrderStatus.CANCELED);
        emailNotificationOrderCancel.sendMailNotification(String.format("Order %d canceled", order.getId()));
        logService.debug(String.format("order %d canceled", order.getId()));
    }

}
