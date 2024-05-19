package qa.scooter.yandex.practicum.com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private SelenideElement cookiesConfirmButton = $("#rcc-confirm-button");

    private ElementsCollection askButtons = $$(".accordion__item"),
            askResponds = $$(".accordion__panel");

    @Step("Принятие cookies")
    public MainPage acceptCookies() {
        cookiesConfirmButton.shouldBe(visible).click();
        return this;
    }

    @Step("Клик по разделу '{numberOfAsk}'")
    public MainPage openSection(int numberOfAsk) {
        numberOfAsk--;
        askButtons.get(numberOfAsk).click();
        return this;
    }

    @Step("Проверка текста после открытия раздела '{value}'")
    public MainPage checkTextSection(String value) {
        askResponds = askResponds.filter(visible);
        askResponds.get(0).shouldHave(text(value));
        return this;
    }
}
