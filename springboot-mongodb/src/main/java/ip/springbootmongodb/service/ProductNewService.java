package ip.springbootmongodb.service;

import ip.springbootmongodb.model.ProductNew;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Service Layer should be used for Transactional processes
 *
 * Calls Repository Layers
 *
 */
@Service
public interface ProductNewService {

    public List<ProductNew> findAll();
    public ProductNew findByProductCode(String productCode);
    public List<ProductNew> findProductsByCategory(String categoryName);
    public List<ProductNew> findProductsByName(String searchString);
    public List<ProductNew> getReport(String startDate, String endDate);

}