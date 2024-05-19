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
    private String orderNumber;

    CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement
            subwayStationInput = $(".select-search__value"),
            orderContinueBtn = $x("//*[contains(text(),'Далее')]"),
            rentalPeriodArrowBtn = $(".Dropdown-arrow"),
            commentForCourierInput = $("[placeholder='Комментарий для курьера']"),
            orderFullText = $x("//*[contains(text(),'Номер заказа:')]"),
            checkStatusBtn = $x("//*[contains(text(),'Посмотреть статус')]"),
            orderNumInContainer = $(".Input_Responsible__1jDKN"),
            logoLocator = $(".Header_Logo__23yGT"),
            orderMetroErrorMessage = $(".Order_MetroError__1BtZb"),
            orderHeaderModal = $(".Order_ModalHeader__3FDaJ");

    private ElementsCollection orderButtons = $$(byText("Заказать")),
            inputContainers = $$("[type='text']").filterBy(visible),
            metroInputContainer = $$("[role='menuitem']"),
            rentalPeriods = $$(".Dropdown-option"),
            scooterColorCheckboxLabel = $$("label"),
            orderButtonInFilledForm = $$("button.Button_Button__ra12g.Button_Middle__1CSJM"),
            orderButtonInFullFilledForm = $$("div.Order_Modal__YZ-d3 button.Button_Button__ra12g.Button_Middle__1CSJM:last-of-type"),
            errorMessages = $$(".Input_ErrorMessage__3HvIb");

    @Step("Клик на кнопку заказа в шапке сайта")
    public OrderScooterPage clickHeaderButtonOrder() {
        orderButtons.get(0).click();
        return this;
    }

    @Step("Клик на кнопку заказа в сайте")
    public OrderScooterPage clickBigButtonOrder() {
        orderButtons.get(1).click();
        return this;
    }

    @Step("Установка значения имени в форму")
    public OrderScooterPage setFirstName(String name) {
        inputContainers.get(0).setValue(name);
        return this;
    }

    @Step("Установка значения фамилии в форму")
    public OrderScooterPage setSecondName(String name) {
        inputContainers.get(1).setValue(name);
        return this;
    }

    @Step("Установка значения адреса в форму")
    public OrderScooterPage setAddress(String address) {
        inputContainers.get(2).setValue(address);
        return this;
    }

    @Step("Установка значения станции метро в форму")
    public OrderScooterPage setSubwayStation(String station) {
        subwayStationInput.click();
        metroInputContainer.findBy(text(station)).click();
        return this;
    }

    @Step("Установка значения номера в форму")
    public OrderScooterPage setNum(String num) {
        inputContainers.get(3).setValue(num);
        return this;
    }

    @Step("Клик на кнопку 'Продолжить' в окне первой формы")
    public OrderScooterPage clickOrderContinue() {
        orderContinueBtn.click();
        return this;
    }

    @Step("Установка даты в календаре: '{day}', '{month}', '{year}'")
    public OrderScooterPage setDataInCalendar(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Клик на поле и установка количества суток аренды")
    public OrderScooterPage clickAndChooseRentalPeriod(int periodInDays) {
        periodInDays--;
        rentalPeriodArrowBtn.click();
        rentalPeriods.get(periodInDays).click();
        return this;
    }

    @Step("Установка значения цвета самоката")
    public OrderScooterPage chooseScooterColor(int colorNum) {
        colorNum--;
        scooterColorCheckboxLabel.get(colorNum).click();
        return this;
    }

    @Step("Установка значения комментария для курьера: '{comment}'")
    public OrderScooterPage setCommentForCourier(String comment) {
        commentForCourierInput.setValue(comment);
        return this;
    }

    @Step("Клик по кнопке заказа в конце заполнения формы")
    public OrderScooterPage approveOrderInFilledForm() {
        orderButtonInFilledForm.get(1).click();
        return this;
    }

    @Step("Клик по кнопке 'Да' после заполнения и нажатия кнопки заказа")
    public OrderScooterPage clickYesAtTheFinalOfForm() {
        orderButtonInFullFilledForm.first().click();
        return this;
    }

    @Step("Проверка подтверждения создания заказа")
    public OrderScooterPage checkApproveCreatedOrder() {
        orderHeaderModal.shouldHave(text("Заказ оформлен"));
        return this;
    }

    @Step("Получение номера заказа")
    public OrderScooterPage getOrderNumber() {
        orderNumber = orderFullText.getText().replaceAll("\\D+", "");
        return this;
    }

    @Step("Клик на кнопку 'Посмотреть Статус'")
    public OrderScooterPage clickCheckOrder() {
        checkStatusBtn.click();
        return this;
    }

    @Step("Проверка номера заказа на финальной странице заказа")
    public OrderScooterPage checkOrderNumber() {
        orderNumInContainer.shouldHave(value(orderNumber));
        return this;
    }

    @Step("Клик по логотипу 'Самокат'")
    public OrderScooterPage clickToLogo() {
        logoLocator.click();
        return this;
    }

    @Step("Проверка ссылки перенаправления")
    public OrderScooterPage checkUrl() {
        String currentUrl = webdriver().driver().url();
        assertEquals(BASE_URL+"/", currentUrl);
        return this;
    }

    @Step("Проверка появление сообщений об ошибках")
    public OrderScooterPage checkErrorMessages() {
        errorMessages.filter(visible).shouldHave(size(4));
        orderMetroErrorMessage.shouldBe(visible);
        return this;
    }

    @Step("Проверка возможности принять заказ")
    public OrderScooterPage checkAvailabilityCreateOrder(){
        orderHeaderModal.shouldBe(hidden);
        return this;
    }

    @Step("Очистка поля ввода даты")
    public OrderScooterPage cleanDateContainer(){
        calendarComponent.cleanDate();
        return this;
    }
}
