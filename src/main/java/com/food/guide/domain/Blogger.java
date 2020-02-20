package com.food.guide.domain;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Blogger {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String nickname;
    private String mail;
    private String password;

    @OneToMany(mappedBy = "blogger", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SELECT)
    private Set<Entry> entries = new HashSet<>();

    public void addEntry(Entry entry){
        if(entry.getBlogger() != null)
            entry.getBlogger().entries.remove(entry);
        this.entries.add(entry);
        entry.setBlogger(this);
    }

    public void removeEntry(Entry entry){
        this.entries.remove(entry);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }
}
