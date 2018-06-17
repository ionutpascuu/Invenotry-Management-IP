package ip.springbootmongodb.service;

import ip.springbootmongodb.model.ProductNew;
import ip.springbootmongodb.repository.ProductNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductNewServiceImpl implements ProductNewService {

    @Autowired
    private ProductNewRepository productRepository;

    @Override
    public List<ProductNew> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductNew findByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    @Override
    public List<ProductNew> findProductsByCategory(String categoryName) {
        return productRepository.findProductsByCategory(categoryName);
    }

    @Override
    public List<ProductNew> findProductsByName(String searchString) {
        return productRepository.findProductsByProductNameRegex(searchString);
    }

    @Override
    public List<ProductNew> getReport(String startDate, String endDate) {
        return productRepository.getReport(startDate, endDate);
    }
}

