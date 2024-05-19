package qa.scooter.yandex.practicum.com.pages.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement datePickerContainerLocator = $(".react-datepicker__input-container input");
    public void setDate(String day, String month, String year) {
        datePickerContainerLocator.click();
        datePickerContainerLocator.append(day+"."+month+"."+year);
        datePickerContainerLocator.sendKeys(Keys.ENTER);
    }
    public void cleanDate(){
        datePickerContainerLocator.doubleClick();
        datePickerContainerLocator.clear();
    }
}


