package org.gloomygenius.orm.inheritance.join_table;

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
        Officer officer = new Officer();
        officer.setArmyType(ArmyType.GROUND_FORCES);
        officer.setLengthOfService(1);

        Soldier soldier = new Soldier();
        soldier.setArmyType(ArmyType.NAVAL_FORCES);
        soldier.setRank("Сержант");

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(officer);
        em.persist(soldier);
        em.getTransaction().commit();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Military> query = criteriaBuilder.createQuery(Military.class);
        Root<Military> militaryRoot = query.from(Military.class);
        query.select(militaryRoot);
        TypedQuery<Military> allQuery = em.createQuery(query);
        allQuery.getResultList().forEach(s -> System.out.println(s.getArmyType()));

    }
}
