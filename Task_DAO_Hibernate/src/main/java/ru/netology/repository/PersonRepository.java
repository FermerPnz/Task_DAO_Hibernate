package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.netology.model.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.cityOfLiving = :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    public List<Person> getPersonsByAgeGreaterThanOrderByAgeDesc(int age) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.age > :age ORDER BY p.age DESC", Person.class);
        query.setParameter("age", age);
        return query.getResultList();
    }
}