package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.SearchProductsPage;

public class SearchProductsStepDefs {

    SearchProductsPage searchProductsPage = new SearchProductsPage();

    @Then("kullanici arama girisine urun adini girer ve arama dugmesine tiklar")
    public void kullanici_arama_girisine_urun_adini_girer_ve_arama_dugmesine_tiklar() {
        searchProductsPage.searchProduct.sendKeys("Blue Top");
        searchProductsPage.searchButton.click();
    }

    @Then("kullanici product page de iken cart butona tiklar")
    public void kullanici_product_page_de_iken_cart_butona_tiklar() {

    }
    @Then("kullanici cart page is gorunur oldugunu test eder")
    public void kullanici_cart_page_is_gorunur_oldugunu_test_eder() {

    }


}
