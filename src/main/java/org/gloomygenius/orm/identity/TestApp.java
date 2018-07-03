package org.gloomygenius.orm.identity;

import org.gloomygenius.orm.Application;

import javax.persistence.EntityManager;

public class TestApp extends Application {
    public static void main(String[] args) {
        new TestApp().startProgramm(args);
    }

    @Override
    protected void executeCode() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Account entity = new Account();
        entity.setId(1L);
        entityManager.persist(entity);
        entityManager.persist(new Bank());
        entityManager.persist(new CreditCard());
        entityManager.persist(new Investor());
        entityManager.persist(new Beneficiary());
        entityManager.persist(new Debtor());
        entityManager.getTransaction().commit();
    }
}