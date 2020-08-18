package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class GoogleTests {
    @Test
    void selenideSearchTest() {
        // Открыть google
        open("https://google.com");

        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("ru.selenide.org"));
    }

    @Test
    void picturePageShouldOpenTest() {
        // Открыть google
        open("https://google.com");

        // Нажать вкладку "Картинки"
        // $("[data-pid='2']").click(); //обращение по кастомному атрибуту
        $(by("data-pid", "2")).click();
        $(byText("Картинки")).click();

        // Проверить наличие заголовка "Картинки Google"
        // $("[title='Картинки Google']").shouldBe(visible); //обращение по атрибуту
        $(byTitle("Картинки Google")).shouldBe(visible);
    }

    @Test
    void googleApplicationsPopupShouldBeExpandedTest() {
        // Открыть google
        open("https://google.com");

        // Нажать на ссылку выпадающего списка "Приложения Google"
        $(byTitle("Приложения Google")).click(); //обращение по CSS-селектору, полученному из XPath

        // Проверить видимость выпадающего списка "Приложения Google"
        $("iframe[role='presentation']").shouldBe(enabled); //обращение по CSS-селектору, полученному из XPath
    }

    @Test
    void yandexUnitFrameShouldOpen() {
        // Открыть yandex
        open("https://yandex.ru");

        // Нажать на ссылку "Настройка"
        $(byText("Настройка")).click(); //обращение по содержимому тега a

        // Нажать пункт "Настроить блоки"
        $(byText("Настроить блоки")).click(); //обращение по содержимому тега span

        // Проверить открытие окна "Блоки на странице"
        $(".hidden-blocks-popup__inside").shouldBe(enabled); //обращение по имени класса
    }
}
