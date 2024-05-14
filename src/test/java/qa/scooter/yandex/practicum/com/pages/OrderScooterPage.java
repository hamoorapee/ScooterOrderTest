package qa.scooter.yandex.practicum.com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrderScooterPage {
    private ElementsCollection orderButtons = $$(byText("Заказать")),
            inputContainers = $$("[type='text']").filterBy(visible),
            metroInputContainer = $$("[role='menuitem']");
    private SelenideElement
            subwayStationInput = $(".select-search__value"),
            orderContinueButton = $(byText("Далее")),
            calendarInputContainer = $(".react-datepicker-wrapper");

    @Step("Кликает на кнопку заказа в шапке сайта")
    public OrderScooterPage clickHeaderButtonOrder() {
        orderButtons.get(0).click();
        return this;
    }

    @Step("Кликает на кнопку заказа в сайте")
    public OrderScooterPage clickBigButtonOrder() {
        orderButtons.get(1).click();
        return this;
    }

    @Step("Задаем значение имени в форму")
    public OrderScooterPage setFirstName(String name) {
        inputContainers.get(0).setValue(name);
        return this;
    }

    @Step("Задаем значение фамилии в форму")
    public OrderScooterPage setSecondName(String name) {
        inputContainers.get(1).setValue(name);
        return this;
    }

    @Step("Задаем значение адреса в форму")
    public OrderScooterPage setAddress(String address) {
        inputContainers.get(2).setValue(address);
        return this;
    }

    @Step("Задаем значение станции метро в форму")
    public OrderScooterPage setSubwayStation(String station) {
        subwayStationInput.click();
        metroInputContainer.findBy(text(station)).click();
        return this;
    }

    @Step("Задаем значение номера в форму")
    public OrderScooterPage setNum(String num) {
        inputContainers.get(3).setValue(num);
        return this;
    }

    @Step("Нажимаем кнопку продолжить в окне первой формы")
    public OrderScooterPage clickOrderContinue() {
        orderContinueButton.click();
        return this;
    }
    @Step("Задаем значение даты в форму")
    public OrderScooterPage calendarSetDate(String day, String month, String year){
        calendarInputContainer.click();
        calendarInputContainer.setValue(day+"."+month+"."+year);
        return this;
    }

}
