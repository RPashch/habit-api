package com.lyceum.habitapi.dao;

import com.lyceum.habitapi.models.Category;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("SELECT c.id, c.title, c.description, c.is_default, c.created_at FROM CATEGORY c " +
            "INNER JOIN (SELECT category_id, COUNT(*) as count FROM HABIT GROUP BY category_id ORDER BY count DESC LIMIT 10) top " +
            "ON c.id=top.category_id;")
    List<Category> findTop();

}
