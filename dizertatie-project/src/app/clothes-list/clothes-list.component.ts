import { Product } from './../models/product';

import { Component, OnInit , Input } from '@angular/core';
import { ProductService } from '../services/product.service';
import {Logger} from 'codelyzer/util/logger';
import {Router} from '@angular/router';

@Component({
  selector: 'app-clothes-list',
  templateUrl: './clothes-list.component.html',
  styleUrls: ['./clothes-list.component.css'],
  providers: [ProductService]
})
export class ClothesListComponent implements OnInit {


  public products: Product[];

  constructor(private router: Router,
              private productService: ProductService) {
  }

  ngOnInit() {
    this.getAllClothes();
  }

  getAllClothes() {

    this.productService.getAllClothes()
      .subscribe((data: Product[]) => {
          this.products = data;
        }
      );
  }

 /* public addProduct(product: Product) {
    this.products.push(product);
  }*/


/*  deleteProduct(product: Product) {
    this.productService.deleteProductById(product.id);
  }*/
}
