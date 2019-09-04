package com.example.javi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
 
@Entity
@Table(name = "BOOKS")
public class Book {
     
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
     
    @Column(name = "ISBN", nullable = false, unique=true)  
    private String isbn;
     
    @Column(name = "TITLE", nullable = false)
    private String title;
     
    @ManyToOne
    @JoinColumn(name = "AUTHOR") 
    private Author author;
 
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
 
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
 
    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }
 
    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
 
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
 
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
 
    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }
 
    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }
     
     
     
     
 
}