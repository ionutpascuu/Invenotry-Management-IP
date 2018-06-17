package ip.springbootmongodb;

import ip.springbootmongodb.Controller.ProductCategoryController;
import ip.springbootmongodb.model.ProductNew;
import ip.springbootmongodb.service.CategoryService;
import ip.springbootmongodb.service.ProductNewService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductCategoryControllerTest {

    private static final String VALID_PRODUCT_CODE = "CODE0002";
    private static final String VALID_CATEGORY_NAME = "Fructe";

    @Mock
    private ProductNewService productNewService;

    @Mock
    private CategoryService categoryService;

    private ProductCategoryController productCategoryController = new ProductCategoryController();

    private MockMvc productMockMvc;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        ReflectionTestUtils.setField(productCategoryController, "productNewService", productNewService);
        ReflectionTestUtils.setField(productCategoryController,"categoryService",categoryService);

        this.productMockMvc = MockMvcBuilders
                .standaloneSetup(productCategoryController)
                .build();
    }


    @Test
    public void getProductsTest_OK() throws Exception {

        when(productNewService.findAll()).thenReturn(new ArrayList<>());

        productMockMvc.perform(get("/api/productCategories/getProducts"))
                .andExpect(status().isOk());
    }

    @Test
    public void  getProductsTest_OK_verify_method() throws Exception {
        productMockMvc.perform(get("/api/productCategories/getProducts"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
       verify(productNewService, times(1)).findAll();
    }

    @Test
    public void getCategoriesTest_OK() throws Exception {

        when(categoryService.findAll()).thenReturn(new ArrayList<>());

        productMockMvc.perform(get("/api/productCategories/getCategories"))
                .andExpect(status().isOk());
    }

    @Test
    public void  getCategoriesTest_OK_verify_method() throws Exception {
        productMockMvc.perform(get("/api/productCategories/getCategories"))
                .andExpect(status().isOk());
        verify(categoryService, times(1)).findAll();
    }
    @Test
    public void getProductByProductCodeTest_OK() throws Exception {

        when(productNewService.findByProductCode(VALID_PRODUCT_CODE)).thenReturn(new ProductNew());
        productMockMvc.perform(get("/api/productCategories//getProductByProductCode/"+ VALID_PRODUCT_CODE +"/"))
                .andExpect(status().isOk());
    }

    @Test
    public void  getProductByProductCodeTest_OK_verify_method() throws Exception {
        productMockMvc.perform(get("/api/productCategories//getProductByProductCode/"+ VALID_PRODUCT_CODE +"/"))
                .andExpect(status().isOk());
        verify(productNewService, times(1)).findByProductCode(VALID_PRODUCT_CODE);
    }

   /* @Test
    public void getProductsByCategoriesTest_OK() throws Exception {

        List<ProductNew> productList = new ArrayList<>();
        ProductNew firstProduct = new ProductNew();
        ProductNew secondProduct = new ProductNew();

        productList.add(firstProduct);
        productList.add(secondProduct);

        when(productNewService.findProductsByCategory(VALID_PRODUCT_CODE)).thenReturn(productList);
        productMockMvc.perform(get("/api/productCategories//getProductsByCategories/"+ VALID_CATEGORY_NAME +"/"))
                .andExpect(status().isOk());
    }*/

    @Test
    public void  getProductsByCategoriesTest_OK_verify_method() throws Exception {
        productMockMvc.perform(get("/api/productCategories//getProductsByCategories/"+ VALID_CATEGORY_NAME +"/"))
                .andExpect(status().isOk());
        verify(productNewService, times(1)).findProductsByCategory(VALID_CATEGORY_NAME);
    }


}
