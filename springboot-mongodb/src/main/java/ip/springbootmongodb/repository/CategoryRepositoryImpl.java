package ip.springbootmongodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    //TODO: Type safety is an issue
    /* Solution Source;
     *
     * DB Query: db.products.distinct('categories')
     *
     * @see http://stackoverflow.com/a/19805105/3128926
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> findAll() {
        return mongoTemplate.getCollection("products").distinct("categories");
    }


}
