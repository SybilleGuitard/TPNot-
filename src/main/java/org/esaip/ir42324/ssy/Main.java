package org.esaip.ir42324.ssy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            // Création de l'EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("petstore");

            // Création de l'EntityManager
            em = emf.createEntityManager();

            // Début de la transaction
            em.getTransaction().begin();

            // Création d'un nouveau PetStore
            PetStore petStore = new PetStore();
            petStore.setName("PetStore Example");
            petStore.setManagerName("John Doe");

            // Persistez le PetStore dans la base de données
            em.persist(petStore);

            // Commit de la transaction
            em.getTransaction().commit();

            // Récupération de tous les PetStores depuis la base de données
            List<PetStore> petStores = em.createQuery("SELECT p FROM PetStore p", PetStore.class).getResultList();

            // Affichage des PetStores récupérés
            for (PetStore ps : petStores) {
                System.out.println("PetStore Name: " + ps.getName());
                System.out.println("Manager Name: " + ps.getManagerName());
            }

        } catch (Exception e) {
            // En cas d'erreur, rollback de la transaction
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Fermeture de l'EntityManager et de l'EntityManagerFactory
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
