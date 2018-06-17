package ip.springbootmongodb.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
/*
 * Repository Layer is responsible for retrievel of data
 */
@Repository
public interface CategoryRepository {

    public List<String> findAll();
}
