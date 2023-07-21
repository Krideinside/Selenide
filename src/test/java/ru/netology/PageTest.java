package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class PageTest {
    @Test
    void shouldTest()  {
        open("http://0.0.0.0:9999");
        SelenideElement form = $("[data-test-id=form-action]");
        form.$("[data-test-id=name] input").setValue("Александр Труфманов");
        form.$("[data-test-id=phone] input").setValue("+79262627815");
        form.$("[data-test-id=agreement]").click();
        form.$("[data-test-id=submit]").click();
        $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
