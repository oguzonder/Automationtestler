Feature: Products page feature
  @product
  Scenario: TC08_verify_all_products_product_detail_page
            (Tum urunleri dogrulama ve urun detay sayfasi)

    When kullanici tarayiciyi baslatir
    Then kullanici anasayfaya gider
    Then ana sayfanin gorunur oldugunu test eder
    Then kullanici Products butonuna tiklar
    Then kullanici ALL PRODUCTS sayfasina basariyla yonlendirildigini test eder
    Then kullanici urun listesini gorur
    Then kullanici ilk urunde View Product a tiklar
    Then kullanici, urun detay sayfasina yonlendirilir
    Then kullanici ayrintilarin(urun adi, kategori, fiyat, bulunabilirlik, durum, marka) gorunur oldugunu test eder


