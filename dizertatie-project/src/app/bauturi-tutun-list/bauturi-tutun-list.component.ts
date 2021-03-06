import { Product } from './../models/product';

import { Component, OnInit , Input } from '@angular/core';
import { ProductService } from '../services/product.service';
import {Logger} from 'codelyzer/util/logger';
import {Router} from '@angular/router';

@Component({
  selector: 'app-bauturi-tutun-list',
  templateUrl: './bauturi-tutun-list.component.html',
  styleUrls: ['./bauturi-tutun-list.component.css'],
  providers: [ProductService]
})
export class BauturiTutunListComponent implements OnInit {


  public products: Product[];

  constructor(private router: Router,
              private productService: ProductService) {
  }

  ngOnInit() {
    this.getAllBeverageTobacco();
  }

  getAllBeverageTobacco() {

    this.productService.getAllBeverageTobacco()
      .subscribe((data: Product[]) => {
          this.products = data;
        }
      );
  }

 /* public addProduct(product: Product) {
    this.products.push(product);
  }
*/

/*  deleteProduct(product: Product) {
    this.productService.deleteProductById(product.id);
  }*/
}
