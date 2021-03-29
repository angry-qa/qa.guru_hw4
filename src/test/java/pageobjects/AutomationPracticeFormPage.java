package pageobjects;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormPage {

    Faker faker = new Faker();

    private String site = "https://demoqa.com/automation-practice-form",
            firstName = faker.name().firstName(),
            lastName  = faker.name().lastName(),
            userEmail = faker.internet().emailAddress();

    public void openPage() {
        open(site);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void fillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#currentAddress").setValue("Saint-Petersburg, Singer House");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
    }

    public void sendForm() {
        $("#submit").click();
    }

    public void checkForm() {
        $(".table").shouldHave(text(firstName),
                text(lastName),
                text(userEmail),
                text("Male"),
                text("0123456789"),
                text("1 January,1980"),
                text("English, Hindi"),
                text("Sports"),
                text("test.png"),
                text("Saint-Petersburg, Singer House"),
                text("NCR Delhi"));
    }

}
