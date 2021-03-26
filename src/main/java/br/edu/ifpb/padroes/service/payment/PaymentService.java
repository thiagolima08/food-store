package br.edu.ifpb.padroes.service.payment;

public class PaymentService {

    public StrategyPayment strategyPayment;

    public enum PaymentType {
        CREDIT_CARD, DEBIT, BILLET, PAYPAL
    }

    public PaymentType doPayment(PaymentType paymentType) {
        return strategyPayment.doPayment(paymentType);
    }
//
//    public void doPayment(PaymentType type) throws Exception {
//        switch (type) {
//            case CREDIT_CARD:
//                System.out.println("Do credit card payment!");
//                break;
//            case DEBIT:
//                System.out.println("Do debit payment!");
//                break;
//            case BILLET:
//                System.out.println("Do billet payment!");
//                break;
//            case PAYPAL:
//                System.out.println("Do paypal payment!");
//                break;
//            default:
//                throw new Exception("unknown payment method");
//        }
}

