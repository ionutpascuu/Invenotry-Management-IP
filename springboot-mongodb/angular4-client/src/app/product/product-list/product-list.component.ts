import { Component, OnInit, Input } from '@angular/core';
import { Product } from "../product";
import { ProductService } from "../product.service";
import { Router } from '@angular/router';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
  providers: [ProductService]
})
export class ProductListComponent implements OnInit {
  private products: Product[];
  constructor(private router: Router,
              private productService: ProductService) { }
  ngOnInit() {
    this.getAllProducts();
  }
  getAllProducts() {
    this.productService.findAll().then(
      products => {
        this.products = products;
      },
      err => {
        console.log(err);
      }
    );
  }
  createProduct() {
    //TODO schimbi cu ce ai tu
    let productCode = (<HTMLInputElement>document.getElementById('productCode')).value;
    let productName = (<HTMLInputElement>document.getElementById('productName')).value;
    let price = (<HTMLInputElement>document.getElementById('price')).value;
    let product = new Product(0, productCode, productName,Number(price));
    this.productService.createProduct(product).then(
      products => {
        this.products = products;
      },
      err => {
        console.log(err);
      }
    );
  }
  deleteProduct(product: Product) {
    this.productService.deleteProductById(product.id).then(
      products => {
        this.products = products;
      },
      err => {
        console.log(err);
      }
    );
  }
}
