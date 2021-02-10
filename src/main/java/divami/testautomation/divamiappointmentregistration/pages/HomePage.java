package divami.testautomation.divamiappointmentregistration.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import divami.testautomation.divamiappointmentregistration.properties.Environment;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePage extends AbstractPage<HomePage> {

    @FindBy(className = "h000-mktg")
    private WebElement slogan;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the Github homepage")
    @Override
    protected void load() {
        driver.get(Environment.getProperties().url());
    }

    @Override
    protected void isLoaded() throws Error {
        assertThat(driver.getTitle()).isEqualTo("The world’s leading software development platform · GitHub");
    }

    @Step("Get slogan text")
    public String getSloganText() {
        return slogan.getText();
    }


}
