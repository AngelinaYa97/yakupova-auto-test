import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AuthTest {

    @Test
    public void shouldAuthorizeTest(){
    //1. Открыть страницу https://github.com/
        open("https://github.com/");
    //2. Кликнуть на кнопку Sign in
        $("[href='/login']").click();
    //3. Заполнить инпуты логина и пароля
        $("[id='login_field']").sendKeys("AngelinaYa97");
        $("[id='password']").sendKeys("hdf453");
    //4. Кликнуть на кнопку Sign in
        $(".js-sign-in-button").click();
    //5. Проверить авторизацию
        $("[id='global-nav']").shouldBe(Condition.visible);
    //6. Кликнуть по миниатюре аватарки
        $("[aria-label='View profile and more']").click();
    //7. Кликнуть по Your profile
        $(byText("Your profile")).click();
    //8. Проверить переход на страницу профиля
        $(".p-name").shouldBe(Condition.visible);
        sleep(2000);
}
}
