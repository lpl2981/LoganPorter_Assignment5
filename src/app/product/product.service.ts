import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { AppComponent } from './../app.component';
import { HttpClientModule } from '@angular/common/http'; 
import { HttpModule } from '@angular/http';
import 'rxjs/add/operator/map';
@Injectable()
export class ProductService {
    constructor(private http: Http) {

    }
    private getHeaders() {
        // I included these headers because otherwise FireFox
        // will request text/html
        let headers = new Headers();
        headers.append('Accept', 'application/json');
        headers.append('Content-Type', 'application/json');
        return headers;
    }
    //This function is used to get the product data based on the customerID.
    //-- Start --
    getProducts(): Observable<AppComponent> {
        let productList$ = this.http
            .get(`http://localhost:8013/productmanagement/products`, { headers: this.getHeaders() })
            .map(res => res.json());
        return productList$;
    }//-- End --

    //This function is used to add the product data based on the customerID.
    //-- Start --
   addProducts(product): Observable<AppComponent> {
    const url = `http://localhost:8013/productmanagement/addproduct`;
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let productList$ = this.http
        .post(url, product, options)
        .map(res => res.json());
    return productList$;
    }//-- End --

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}
