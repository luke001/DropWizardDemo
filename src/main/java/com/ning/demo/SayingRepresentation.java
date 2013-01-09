package com.ning.demo;

/**
 * Created with IntelliJ IDEA.
 * User: xianlinbox
 * Date: 1/3/13
 * Time: 3:48 PM
 */
public class SayingRepresentation {
    private long id;
    private String content;

    public SayingRepresentation(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
