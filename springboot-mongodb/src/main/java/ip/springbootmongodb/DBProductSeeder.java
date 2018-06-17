package ip.springbootmongodb;

import ip.springbootmongodb.model.ProductNew;
import ip.springbootmongodb.repository.ProductNewRepository;
import org.springframework.boot.CommandLineRunner;

public class DBProductSeeder implements CommandLineRunner {
    private ProductNewRepository productNewRepository;
    private ProductRepository productRepository;

    public DBProductSeeder(ProductNewRepository productNewRepository) {
        this.productNewRepository = productNewRepository;
    }

    @Override
    public void run(String... strings) throws Exception {


        ProductNew product = new ProductNew(
                "2",
                "code01",
                "mere",
                "url.ds",
                2.6,
                2,
                "green"
        );

        //drop all products
        this.productRepository.deleteAll();

        //add out hotels to the database
        //List<Hotel> hotels = Arrays.asList(marriot,ibis,sofitel);
        this.productNewRepository.save(product);

    }
}
