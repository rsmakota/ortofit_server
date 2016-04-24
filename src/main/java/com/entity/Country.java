package com.entity;

import javax.persistence.*;

@Entity(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(length = 4, nullable = false)
    private String prefix;
    @Column(nullable = false)
    private String pattern;
    @Column(length = 2)
    private String iso2;
    @Column()
    private int length;
}
