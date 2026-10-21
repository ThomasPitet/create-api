package com.formation.apirestdemo.service;

import org.springframework.stereotype.Service;

@Service("emailNotification")
public class EmailNotificationService implements NotificationService {

    @Override
    public void notifier(String destinataire, String message) {
        // Envoi reel d'un e-mail (non implemente dans ce cours)
        System.out.println("[EMAIL] " + destinataire + " : " + message);
    }
}
