package org.gloomygenius.orm.inheritance.single_table;

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
        Developer developer = new Developer();
        developer.setFirstName("Вася");
        developer.setLastName("Дудкин");
        developer.setProgrammingLang("Java");

        Analyst analyst = new Analyst();
        analyst.setFirstName("Петя");
        analyst.setLastName("Будкин");
        analyst.setBusinessArea("Страхование");

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(developer);
        em.persist(analyst);
        em.getTransaction().commit();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = query.from(Employee.class);
        query.select(employeeRoot);
        TypedQuery<Employee> allQuery = em.createQuery(query);
        allQuery.getResultList().forEach(s -> System.out.println(s.getFirstName() + ' ' + s.getLastName()));

    }
}
