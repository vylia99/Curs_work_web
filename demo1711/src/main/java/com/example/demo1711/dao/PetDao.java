package com.example.demo1711.dao;

import com.example.demo1711.data.Pet;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class PetDao {
    @PersistenceContext
    EntityManager em;

    public Pet find(int id){
        return em.find(Pet.class, id);
    }
    public List<Pet> findAll(){
        return em.createNamedQuery("Pet.findAll", Pet.class).getResultList();
    }
    public Pet findByName(String kind) {
        return em.createNamedQuery("Pet.findByNameIgnoreCase", Pet.class)
                .setParameter("kind", kind)
                .getSingleResult();
    }

    public void add(Pet pet) {
        em.persist(pet);
    }
}
