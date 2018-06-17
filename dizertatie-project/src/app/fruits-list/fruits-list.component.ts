import { Product } from './../models/product';

import { Component, OnInit , Input } from '@angular/core';
import { ProductService } from '../services/product.service';
import {Logger} from 'codelyzer/util/logger';
import {Router} from '@angular/router';

@Component({
  selector: 'app-fruits-list',
  templateUrl: './fruits-list.component.html',
  styleUrls: ['./fruits-list.component.css'],
  providers: [ProductService]
})
export class FruitsListComponent implements OnInit {


  public products: Product[];


  constructor(private router: Router,
              private productService: ProductService) {
  }

  ngOnInit() {
    this.getAllFruits();
  }

  getAllFruits() {

    this.productService.getAllFruits()
      .subscribe((data: Product[]) => {
          this.products = data;
        }
      );
  }

/*
  public addProduct(product: Product) {
    this.products.push(product);
  }
*/


/*  deleteProduct(product: Product) {
    this.productService.deleteProductById(product.id);
  }*/
}
