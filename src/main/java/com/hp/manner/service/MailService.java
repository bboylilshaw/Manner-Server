package com.hp.manner.service;

import java.util.Map;

/**
 * Created by Jason on 12/7/14.
 */
public interface MailService {

    void sendEmailWithTemplate(String to, String templateName, Map<String, Object> modelMap) throws Exception;

}
