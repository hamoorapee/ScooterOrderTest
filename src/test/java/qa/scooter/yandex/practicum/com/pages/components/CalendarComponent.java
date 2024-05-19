package qa.scooter.yandex.practicum.com.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement datePickerContainerLocator = $(".react-datepicker__input-container input");

    @Step("Установка даты")
    public void setDate(String day, String month, String year) {
        datePickerContainerLocator.click();
        datePickerContainerLocator.append(day + "." + month + "." + year);
        datePickerContainerLocator.sendKeys(Keys.ENTER);
    }

    @Step("Очистка поля ввода даты")
    public void cleanDate() {
        datePickerContainerLocator.doubleClick();
        datePickerContainerLocator.clear();
    }
}


