package ip.springbootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection= "ProductsNew")
public class ProductNew {

    @Id
    private String id;
    private String categories;
    private String productCode;
    private String productName;
    //private String imageUrl;
    //private double price;
    private int size;
    //private String color;

    public ProductNew() {}

    public ProductNew(String categories, String productCode, String productName, String imageUrl, double price, int size, String color)
    {
        this.categories = categories;
        this.productCode = productCode;
        this.productName = productName;
        //this.imageUrl = imageUrl;
        //this.price = price;
        this.size = size;
        //this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    //public String getImageUrl() {
    //    return imageUrl;
    //}

    //public void setImageUrl(String imageUrl) {
    //    this.imageUrl = imageUrl;
    //}

   /* public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }*/

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //public String getColor() {
    //    return color;
    //}

   // public void setColor(String color) {
    //    this.color = color;
    //}
}
