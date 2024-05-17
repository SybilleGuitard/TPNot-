package org.esaip.ir42324.ssy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "FISH")
public class Fish extends Animal implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "LIVING_ENV")
    private FishLivEnv livingEnv;

    public Fish() {
        super();
    }

    public Fish(FishLivEnv livingEnv, Date birth, String couleur) {
        super(birth, couleur);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + getId() +
                ", birth=" + getBirth() +
                ", couleur='" + getCouleur() + '\'' +
                ", livingEnv=" + livingEnv +
                '}';
    }
}
