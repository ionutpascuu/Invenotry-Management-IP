import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductRoutingModule} from "./product-routing.module";
import { FormsModule,ReactiveFormsModule} from "@angular/forms";
import { ProductListComponent} from "./product-list/product-list.component";

@NgModule({
  imports: [
    CommonModule,
    ProductRoutingModule,
    FormsModule,
    ReactiveFormsModule

  ],
  declarations: [ProductListComponent]
})
export class ProductModule { }
