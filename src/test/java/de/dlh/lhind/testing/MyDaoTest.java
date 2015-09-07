package de.dlh.lhind.testing;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import org.junit.Rule;
import org.junit.Test;
import org.needle4j.annotation.ObjectUnderTest;
import org.needle4j.junit.DatabaseRule;
import org.needle4j.junit.NeedleRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDaoTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Rule
    public NeedleRule needleRule = new NeedleRule(databaseRule);

    @ObjectUnderTest
    private MyDao myDao;

    @Test
    public void returnsEmptyListIfNoEntitiesExist() {
        List<MyEntity> result = myDao.findAll();

        assertThat(result).isEmpty();
    }

    @Test
    public void returnsAllEntities() throws Exception {
        MyEntity schinken = databaseRule.getTransactionHelper().saveObject(newEntity(1L, "Schinken"));
        MyEntity wurst = databaseRule.getTransactionHelper().saveObject(newEntity(2L, "Wurst"));

        List<MyEntity> result = myDao.findAll();

        assertThat(result).usingElementComparator(Ordering.natural().onResultOf(new Function<MyEntity, Comparable>() {
            public Comparable apply(MyEntity input) {
                return input.getId();
            }
        })).containsOnly(schinken, wurst);
    }

    private MyEntity newEntity(Long id, String name) {
        MyEntity myEntity = new MyEntity();
        myEntity.setId(id);
        myEntity.setName(name);
        return myEntity;
    }
}