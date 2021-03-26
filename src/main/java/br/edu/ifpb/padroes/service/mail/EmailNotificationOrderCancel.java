package br.edu.ifpb.padroes.service.mail;

import br.edu.ifpb.padroes.domain.Customer;

public class EmailNotificationOrderCancel implements NotificationListener{

    private String emailAdministration = "contact@food-store.com";

    @Override
    public void sendMailNotification(String message, Customer customer) {
        System.out.println("send mail notification to "+ customer.getEmail());
    }

    @Override
    public void sendMailNotification(String message) {
        System.out.println("send mail notification to ="+emailAdministration);
    }

}
