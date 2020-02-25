package com.food.guide.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Blogger /*implements Serializable*/ {
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;
    private String mail;
    private String password;

    public Blogger() {}

    public Blogger(String nickname, String mail, String password){
        this.nickname = nickname;
        this.mail = mail;
        this.password = password;
    }

    //CascadeType.All ... the persistence will propagate (cascade) all EntityManager
    //                    operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the
    //                    relating entities
    //orphanRemoval=true ... marks "child" entity to be removed when it's no longer
    //                       referenced from the "parent" entity, e.g. when you
    //                       remove the child entity from the corresponding
    //                       collection of the parent entity.
    @JsonIgnore
    @OneToMany(mappedBy = "blogger", cascade=CascadeType.ALL, fetch=FetchType.LAZY,
            orphanRemoval=true)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
