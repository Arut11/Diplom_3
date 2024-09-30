package constants;

import com.github.javafaker.Faker;

public class RandomData {

    public static Faker faker = new Faker();

    public static String RANDOM_EMAIL = faker.internet().emailAddress();
    public static String RANDOM_PASS = faker.internet().password();
    public static String RANDOM_PASS_5 = faker.internet().password(4,5);
    public static String RANDOM_NAME = faker.name().firstName();

}
