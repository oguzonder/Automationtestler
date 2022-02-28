package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ProductsPage;
import pages.SubscriptionPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Random;

public class ProductsPageStepDefs {

    ProductsPage productsPage=new ProductsPage();
    SubscriptionPage subscriptionPage=new SubscriptionPage();

    //TC08_verify all products product detail page

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

    //TC12_Add Products in Cart

    @Then("kullanici ilk urune hover over yapar ve tiklayarak sepete ekler")
    public void kullanici_ilk_urune_hover_over_yapar_ve_tiklayarak_sepete_ekler() {

        ReusableMethods.hover(subscriptionPage.firstProduct);
        Driver.wait(4);
        subscriptionPage.addToCartButton.click();
        Driver.wait(4);
    }


    @Then("kullanici continue shopping butona tiklar")
    public void kullanici_continue_shopping_butona_tiklar() {
        subscriptionPage.continueButton.click();
    }
    @Then("kullanici ikinci urune hover over yapar ve tiklayarak sepete ekler")
    public void kullanici_ikinci_urune_hover_over_yapar_ve_tiklayarak_sepete_ekler() {

        Driver.wait(4);
        ReusableMethods.hover(subscriptionPage.secondProduct);
        Driver.wait(4);
        subscriptionPage.addToCartButton2.click();
    }
    @Then("kullanici view cart butona tiklar")
    public void kullanici_view_cart_butona_tiklar() {
        subscriptionPage.cartButton.click();
    }
    @Then("kullanici her iki urunun de sepete eklendigini test eder")
    public void kullanici_her_iki_urunun_de_sepete_eklendigini_test_eder() {
        Assert.assertEquals(2,subscriptionPage.productsInCart.size());
    }
    @Then("kullanici prices, quantity ve total price degerlerini test eder")
    public void kullanici_prices_quantity_ve_total_price_degerlerini_test_eder() {

        //Price-> Rs.500     quantity -> 1      Total -> Rs.500   digital omayan her karakteri kaldirabiliriz..

        int firstPrice= Integer.parseInt(subscriptionPage.firstPrice.getText().replaceAll("[^0-9]",""));

        int secondPrice= Integer.parseInt(subscriptionPage.secondPrice.getText().replaceAll("[^0-9]",""));

        String firstTotalPrice= subscriptionPage.firstTotolPrice.getText().replaceAll("[^0-9]","");

        String secondTotalPrice= subscriptionPage.secondTotolPrice.getText().replaceAll("[^0-9]","");

        Assert.assertEquals(500,firstPrice);
        Assert.assertEquals(400,secondPrice);
        Assert.assertEquals("1", subscriptionPage.firstQuantity.getText());
        Assert.assertEquals("1", subscriptionPage.secondQuantity.getText());
        Assert.assertEquals("500", firstTotalPrice);
        Assert.assertEquals("400", secondTotalPrice);
    }


    @Then("ana sayfada herhangi bir urune tiklar")
    public void anaSayfadaHerhangiBirUruneTiklar() {
        Random randomNum = new Random();
        int i = randomNum.nextInt(productsPage.viewProductHomePage.size());
        productsPage.viewProductHomePage.get(i).click();

    }

    @Then("kullanici urun detayinin acildigini gorur")
    public void kullaniciUrunDetayininAcildiginiGorur() {

        String titlePage=Driver.getDriver().getTitle();
        System.out.println("titlePage = " + titlePage);
        Driver.wait(4);
        Assert.assertTrue(titlePage.contains("Product Details"));
    }

    @Then("kullanici miktari dorde cikarir")
    public void kullaniciMiktariDordeCikarir() {
        productsPage.quantityBox.clear();
        productsPage.quantityBox.sendKeys("4");
    }

    @Then("kullanici add to cart butona tiklar")
    public void kullaniciAddToCartButonaTiklar() {
        productsPage.addToCartButtonProduct.click();
    }

    @Then("kullanici Added olunca view cart butona tiklar")
    public void kullaniciAddedOluncaViewCartButonaTiklar() {

        productsPage.viewCartButtonProduct.click();
    }

    @Then("kullanici urunun sepet sayfasinda artirilan miktar kadar goruntulendigini test eder")
    public void kullaniciUrununSepetSayfasindaArtirilanMiktarKadarGoruntulendiginiTestEder() {

        String quantity= productsPage.quantityBoxInCart.getText();
        Driver.wait(4);
        Assert.assertEquals("4",quantity);
    }


}
