package ip.springbootmongodb.Controller;

import ip.springbootmongodb.Hotel;
import ip.springbootmongodb.HotelRepository;
import ip.springbootmongodb.Product;
import ip.springbootmongodb.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        List<Product> prodcts = this.productRepository.findAll();

        return  prodcts;

    }

    @PutMapping
    public void insert(@RequestBody Product product){
        this.productRepository.insert(product);
    }

    @PostMapping("/{id}") //nu era id inainte
    public void update(@RequestBody Product product) {
        this.productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.productRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") String id){
        Product product = this.productRepository.findById(id);

        return product;
    }

}
