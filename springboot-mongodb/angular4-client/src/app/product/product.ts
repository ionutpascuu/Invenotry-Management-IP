export class Product {
  id: number;
  productCode: string;
  productName: string;
  price: number;
  constructor(id: number, productCode: string, productName: string, price: number){
    this.id = id;
    this.productCode = productCode;
    this.productName = productName;
    this.price = price;
  }
}
