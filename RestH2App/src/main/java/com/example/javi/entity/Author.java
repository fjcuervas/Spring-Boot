package com.example.javi.entity;

import java.util.List;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
 
@Entity
@Table(name = "AUTHORS")
public class Author {
     
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
     
    @Column(name = "NAME", nullable = false)
    private String name;
     
    @Column(name = "GIVEN_NAME")
    private String givenName;
     
    @Column(name = "MOTHER_NAME")
    private String motherName;
     
    @OneToMany(mappedBy = "author")
    private List<Book> bookList;
 
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
     * @return the name
     */
    public String getName() {
        return name;
    }
 
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
 
    /**
     * @return the givenName
     */
    public String getGivenName() {
        return givenName;
    }
 
    /**
     * @param givenName the givenName to set
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
 
    /**
     * @return the motherName
     */
    public String getMotherName() {
        return motherName;
    }
 
    /**
     * @param motherName the motherName to set
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
 
    /**
     * @return the bookList
     */
    public List<Book> getBookList() {
        return bookList;
    }
 
    /**
     * @param bookList the bookList to set
     */
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
     
 
}