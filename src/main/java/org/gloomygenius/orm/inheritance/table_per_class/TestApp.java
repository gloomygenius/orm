package org.gloomygenius.orm.inheritance.table_per_class;

import org.gloomygenius.orm.Application;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TestApp extends Application {
    public static void main(String[] args) {
        new TestApp().startProgramm(args);
    }

    @Override
    protected void executeCode() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Truck truck = new Truck();
        truck.setManufacturer(County.RUSSIA);
        truck.setNumberOfAxes(4);

        Bulldozer bulldozer = new Bulldozer();
        bulldozer.setManufacturer(County.JAPAN);
        bulldozer.setLiftingBlade(300);
        em.getTransaction().begin();
        em.persist(truck);
        em.persist(bulldozer);
        em.getTransaction().commit();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Car> query = criteriaBuilder.createQuery(Car.class);
        Root<Car> carRoot = query.from(Car.class);
        query.select(carRoot);
        TypedQuery<Car> allQuery = em.createQuery(query);
        List<Car> resultList = allQuery.getResultList();
        //выполняется SELECT ... FROM (SELECT ... UNION ALL SELECT ...)
        System.out.println("Result size: " + resultList.size());
        resultList.forEach(s -> System.out.println(s.getManufacturer()));
    }
}
