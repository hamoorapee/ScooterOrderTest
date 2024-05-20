package qa.scooter.yandex.practicum.com.ui;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.scooter.yandex.practicum.com.BaseTest;

import static qa.scooter.yandex.practicum.com.ExpectedText.*;

@Epic("UI Автотесты")
public class MainPageTests extends BaseTest {

    @Test
    @DisplayName("Проверка вопросов 'Вопросы о важном'")
    public void importantTasksTest() {
        mainPage.openSection(1)
                .checkTextSection(TEXT_OF_THE_FIRST_SECTION.getText())
                .openSection(2)
                .checkTextSection(TEXT_OF_THE_SECOND_SECTION.getText())
                .openSection(3)
                .checkTextSection(TEXT_OF_THE_THIRD_SECTION.getText())
                .openSection(4)
                .checkTextSection(TEXT_OF_THE_FOURTH_SECTION.getText())
                .openSection(5)
                .checkTextSection(TEXT_OF_THE_FIFTH_SECTION.getText())
                .openSection(6)
                .checkTextSection(TEXT_OF_THE_SIXTH_SECTION.getText())
                .openSection(7)
                .checkTextSection(TEXT_OF_THE_SEVENTH_SECTION.getText())
                .openSection(8)
                .checkTextSection(TEXT_OF_THE_EIGHT_SECTION.getText());
    }
}
