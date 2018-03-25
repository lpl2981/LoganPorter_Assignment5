import { Component, HostListener } from '@angular/core';
import { CooperComponent } from './cooper/cooper.component';
import { ProductComponent } from './product/product.component';
import { ProductService } from './../app/product/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ProductService]
})
export class AppComponent {
  success = false;
  error = false;
  title = 'Product Database';
  product = {
    name: "",
    description: "",
    startingPrice: null
  }
  products = [{
    name: "",
    description: "",
    startingPrice: null,
    bids: [
      {
        userName: "",
        price: null
      }
    ]
  }];
  constructor(private productService: ProductService) {
    this.products = [];
  }

  ngOnInit() {
    this.getProducts();
  }

  @HostListener('document:keypress', ['$event'])
  handleKeyboardEvent(event: KeyboardEvent) {
    if (event.srcElement.id == "startingPrice" && (event.keyCode < 48 || event.keyCode > 57)) {
      event.returnValue = false;
    }
  }

  getProducts() {
    this.productService.getProducts().subscribe((data: any) => {
      this.products = data;
    }, error => {
    });
  }

  createProduct(product) {
    this.productService.addProducts(product).subscribe((data: any) => {
      this.success = true;
      setTimeout(() => {    //<<<---    using ()=> syntax
        this.success = false;
      }, 2000);
      this.products = data;
      this.product.name = "";
      this.product.description = "";
      this.product.startingPrice = null;
    }, error => {
      this.error = true;
      setTimeout(() => {    //<<<---    using ()=> syntax
        this.error = false;
      }, 2000);
    });
  }
}
