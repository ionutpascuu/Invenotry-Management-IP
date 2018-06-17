export class Product {

  public static toObject(json: any): Product {
    return new Product(json.id, json.categories, json.productCode, json.productName, json.size);
  }

  constructor(
    public id: number,
    public categories: string,
    public productCode: string,
    public productName: string,
    public size: number
  ) {}
}
