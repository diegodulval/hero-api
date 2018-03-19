/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulval.demo.heroapp.ui;

import com.dulval.demo.heroapp.domain.Hero;
import com.dulval.demo.heroapp.services.Services;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Collection;
import java.util.Collections;
import org.springframework.hateoas.Resources;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.VerticalCrudLayout;

/**
 *
 * @author diego
 */
@SpringUI(path = "/")
public class VaadinUI extends UI {

    private GridCrud<Hero> crud = new GridCrud<>(Hero.class, new VerticalCrudLayout());

    @Override
    protected void init(VaadinRequest request) {
        getReconnectDialogConfiguration().setDialogText("Please wait...");
        getReconnectDialogConfiguration().setReconnectInterval(1000);

        Label title = new Label("Heroes");
        title.addStyleName(ValoTheme.LABEL_H2);

        crud.getGrid().setColumns("name", "name");
        crud.getCrudFormFactory().setVisibleProperties("name", "name");
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.setClickRowToUpdate(true);
        crud.setUpdateOperationVisible(false);
        crud.setFindAllOperation(this::findAll);
        crud.setAddOperation(hero -> Services.getHeroService().add(hero));
        crud.setUpdateOperation(hero -> Services.getHeroService().update(hero.getId(), hero));
        crud.setDeleteOperation(hero -> Services.getHeroService().delete(hero.getId()));

        VerticalLayout mainLayout = new VerticalLayout(title, crud);
        mainLayout.setHeightUndefined();
        mainLayout.setMargin(false);
        setContent(mainLayout);
    }

    private Collection<Hero> findAll() {
        Resources<Hero> resources = Services.getHeroService().findAll();

        Collection<Hero> heroes = Collections.emptyList();

        if (resources != null) {
            heroes = resources.getContent();
            if (!heroes.isEmpty()) {
                crud.getGrid().setHeightByRows(heroes.size());
            }
        } else {
            Notification.show("An error occurred. Please try again later.", Notification.Type.ERROR_MESSAGE);
        }

        return heroes;
    }
}
