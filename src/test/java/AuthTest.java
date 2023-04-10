import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class AuthTest {

    @BeforeEach
    public void before() {
        open("https://github.com/");
        $(".h0-mktg").shouldBe(visible);
    }
    @Test
    @Severity(CRITICAL)
    @Owner("AngelinaYa97")
    public void shouldAuthorizeTest() {

        step("Перейти в модалку авторизации пользователя", () -> {
            $("[href='/login']")
                    .click();
            $("[id=login]")
                    .shouldBe(visible);
        });

        step("Ввести данные в инпуты логина и пароля", () -> {
            $("[id='login_field']")
                    .sendKeys("AngelinaYa97");
            $("[id='password']")
                    .sendKeys("ang43");
        });

        step("Перейти в личный кабинет гитхаба", () -> {
            $(".js-sign-in-button")
                    .click();
            $("[id='global-nav']")
                    .shouldBe(visible);
            $("[aria-label='View profile and more']")
                    .click();
            $("[href='/AngelinaYa97?tab=repositories']")
                    .shouldBe(visible);
        });

        step("Перейти на страницу своего профиля в гитхабе", () -> {
            $(byText("Your profile"))
                    .click();
            $(".p-name")
                    .shouldBe(visible);
        });
    }
}