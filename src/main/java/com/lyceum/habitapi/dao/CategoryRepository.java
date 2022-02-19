package com.lyceum.habitapi.dao;

import com.lyceum.habitapi.dto.CategoryDto;
import com.lyceum.habitapi.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
