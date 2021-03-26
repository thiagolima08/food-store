package br.edu.ifpb.padroes.service.mail;

import br.edu.ifpb.padroes.domain.Customer;

public interface NotificationListener {
    void sendMailNotification(String message);
    void sendMailNotification(String message, Customer customer);
}
