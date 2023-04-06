import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class AuthTest {
    @Test
    @Severity(CRITICAL)
    @Owner("AngelinaYa97")
    public void shouldAuthorizeTest() {
        step("Открыть страницу https://github.com/", () -> {
            open("https://github.com/");
            $(".h0-mktg").shouldBe(Condition.visible);
        });
        step("Кликнуть на кнопку Sign in", () -> {
            $("[href='/login']").click();
            $("[id=login]").shouldBe(Condition.visible);
        });
        step("Заполнить инпуты логина и пароля", () -> {
            $("[id='login_field']").sendKeys("AngelinaYa97");
            $("[id='password']").sendKeys("ang43");
        });
        step("Кликнуть на кнопку Sign in", () -> {
            $(".js-sign-in-button").click();
            $("[id='global-nav']").shouldBe(Condition.visible);
        });
        step("Кликнуть по миниатюре аватарки", () -> {
            $("[aria-label='View profile and more']").click();
            $("[href='/AngelinaYa97?tab=repositories']")
                    .shouldBe(Condition.visible);
        });
        step("Кликнуть по Your profile", () -> {
            $(byText("Your profile")).click();
            $(".p-name").shouldBe(Condition.visible);
        });
    }
}