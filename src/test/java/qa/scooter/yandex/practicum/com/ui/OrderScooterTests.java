package qa.scooter.yandex.practicum.com.ui;

import org.junit.jupiter.api.Test;
import qa.scooter.yandex.practicum.com.BaseTest;
import qa.scooter.yandex.practicum.com.pages.OrderScooterPage;

import static com.codeborne.selenide.Selenide.open;

public class OrderScooterTests  extends BaseTest {
    //prepare test data
    //test
    @Test
    public void OrderScooterTest(){
        orderScooterPage.clickHeaderButtonOrder()
                .setFirstName("Николай")
                .setSecondName("Хорошавцев")
                .setAddress("Белинского 111")
                .setSubwayStation("Черкизовская")
                .setNum("999999999999")
                .clickOrderContinue()
                .calendarSetDate("15","03","2002");

        //check

    }

}
