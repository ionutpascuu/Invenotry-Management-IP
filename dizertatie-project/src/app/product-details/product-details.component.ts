import { Product } from './../models/product';
import { ProductService } from './../services/product.service';

import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css'],
  providers: [ProductService]
})
export class ProductDetailsComponent implements OnInit, OnDestroy {
  product: any = {};

  sub: Subscription;


  constructor(private route: ActivatedRoute,
              private router: Router,
              private productService: ProductService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const code = params['productCode'];
      if (code) {
        this.productService.getProductByProductCode(code).subscribe((product: any) => {
          if (product) {
            this.product = product;
          } else {
            console.log(`product with code '${code}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/']);
  }

  deleteProduct(product: Product) {
    this.productService.deleteProductById(product.id);

    this.router.navigate(['/']);
  }

/*  save(form: NgForm) {
    this.productService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.productService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }*/
}


