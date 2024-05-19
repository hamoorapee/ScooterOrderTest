package qa.scooter.yandex.practicum.com.ui;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.scooter.yandex.practicum.com.BaseTest;

import static com.codeborne.selenide.Selenide.open;

public class OrderScooterTests extends BaseTest {

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в верхнем меню")
    @Description("Проверка заказа самоката из кнопки в верхнем меню, всех полей ввода и корректности отображения диалоговых окон и данных")
    public void OrderScooterTestInHighButton(){
        orderScooterPage.clickHeaderButtonOrder()
                .setFirstName("Николай")
                .setSecondName("Хорошавцев")
                .setAddress("Белинского 111")
                .setSubwayStation("Черкизовская")
                .setNum("999999999999")
                .clickOrderContinue()
                .calendarSetDate("16","06","2024")
                .chooseRentalPeriod(5)
                .chooseScooterColor(1)
                .setCommentForCourier("Привезите с собой воды")
                .approveOrderInFilledForm()
                .clickYesAtTheFinalOfForm()
                .checkApproveCreatedOrder()
                .getOrderNumber()
                .clickCheckOrder()
                .checkOrderNumber();
    }

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в середине страницы")
    @Description("Проверка заказа самоката из кнопки в середине страницы, всех полей ввода и корректности отображения диалоговых окон и данных")
    public void OrderScooterTestInMiddleButton(){
        orderScooterPage.clickBigButtonOrder()
                .setFirstName("Николай")
                .setSecondName("Хорошавцев")
                .setAddress("Белинского 111")
                .setSubwayStation("Черкизовская")
                .setNum("999999999999")
                .clickOrderContinue()
                .calendarSetDate("16","06","2024")
                .chooseRentalPeriod(5)
                .chooseScooterColor(1)
                .setCommentForCourier("Привезите с собой воды")
                .approveOrderInFilledForm()
                .clickYesAtTheFinalOfForm()
                .checkApproveCreatedOrder()
                .getOrderNumber()
                .clickCheckOrder()
                .checkOrderNumber();
    }

    @Test
    @DisplayName("Проверка корректности ссылки после клика на лого")
    @Description("Проверка корректности ссылки после клика на лого через проверку URL")
    public void logoLinkToMain(){
        open("/order");
        orderScooterPage.clickToLogo()
                .checkUrl();
    }

    @Test
    @DisplayName("Проверка заказа самоката с введением некорректных данных")
    @Description("Проверка заказа самоката с введением некорректных данных, сообщение об ошибке всех полей ввода и невозможности оформления заказа при некорректно введенных данных")
    public void negativeTest(){
        open("/order");
        orderScooterPage.clickOrderContinue()
                .setAddress("9")
                .checkErrorMessages()
                .setFirstName("Николай")
                .setSecondName("Хорошавцев")
                .setAddress("Белинского 111")
                .setSubwayStation("Черкизовская")
                .setNum("999999999999")
                .clickOrderContinue()
                .calendarSetDate("16","06","2024")
                .approveOrderInFilledForm()
                .checkAvailabilityCreateOrder()
                .cleanDateContainer()
                .chooseRentalPeriod(4)
                .approveOrderInFilledForm()
                .checkAvailabilityCreateOrder();
    }
}
