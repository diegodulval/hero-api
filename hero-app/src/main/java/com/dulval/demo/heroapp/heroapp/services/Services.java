/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulval.demo.heroapp.heroapp.services;

import com.vaadin.spring.server.SpringVaadinServlet;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author diego
 */
@Service
public class Services {

    public static HeroService getHeroService() {
        return getApplicationContext().getBean(HeroService.class);
    }

    public static ApplicationContext getApplicationContext() {
        ServletContext servletContext = SpringVaadinServlet.getCurrent().getServletContext();
        return WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }

}
