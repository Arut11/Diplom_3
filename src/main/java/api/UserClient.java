package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static constants.Url.*;
import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

    @Step("Создание курьера")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(AUTH_REGISTER_URL)
                .then();

    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
        given()
                .header("authorization", accessToken)
                .spec(getBaseSpec())
                .when()
                .delete(AUTH_USER_URL);
    }

    public ValidatableResponse login(UserCredentials credentials) {
        return
                given()
                        .spec(getBaseSpec())
                        .body(credentials)
                        .when()
                        .post(AUTH_LOGIN_URL)
                        .then();

    }

    @Step("Получение токена пользователя")
    public String getAccessToken(ValidatableResponse validatableResponse) {
        return validatableResponse
                .extract()
                .path("accessToken");
    }

    @Step("Удаление возможных пользователей после тестирования")
    public void deletingUsersAfterTests(String accessToken) {
        if (accessToken != null) {
            deleteUser(accessToken);
        } else {
            given().spec(getBaseSpec())
                    .when()
                    .delete(AUTH_USER_URL);
        }
    }

}
