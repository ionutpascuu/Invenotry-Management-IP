import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';

import { ProductListComponent } from './product-list/product-list.component';
import { ProductPageComponent } from './product-page/product-page.component';
import { BauturiTutunListComponent } from './bauturi-tutun-list/bauturi-tutun-list.component';
import { BauturiTutunPageComponent } from './bauturi-tutun-page/bauturi-tutun-page.component';
import { FruitsListComponent } from './fruits-list/fruits-list.component';
import { FruitsPageComponent } from './fruits-page/fruits-page.component';
import { FoodListComponent } from './food-list/food-list.component';
import { FoodPageComponent } from './food-page/food-page.component';
import { ElectronicsListComponent } from './electronics-list/electronics-list.component';
import { ElectronicsPageComponent } from './electronics-page/electronics-page.component';
import { ClothesListComponent } from './clothes-list/clothes-list.component';
import { ClothesPageComponent } from './clothes-page/clothes-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductAddComponent } from './product-add/product-add.component';
import { SearchProductComponent } from './search-product/search-product.component';
import { ProductReportComponent } from './product-report/product-report.component';


const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'product', component: ProductPageComponent } ,
  { path: 'bauturi-tutun', component: BauturiTutunPageComponent } ,
  { path: 'fruits', component: FruitsPageComponent } ,
  { path: 'food', component: FoodPageComponent } ,
  { path: 'electronics', component: ElectronicsPageComponent } ,
  { path: 'clothes', component: ClothesPageComponent } ,
  { path: 'product/:productCode', component: ProductDetailsComponent },
  { path: 'fruits/:productCode', component: ProductDetailsComponent },
  { path: 'bauturi-tutun/:productCode', component: ProductDetailsComponent },
  { path: 'food/:productCode', component: ProductDetailsComponent },
  { path: 'electronics/:productCode', component: ProductDetailsComponent },
  { path: 'clothes/:productCode', component: ProductDetailsComponent },
  { path: 'addProduct', component: ProductAddComponent },
  { path: 'search', component: SearchProductComponent},
  {path: 'report', component: ProductReportComponent}


];

export const routing = RouterModule.forRoot(routes);

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ProductPageComponent,
    BauturiTutunPageComponent,
    FruitsPageComponent,
    FoodPageComponent,
    ElectronicsPageComponent,
    ClothesPageComponent,
    ProductListComponent ,
    BauturiTutunListComponent,
    FruitsListComponent,
    FoodListComponent,
    ElectronicsListComponent,
    ClothesListComponent,
    ProductDetailsComponent ,
    ProductAddComponent,
    SearchProductComponent,
    ProductReportComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
