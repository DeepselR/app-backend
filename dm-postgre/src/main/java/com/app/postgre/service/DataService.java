package com.app.postgre.service;

import com.app.postgre.entity.AbstractEntity;

public interface DataService<E extends AbstractEntity> {

  E save(E entity);

  //какое-то количество нужных нам методов

}
