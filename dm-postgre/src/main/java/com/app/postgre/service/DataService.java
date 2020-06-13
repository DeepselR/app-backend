package com.app.postgre.service;

import com.app.postgre.entity.AbstractEntity;
import java.util.Optional;

public interface DataService<E extends AbstractEntity> {

  E save(E entity);

  void delete(E entity);

  void deleteById(Long id);

  Optional<E> findById(Long id);
  //какое-то количество нужных нам методов

}
