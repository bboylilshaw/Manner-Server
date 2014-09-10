package com.hp.manner.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class EmailAuditor implements AuditorAware<String> {

    private static final Logger logger = LoggerFactory.getLogger(EmailAuditor.class);

    @Override
    public String getCurrentAuditor() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        //String email = "yao.xiao@hp.com";
        logger.debug("Current Auditor is " + email);
        return email;
    }
}
