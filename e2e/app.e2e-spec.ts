import { ProductManagementClientPage } from './app.po';

describe('product-management-client App', () => {
  let page: ProductManagementClientPage;

  beforeEach(() => {
    page = new ProductManagementClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
