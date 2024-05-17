package org.esaip.ir42324.ssy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ANIMAL")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BIRTH")
    private Date birth;

    @Column(name = "COLOUR")
    private String colour;

    @ManyToOne
    @JoinColumn(name = "PETSTORE_ID")
    private PetStore petStore;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
