import { Product } from './../models/product';

import { Component, OnInit , Input } from '@angular/core';
import { ProductService } from '../services/product.service';
import {Logger} from 'codelyzer/util/logger';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
  providers: [ProductService]
})
export class ProductListComponent implements OnInit {


  public products: Product[];

  constructor(private router: Router,
              private productService: ProductService) {
  }

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {

    this.productService.getAll()
      .subscribe((data: Product[]) => {
          this.products = data;
        }
      );
  }

 /* public addProduct(product: Product) {
    this.products.push(product);
  }*/


 /* deleteProductP(product: Product) {
    this.productService.deleteProductById(product.id);
  }*/
}
