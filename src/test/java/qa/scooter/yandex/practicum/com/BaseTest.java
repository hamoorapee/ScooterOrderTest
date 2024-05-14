package qa.scooter.yandex.practicum.com;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import qa.scooter.yandex.practicum.com.pages.MainPage;
import qa.scooter.yandex.practicum.com.pages.OrderScooterPage;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    String shortUrl;
    protected static MainPage mainPage = new MainPage();
    protected static OrderScooterPage orderScooterPage = new OrderScooterPage();
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru";

    @BeforeAll
    public static void configure() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = "1920x1080";
        open(BASE_URL);
        mainPage.confirmCookies();
    }

    @BeforeEach
    public void prepareTestData() {
        shortUrl = "";
    }


}
//открываться страница


//унаследовать тест от бейса не забыть
//
//
//