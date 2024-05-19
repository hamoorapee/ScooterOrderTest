package qa.scooter.yandex.practicum.com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import qa.scooter.yandex.practicum.com.pages.components.CalendarComponent;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static qa.scooter.yandex.practicum.com.BaseTest.BASE_URL;

public class OrderScooterPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    private String orderNumber;

    private ElementsCollection orderButtons = $$(byText("Заказать")),
            inputContainers = $$("[type='text']").filterBy(visible),
            metroInputContainer = $$("[role='menuitem']"),
            rentalPeriods = $$(".Dropdown-option"),
            scooterColorCheckboxLabel = $$("label"),
            orderButtonInFilledForm = $$("button.Button_Button__ra12g.Button_Middle__1CSJM"),
            orderButtonInFullFilledForm = $$("div.Order_Modal__YZ-d3 button.Button_Button__ra12g.Button_Middle__1CSJM:last-of-type"),
            errorMessages = $$(".Input_ErrorMessage__3HvIb");
    private SelenideElement
            subwayStationInput = $(".select-search__value"),
            orderContinueButton = $(byText("Далее")),
            rentalPeriodArrowButton = $(".Dropdown-arrow"),
            commentForCourierInput = $("[placeholder='Комментарий для курьера']"),
            orderFullText = $(byText("Номер заказа:")),
            orderNextButton = $(byText("Посмотреть статус")),
            orderNumInContainer = $(".Input_Responsible__1jDKN"),
            logoLocator = $(".Header_Logo__23yGT"),
            orderMetroErrorMessage = $(".Order_MetroError__1BtZb"),
            orderHeaderModal = $(".Order_ModalHeader__3FDaJ");

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

    @Step("Задаем значение даты")
    public OrderScooterPage calendarSetDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Кликаем на поле и выбираем количество суток аренды")
    public OrderScooterPage chooseRentalPeriod(int periodInDays) {
        periodInDays--;
        rentalPeriodArrowButton.click();
        rentalPeriods.get(periodInDays).click();
        return this;
    }

    @Step("Выбирает цвет самоката")
    public OrderScooterPage chooseScooterColor(int colorNum) {
        colorNum--;
        scooterColorCheckboxLabel.get(colorNum).click();
        return this;
    }

    @Step("Выбирает цвет самоката")
    public OrderScooterPage setCommentForCourier(String commentForCourier) {
        commentForCourierInput.setValue(commentForCourier);
        return this;
    }

    @Step("Нажимает на кнопку заказа в конце заполнения формы")
    public OrderScooterPage approveOrderInFilledForm() {
        orderButtonInFilledForm.get(1).click();
        return this;
    }

    @Step("Нажимает на кнопку 'Да' после заполнения и нажатия кнопки заказа")
    public OrderScooterPage clickYesAtTheFinalOfForm() {
        orderButtonInFullFilledForm.first().click();
        return this;
    }

    @Step("Проверяет подтверждение создания заказа")
    public OrderScooterPage checkApproveCreatedOrder() {
        orderHeaderModal.shouldHave(text("Заказ оформлен"));
        return this;
    }

    @Step("Забирает номер заказа")
    public OrderScooterPage getOrderNumber() {
        orderNumber = orderFullText.getText().replaceAll("\\D+", "");
        return this;
    }

    @Step("Кликает на кнопку Посмотреть Статус")
    public OrderScooterPage clickCheckOrder() {
        orderNextButton.click();
        return this;
    }

    @Step("Кликает на кнопку Посмотреть Статус")
    public OrderScooterPage checkOrderNumber() {
        orderNumInContainer.shouldHave(value(orderNumber));
        return this;
    }

    @Step("Кликает на лого Яндекс Самокат")
    public OrderScooterPage clickToLogo() {
        logoLocator.click();
        return this;
    }

    @Step("Проверяет ссылку перенаправления")
    public OrderScooterPage checkUrl() {
        String currentUrl = webdriver().driver().url();
        assertEquals(BASE_URL+"/", currentUrl);
        return this;
    }

    @Step("Проверяет появление сообщений об ошибках")
    public OrderScooterPage checkErrorMessages() {
        errorMessages.filter(visible).shouldHave(size(4));
        orderMetroErrorMessage.shouldBe(visible);
        return this;
    }
    @Step("Проверяет готовность принять заказ")
    public OrderScooterPage checkAvailabilityCreateOrder(){
        orderHeaderModal.shouldBe(hidden);
        return this;
    }
    @Step("Очищает поле ввода даты")
    public OrderScooterPage cleanDateContainer(){
        calendarComponent.cleanDate();
        return this;
    }
}
