import {Component, OnInit} from '@angular/core';
import { Product } from './../models/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product-report',
  templateUrl: './product-report.component.html',
  styleUrls: ['./product-report.component.css'],
  providers: [ProductService]
})

export class ProductReportComponent implements OnInit {
  startDate: string;
  endDate: string;
  products: Product[];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.startDate = '';
    this.endDate = '';
  }

  private productReports() {
    this.productService.getProductReport(this.startDate, this.endDate).subscribe((data: Product[]) => {
        this.products = data;
      }
    );
  }

  /* gotoList() {
     this.router.navigate(['/']);
   }*/

  onSubmit() {
    this.productReports();
  }

}
