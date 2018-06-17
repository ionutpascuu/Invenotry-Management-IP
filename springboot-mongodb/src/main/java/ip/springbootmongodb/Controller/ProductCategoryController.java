package ip.springbootmongodb.Controller;

import ip.springbootmongodb.model.ProductNew;
import ip.springbootmongodb.repository.ProductNewRepository;
import ip.springbootmongodb.service.CategoryService;
import ip.springbootmongodb.service.ProductNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/productCategories")
public class ProductCategoryController {

    // services
    @Autowired
    private ProductNewService productNewService;

    @Autowired
    private ProductNewRepository productRepository; // just for the momeent (DELETE)

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ProductNewRepository productNewRepository;



    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public void insert(@RequestBody ProductNew product){

        ProductNew productNew = new ProductNew();
        productNew.setCategories(product.getCategories());
        productNew.setProductCode(product.getProductCode());
        productNew.setProductName(product.getProductName());
        productNew.setSize(product.getSize());

        this.productNewRepository.insert(productNew);
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<String> getCategories() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    List<ProductNew> getProducts() {
        return productNewService.findAll();
    }

    @RequestMapping(value = "/getProductByProductCode/{productCode}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody ProductNew getProductByProductCode(@PathVariable String productCode) {
        return productNewService.findByProductCode(productCode);
    }

    @RequestMapping(value = "/getProductReport", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody List<ProductNew> getProductReport
            (@RequestParam String startDate, @RequestParam String endDate) {
        return productNewService.getReport(startDate, endDate);
    }

    @RequestMapping(value = "/getProductByProductName/{productName}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody List<ProductNew> getProductByProductName(@PathVariable String productName) {
        return productNewService.findProductsByName(productName);
    }

    @RequestMapping(value = "/getProductsByCategories/{categoryName}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody List<ProductNew> getProductById(@PathVariable String categoryName) {
        return productNewService.findProductsByCategory(categoryName);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable("id") String id) {
        this.productRepository.delete(id);
    }

}
