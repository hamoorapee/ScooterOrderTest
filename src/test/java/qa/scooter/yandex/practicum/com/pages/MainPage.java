package qa.scooter.yandex.practicum.com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private ElementsCollection askButtons = $$(".accordion__item"),
            askResponds = $$(".accordion__panel");

    private SelenideElement cookiesConfirmButton = $("#rcc-confirm-button");

    @Step("Изначально принимает куки")
    public MainPage confirmCookies() {
        cookiesConfirmButton.click();
        return this;
    }

    @Step("Кликает и открывает вопрос по номеру")
    public MainPage askOpen(int numberOfAsk) {
        numberOfAsk--;
        askButtons.get(numberOfAsk).click();
        return this;
    }

    @Step("Проверяет после клика видимый текст")
    public MainPage checkRespond(String value) {
        askResponds = askResponds.filter(visible);
        askResponds.get(0).shouldHave(text(value));
        return this;
    }
}
