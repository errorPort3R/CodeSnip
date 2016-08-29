package com.jporter7industries.model.entities;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by jeffryporter on 8/29/16.
 */
@Entity
@Table(name = "snippets")
public class CodeSnippet
{
    @Id
    @GeneratedValue
    private int id;

    private String writer;

    @ManyToOne
    private Language language;

    @Column(nullable = false)
    private ArrayList<String> tags;

    @Transient
    private boolean matchKeywordExact = false;

    @Column(nullable = false)
    private String snippet;

    private String comments;

    public CodeSnippet()
    {
    }

    public CodeSnippet(Language language, ArrayList<String> tags, boolean matchKeywordExact, String snippet)
    {
        this.language = language;
        this.tags = tags;
        this.matchKeywordExact = matchKeywordExact;
        this.snippet = snippet;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getWriter()
    {
        return writer;
    }

    public void setWriter(String writer)
    {
        this.writer = writer;
    }

    public Language getLanguage()
    {
        return language;
    }

    public void setLanguage(Language language)
    {
        this.language = language;
    }

    public ArrayList<String> getTags()
    {
        return tags;
    }

    public void setTags(ArrayList<String> tags)
    {
        this.tags = tags;
    }

    public boolean isMatchKeywordExact()
    {
        return matchKeywordExact;
    }

    public void setMatchKeywordExact(boolean matchKeywordExact)
    {
        this.matchKeywordExact = matchKeywordExact;
    }

    public String getSnippet()
    {
        return snippet;
    }

    public void setSnippet(String snippet)
    {
        this.snippet = snippet;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }
}
