package com.helsong.appframeworkexample.model;

/**
 * Created by weiruyou on 2015/5/7.
 */
public class Contributor {
    private String login;
    private String id;
    private String avatar_url;
    private int contributions;

    public Contributor(String login, String id, String avatar_url, int contributions) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.contributions = contributions;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }
}
