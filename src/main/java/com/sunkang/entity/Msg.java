package com.sunkang.entity;

/**
 * Created by changxiang on 2017-03-16.
 */
public class Msg {

    private String title;

    private String content;

    private String etrainfo;

    public Msg(String title, String content, String etrainfo) {
        this.title = title;
        this.content = content;
        this.etrainfo = etrainfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtrainfo() {
        return etrainfo;
    }

    public void setEtrainfo(String etrainfo) {
        this.etrainfo = etrainfo;
    }
}
