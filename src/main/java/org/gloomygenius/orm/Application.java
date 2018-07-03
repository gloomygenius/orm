package org.gloomygenius.orm;

import org.gloomygenius.orm.util.JpaUtil;

import javax.persistence.EntityManagerFactory;

public class Application {
    protected EntityManagerFactory entityManagerFactory;

    public void startProgramm(String[] args) {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
        try {
            executeCode();
        } finally {
            JpaUtil.shutdown();
        }
    }

    protected void executeCode() {

    }
}