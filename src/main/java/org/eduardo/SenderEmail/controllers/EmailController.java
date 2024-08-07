package org.eduardo.SenderEmail.controllers;

import org.eduardo.SenderEmail.models.Email;
import org.eduardo.SenderEmail.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping
public class EmailController {


    @Autowired
    EmailService emailService;

    private final static String To = "eduardoow6@gmail.com";

    @GetMapping("/sendEmail")
    public String senEmail(@RequestBody Email email){
        try {
            File pdfFile = new File("");
            emailService.sendEmailWithAttachment(email, pdfFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Email enviado com sucesso!";
    }

}
