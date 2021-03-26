package br.edu.ifpb.padroes.service.payment;

public interface StrategyPayment {
    PaymentService.PaymentType doPayment(PaymentService.PaymentType paymentType);
}
