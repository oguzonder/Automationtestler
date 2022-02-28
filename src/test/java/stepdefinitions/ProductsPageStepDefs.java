package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ProductsPage;
import utilities.Driver;

public class ProductsPageStepDefs {

    ProductsPage productsPage=new ProductsPage();

    @Then("kullanici Products butonuna tiklar")
    public void kullanici_products_butonuna_tiklar() {
        productsPage.productButton.click();
    }
    @Then("kullanici ALL PRODUCTS sayfasina basariyla yonlendirildigini test eder")
    public void kullanici_all_products_sayfasina_basariyla_yonlendirildigini_test_eder() {
        Assert.assertTrue(productsPage.allProductsText.isDisplayed());
    }
    @Then("kullanici urun listesini gorur")
    public void kullanici_urun_listesini_gorur() {
        Assert.assertEquals(34, productsPage.productList.size());
    }
    @Then("kullanici ilk urunde View Product a tiklar")
    public void kullanici_ilk_urunde_view_product_a_tiklar() {
        productsPage.viewProductButton1.click();
    }
    @Then("kullanici, urun detay sayfasina yonlendirilir")
    public void kullanici_urun_detay_sayfasina_yonlendirilir() {
        String expectedUrl = "https://www.automationexercise.com/product_details/1";
        Assert.assertEquals(expectedUrl, Driver.getDriver().getCurrentUrl());
    }
    @Then("kullanici ayrintilarin\\(urun adi, kategori, fiyat, bulunabilirlik, durum, marka) gorunur oldugunu test eder")
    public void kullanici_ayrintilarin_urun_adi_kategori_fiyat_bulunabilirlik_durum_marka_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(productsPage.ProductName.isDisplayed());
        Assert.assertTrue(productsPage.Category.isDisplayed());
        Assert.assertTrue(productsPage.Price.isDisplayed());
        Assert.assertTrue(productsPage.Availability.isDisplayed());
        Assert.assertTrue(productsPage.Condition.isDisplayed());
        Assert.assertTrue(productsPage.Brand.isDisplayed());

    }

}
