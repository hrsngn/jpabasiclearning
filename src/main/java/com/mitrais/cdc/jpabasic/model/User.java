package com.mitrais.cdc.jpabasic.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name="user")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name")
    private String name;

    //one to many bidirectional
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    @JoinColumn(name="user_id")
    private Set<Comment> comments;

    //one to one unidirectional
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    //one to one bidirectional
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    private Money money;

    //bidirectional
    @ManyToMany
    @JoinTable(
            name="user_role",
            joinColumns = { @JoinColumn(name= "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(
            name = "user_bank",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "bank_id") } )
    private Set<Bank> banks;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Image image;

    @ElementCollection
    @CollectionTable(name="alias",joinColumns = @JoinColumn(name = "user_id"))
    private Set<Alias> alias;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
//        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Comment> getComments() {
        return comments;
    }
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    public Money getMoney() {
        return money;
    }
    public void setMoney(Money money) {
        this.money = money;
    }
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    public void setBanks(Set<Bank> banks) {
        this.banks = banks;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Alias> getAlias() {
        return alias;
    }

    public void setAlias(Set<Alias> alias) {
        this.alias = alias;
    }
}
