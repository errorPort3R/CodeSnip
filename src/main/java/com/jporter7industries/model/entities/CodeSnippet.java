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

    String writer;

    @Column(nullable = false)
    String language;

    @Column(nullable = false)
    ArrayList<String> tags;

    @Transient
    boolean matchKeywordExact = false;

    @Column(nullable = false)
    String snippet;

    String comments;
}
