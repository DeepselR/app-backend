package com.app.postgre.generator;

import java.io.Serializable;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class KeyGenerator implements IdentifierGenerator {

  public static final String generatorName = "keyGenerator";

  @Override
  public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object)
      throws HibernateException {
    return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    // or any other logic you'd like for generating unique IDs
  }

}
