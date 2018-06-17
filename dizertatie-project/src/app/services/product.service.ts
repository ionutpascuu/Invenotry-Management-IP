import { Injectable } from '@angular/core';
import { Product } from './../models/product';
 import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class ProductService {
  private apiUrl = 'http://localhost:8080/api/productCategories';
  constructor(private http: HttpClient) {
  }
/*  findAll(): Promise<Array<Product>> {
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json() as Product[])
      .catch(this.handleError);
  }*/

  getAll(): Observable<any> {
    return this.http.get(this.apiUrl + '/getProducts');
  }

  getAllBeverageTobacco(): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductsByCategories/Bauturi-Tutun');
  }

  getAllFruits(): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductsByCategories/fructe');
  }

  getAllVegetables(): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductsByCategories/legume');
  }

  getAllFood(): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductsByCategories/alimente');
  }

  getAllElectronics(): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductsByCategories/Electronice');
  }

  getAllPetShop(): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductsByCategories/PetShop');
  }

  getAllCosmetics(): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductsByCategories/Cosmetice');
  }

  getAllClothes(): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductsByCategories/haine');
  }


  getProductByProductCode(productCode: string): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductByProductCode/' + productCode);
  }

  getProductByProductName(productName: string): Observable<any> {
    return this.http.get(this.apiUrl + '/getProductByProductName/' + productName);
  }

  getProductReport(startDate: string, endDate): Observable<any> {

    let params = new HttpParams();

    params = params.append('startDate', startDate);
    params = params.append('endDate', endDate);
 /*   params.set('startDate', startDate);
    params.set('endDate', endDate);*/
    return this.http.get(this.apiUrl + '/getProductReport' ,  { params: params });
  }

  addProduct(product: Product) {
  this.http.post(this.apiUrl + '/insert', product).subscribe(res => console.log('Done'));
  }

  deleteProductById(id) {
    this.http.delete(this.apiUrl + '/delete/' + id).subscribe(res => console.log('Done'));
  }



  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
