package com.hp.manner.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Jason on 12/7/14.
 */
@Service
public class MailServiceImpl implements MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private SpringTemplateEngine templateEngine;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmailWithTemplate(String to, String templateName, Map<String, Object> modelMap)
            throws MessagingException, UnsupportedEncodingException {

        Context context = new Context();
        if (modelMap != null) {
            context.setVariables(modelMap);
        }

        logger.info("resolve template: mails/" + templateName);
        String htmlContent = templateEngine.process("mails/" + templateName, context);

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setSubject("Manner - Notification");
        message.setFrom("admin@manner.com");
        message.setTo(to);
        message.setText(htmlContent, true);

        mailSender.send(mimeMessage);
        logger.info("done sending email");

    }
}
