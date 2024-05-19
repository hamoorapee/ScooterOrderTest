package qa.scooter.yandex.practicum.com.ui;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.scooter.yandex.practicum.com.BaseTest;

public class MainPageTests extends BaseTest {

    @Test
    @DisplayName("Проверка вопросов 'Вопросы о важном'")
    @Description("Проверка выпадающих значений из вопросов после клика и корректность их содержания")
    public void importantTasksTest() {
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
