import { Product } from './../models/product';
import { ProductService } from './../services/product.service';
import {Router} from '@angular/router';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Component, Output, EventEmitter } from '@angular/core';
import {Logger} from 'codelyzer/util/logger';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css'],
  providers: [ProductService]
})
export class ProductAddComponent {
/*
  @Output() onProductAdded = new EventEmitter<Product>();

  productForm: FormGroup;
  productCode: FormControl;
  productName: FormControl;
  size: FormControl;

  constructor(private router: Router, private log: Logger, private fb: FormBuilder, private productService: ProductService) {

    // controls
    this.productCode = new FormControl('', [Validators.required]);
    this.productName = new FormControl('', [Validators.required]);
    this.size = new FormControl('', [Validators.required]);

    // build form
    this.productForm = fb.group(
      {
        productCode: this.productCode,
        productName: this.productName,
        size: this.size
      }
    );
  }

  public addProduct() {
    this.log.debug('StockAddComponent.addStock()', this.productForm.value);

    this.productService.addProduct(this.productForm.value).subscribe(
      res => {
        this.log.debug('ProductAddComponent Product added', res);
        this.onProductAdded.emit(res);
      },
      err => {
        this.log.error('ProductAddComponent Can\'t add product', err);
      });
  }
  */
  private products: Product[];
  constructor(private router: Router,
              private productService: ProductService) { }
 /* ngOnInit() {

  }*/

  createProduct() {
    const productCode = (<HTMLInputElement>document.getElementById('productCode')).value;
    const productName = (<HTMLInputElement>document.getElementById('productName')).value;
    const categories = (<HTMLInputElement>document.getElementById('category')).value;
    const size = (<HTMLInputElement>document.getElementById('size')).value;
    const product = new Product(0, categories, productCode, productName, Number(size));

    this.productService.addProduct(product);
    this.router.navigate(['/']);
  }




}

