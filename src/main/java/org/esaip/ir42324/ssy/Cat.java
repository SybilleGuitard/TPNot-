package org.esaip.ir42324.ssy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CAT")
public class Cat extends Animal implements Serializable {

    @Column(name = "CHIP_ID")
    private String chipId;

    public Cat() {
        super();
    }

    public Cat(String chipId, Date birth, String couleur) {
        super(birth, couleur);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + getId() +
                ", birth=" + getBirth() +
                ", couleur='" + getCouleur() + '\'' +
                ", chipId='" + chipId + '\'' +
                '}';
    }
}
