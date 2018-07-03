package org.gloomygenius.orm.inheritance.mapped_superclass;

import org.gloomygenius.orm.Application;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TestApp extends Application {
    public static void main(String[] args) {
        new TestApp().startProgramm(args);
    }

    @Override
    protected void executeCode() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Bird bird = new Bird();
        bird.setName("Кеша");
        em.persist(bird);
        Dog dog = new Dog();
        dog.setName("Тузик");
        em.persist(dog);
        em.getTransaction().commit();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Dog> query = criteriaBuilder.createQuery(Dog.class);
        Root<Dog> dogRoot = query.from(Dog.class);
        query.select(dogRoot);
        TypedQuery<Dog> allQuery = em.createQuery(query);
        allQuery.getResultList().forEach(s -> System.out.println(s.getName()));
    }
}
