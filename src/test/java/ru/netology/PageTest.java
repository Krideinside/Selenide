package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class PageTest {

    @Test
    void shouldTest()  {
        open("http://localhost:9999");
        SelenideElement form = $("[.form]");
        form.$("[data-test-id=name] input").setValue("Александр Труфманов");
        form.$("[data-test-id=phone] input").setValue("+79262627815");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
