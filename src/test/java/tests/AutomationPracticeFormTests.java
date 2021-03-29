package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageobjects.AutomationPracticeFormPage;


public class AutomationPracticeFormTests {

    AutomationPracticeFormPage steps = new AutomationPracticeFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void basicScenario() {
        steps.openPage();
        steps.fillForm();
        steps.sendForm();
        steps.checkForm();

    }

}

