package ip.springbootmongodb.repository;

import ip.springbootmongodb.model.ProductNew;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Repository Layer is responsible for retrievel of data
 */
@Repository
public interface ProductNewRepository extends MongoRepository<ProductNew, String> {

    @Query("{ 'productCode' : ?0 }")
    ProductNew findByProductCode(String productCode);

    /*
     * Same functionality with the query below
     *
     * db.products.find({ categories: { '$in':['children'] } })
     *
     */
    @Query("{ 'categories' : ?0 }")
    List<ProductNew> findProductsByCategory(String categoryName);

    /*
     * db.products.find( { 'productName': /mens/i } );
     * @Query("{ 'productName': /?0/i }")
     *
     */
    @Query("{ 'productName':{$regex:?0,$options:'i'} }")
    List<ProductNew> findProductsByProductNameRegex(String searchString);

    @Query(value = "{'createdDate':{ $lt: ?0, $gt: ?1}}")
    List<ProductNew> getReport(String startDate, String endDate);


}
