package qa.scooter.yandex.practicum.com.ui;

import org.junit.jupiter.api.Test;
import qa.scooter.yandex.practicum.com.BaseTest;

import static com.codeborne.selenide.Selenide.open;

public class OrderScooterTests  extends BaseTest {

    @Test
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
    public void logoLinkToMain(){
        open("/order");
        orderScooterPage.clickToLogo()
                .checkUrl();
    }
    @Test
    public void negativeCheck(){
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
