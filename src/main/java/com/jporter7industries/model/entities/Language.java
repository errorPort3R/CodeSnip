package com.jporter7industries.model.entities;

import javax.persistence.*;

/**
 * Created by jeffryporter on 8/29/16.
 */
@Entity
@Table(name = "languages")
public class Language
{
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String language;

    public Language()
    {
    }

    public Language(String language)
    {
        this.language = language;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }
}
