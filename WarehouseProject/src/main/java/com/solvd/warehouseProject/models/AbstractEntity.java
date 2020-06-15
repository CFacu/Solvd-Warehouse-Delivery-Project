package com.solvd.warehouseProject.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractEntity {
	
	protected final static Logger LOGGER = LogManager.getLogger(AbstractEntity.class);

    private Long id;

    public AbstractEntity() {
    }

    public AbstractEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
