package pages;

import AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/div[2]")
    private WebElement header;

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/div[2]/div[1]/div/div/nav/a[3]")
    private WebElement businessButton;

    @FindBy(xpath = "//*[@id=\"2--tabpanel-0\"]/img")
    private WebElement actualTable;

    @FindBy(xpath = "//*[@id=\"6\"]/div/a")
    private WebElement actualTableMoreButton;

    @FindBy(xpath = "//*[@id=\"102\"]/div")
    private WebElement recommended;

    @FindBy(xpath = "//*[@id=\"102\"]/div/a[1]")
    private WebElement recommendedInternetBank;

    @FindBy(xpath = "//*[@id=\"1\"][2]")
    private WebElement footer;

    public MainPage() {
        driver.get("https://bspb.ru/");
        PageFactory.initElements(driver, this);
    }

    public Boolean loadedCorrectly() {
        Boolean isHeaderDisplayed = header.isDisplayed();
        Boolean isActualTableDisplayed = actualTable.isDisplayed();
        Boolean isRecommendedDisplayed = recommended.isDisplayed();
        Boolean isFooterDisplayed = footer.isDisplayed();
        return isHeaderDisplayed & isActualTableDisplayed & isRecommendedDisplayed & isFooterDisplayed;
    }

    public InternetBankPage goToInternetBank() {
        recommendedInternetBank.click();
        return new InternetBankPage();
    }

    public ForBusinessPage goToForBusiness(){
        businessButton.click();
        return new ForBusinessPage();
    }
}
