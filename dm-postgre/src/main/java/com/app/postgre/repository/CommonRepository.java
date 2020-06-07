package com.app.postgre.repository;

import com.app.postgre.entity.AbstractEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends AbstractEntity> extends CrudRepository<E, Long> {

  @Override
  Optional<E> findById(Long aLong);

  @Override
  <S extends E> S save(S entity);
}
