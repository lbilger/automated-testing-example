package de.dlh.lhind.testing;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Test entity.
 */
@Entity
public class MyEntity {
    @Id
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
