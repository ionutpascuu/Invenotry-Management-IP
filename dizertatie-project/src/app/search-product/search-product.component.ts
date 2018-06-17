import {Component, OnInit} from '@angular/core';
import { Product } from './../models/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.css'],
  providers: [ProductService]
})

export class SearchProductComponent implements OnInit {
  productName: string;
  products: Product[];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.productName = '';
  }

  private searchProducts() {
    this.productService.getProductByProductName(this.productName).subscribe((data: Product[]) => {
        this.products = data;
      }
    );
  }

 /* gotoList() {
    this.router.navigate(['/']);
  }*/

  onSubmit() {
    this.searchProducts();
  }

}
