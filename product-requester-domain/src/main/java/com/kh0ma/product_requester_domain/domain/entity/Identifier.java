package com.kh0ma.product_requester_domain.domain.entity;

import java.io.Serializable;

/**
 * @param <PK> Generic class for primary key
 * @author Olexander Khomenko
 * <p>
 * The interface that identifies each record in DB.
 */
public interface Identifier<PK extends Serializable> {

    /**
     * Getter for uniqueness field that identifies a record.
     *
     * @return Generic Primary Key
     */
    PK getId();

    /**
     * Setter for uniqueness field that identifies a record.
     *
     * @param pk Primary key to set
     */
    void setId(PK pk);
}
