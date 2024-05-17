package org.esaip.ir42324.ssy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PETSTORE")
public class PetStore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MANAGER_NAME")
    private String managerName;

    @OneToMany(mappedBy = "petStore")
    private List<Animal> animals = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "ADRESS_ID", referencedColumnName = "ID")
    private Adress adress;

    @ManyToMany(mappedBy = "petStores")
    private List<Product> products = new ArrayList<>();

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Adress getAddress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
