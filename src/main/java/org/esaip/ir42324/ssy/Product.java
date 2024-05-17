package org.esaip.ir42324.ssy;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "LABEL")
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private ProdType type;

    @Column(name = "PRICE")
    private double price;

    @ManyToMany
    @JoinTable(
            name = "PRODUCT_PETSTORE",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "petstore_id")
    )
    private List<PetStore> petStores = new ArrayList<>();

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(List<PetStore> petStores) {
        this.petStores = petStores;
    }
}
