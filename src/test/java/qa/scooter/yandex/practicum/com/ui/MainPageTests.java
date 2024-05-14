package qa.scooter.yandex.practicum.com.ui;

import org.junit.jupiter.api.Test;
import qa.scooter.yandex.practicum.com.BaseTest;

import static com.codeborne.selenide.Selenide.open;


public class MainPageTests extends BaseTest {
    //prepare
    //test

    @Test
    public void importantTasksTest() {
        open("/order");
        mainPage.askOpen(1)
                .checkRespond("Сутки — 400 рублей. Оплата курьеру — ")
                .askOpen(2)
                .checkRespond("Пока что у нас так: один заказ — один ")
                .askOpen(3)
                .checkRespond("Допустим, вы оформляете заказ на 8 ма")
                .askOpen(4)
                .checkRespond("Только начиная с завтрашнего дня. Но ")
                .askOpen(5)
                .checkRespond("Пока что нет! Но если что-то срочное —")
                .askOpen(6)
                .checkRespond("Самокат приезжает к вам с полной зарядк")
                .askOpen(7)
                .checkRespond("Да, пока самокат не привезли. Штрафа не")
                .askOpen(8)
                .checkRespond("Да, обязательно. Всем самокатов! И Моск");
    }
}
