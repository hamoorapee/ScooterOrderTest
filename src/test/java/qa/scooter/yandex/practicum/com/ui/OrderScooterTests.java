package qa.scooter.yandex.practicum.com.ui;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.scooter.yandex.practicum.com.TestData;

import static com.codeborne.selenide.Selenide.open;

@Epic("UI Автотесты")
public class OrderScooterTests extends TestData {

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в верхнем меню")
    public void OrderScooterTestInHighButton() {
        orderScooterPage
                .clickHeaderButtonOrder()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setAddress(ADDRESS)
                .setSubwayStation(SUBWAY_STATION)
                .setNum(PHONE_NUMBER)
                .clickOrderContinue()
                .setDataInCalendar(DAY, MONTH, YEAR)
                .clickAndChooseRentalPeriod(RENTAL_PERIOD)
                .chooseScooterColor(SCOOTER_COLOR)
                .setCommentForCourier(COMMENT)
                .approveOrderInFilledForm()
                .clickYesAtTheFinalOfForm()
                .checkApproveCreatedOrder()
                .getOrderNumber()
                .clickCheckOrder()
                .checkOrderNumber();
    }

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в середине страницы")
    public void OrderScooterTestInMiddleButton() {
        orderScooterPage
                .clickBigButtonOrder()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setAddress(ADDRESS)
                .setSubwayStation(SUBWAY_STATION)
                .setNum(PHONE_NUMBER)
                .clickOrderContinue()
                .setDataInCalendar(DAY, MONTH, YEAR)
                .clickAndChooseRentalPeriod(RENTAL_PERIOD)
                .chooseScooterColor(SCOOTER_COLOR)
                .setCommentForCourier(COMMENT)
                .approveOrderInFilledForm()
                .clickYesAtTheFinalOfForm()
                .checkApproveCreatedOrder()
                .getOrderNumber()
                .clickCheckOrder()
                .checkOrderNumber();
    }

    @Test
    @DisplayName("Проверка корректности ссылки после клика на лого")
    public void logoLinkToMain() {
        open("/order");
        orderScooterPage
                .clickToLogo()
                .checkUrl();
    }

    @Test
    @DisplayName("Проверка заказа самоката с введением некорректных данных")
    public void negativeTest() {
        open("/order");
        orderScooterPage
                .clickOrderContinue()
                .setAddress("9")
                .checkErrorMessages()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setAddress(ADDRESS)
                .setSubwayStation(SUBWAY_STATION)
                .setNum(PHONE_NUMBER)
                .clickOrderContinue()
                .setDataInCalendar(DAY, MONTH, YEAR)
                .approveOrderInFilledForm()
                .checkAvailabilityCreateOrder()
                .cleanDateContainer()
                .clickAndChooseRentalPeriod(RENTAL_PERIOD)
                .approveOrderInFilledForm()
                .checkAvailabilityCreateOrder();
    }
}
