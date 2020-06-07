package com.app.postgre.service.impl;

import com.app.postgre.entity.AbstractEntity;
import com.app.postgre.repository.CommonRepository;
import com.app.postgre.service.DataService;

public abstract class AbstractDataServiceImpl<E extends AbstractEntity, R extends CommonRepository<E>>
    implements DataService<E> {

  protected final R repository;

  public AbstractDataServiceImpl(R repository) {
    this.repository = repository;
  }

  @Override
  public E save(E entity) {
    return repository.save(entity);
  }

  //другие методы, переопределённые из интерфейса
}
