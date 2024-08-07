package org.eduardo.SenderEmail.services;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.eduardo.SenderEmail.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendEmailWithAttachment(Email email, File pdfFile) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setSubject(email.getSubject());
        helper.setText(email.getText());

        Path path = pdfFile.toPath();
        byte[] pdfBytes = Files.readAllBytes(path);
        InputStreamSource pdfSource = new ByteArrayResource(pdfBytes);
        helper.addAttachment("curriculo.pdf", pdfSource);

        for (String e: email.getTo()){
            helper.setTo(e);
            javaMailSender.send(message);
        }

    }

}
