package com.example.demo1711.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Named
@SessionScoped
public class LoginBean implements Serializable {
    @Setter @Getter
    private String username;
    @Getter @Setter
    private String password;


    public String login() {

        if ("medadmin".equals(username) && "qwer123".equals(password)) {
            return "index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Неправильное имя пользователя или пароль"));
            return null;
        }
    }
}

