package com.kh0ma.product_requster_service.domain.dao.generic;

import java.io.Serializable;

/**
 * @author Olexander Khomenko
 */
public interface Identifier<PK extends Serializable> {
   PK getId();
   void setId(PK pk);
}
