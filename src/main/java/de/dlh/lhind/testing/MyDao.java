package de.dlh.lhind.testing;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * DAO for test entity {@link MyEntity}.
 */
public class MyDao {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Return a list of all MyEntity entities.
     *
     * @return list of MyEntity
     */
    public List<MyEntity> findAll() {
        return entityManager.createQuery("from MyEntity", MyEntity.class).getResultList();
    }
}
