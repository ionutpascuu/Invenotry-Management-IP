import { Injectable } from '@angular/core';
import { Product } from "./product";
import { Http, Response } from "@angular/http";
import { Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable()
export class ProductService {
  private apiUrl = '/api/productCategories';
  constructor(private http: Http) {
  }
  findAll(): Promise<Array<Product>> {
    return this.http.get(this.apiUrl + '/getProducts')
      .toPromise()
      .then(response => response.json() as Product[])
      .catch(this.handleError);
  }
  createProduct(product: Product): Promise<Array<Product>> {
    let prodHeaders = new Headers({ 'Content-Type': 'application/json' });
    return this.http.post(this.apiUrl, JSON.stringify(product), { headers: prodHeaders })
      .toPromise()
      .then(response => response.json() as Product[])
      .catch(this.handleError);
  }
  deleteProductById(id: number): Promise<Array<Product>> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete(url)
      .toPromise()
      .then(response => response.json() as Product[])
      .catch(this.handleError);
  }
  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
