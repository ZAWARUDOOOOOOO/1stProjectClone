import AbstractClasses.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

public class MainPageTest extends BaseSeleniumTest {
    private MainPage mainPage;

    @Before
    public void init() {
        mainPage = new MainPage();
    }

    @Test
    public void checkMainPageLoading() {
        Boolean isMainPageLoaded = mainPage.loadedCorrectly();
        Assert.assertTrue(isMainPageLoaded);
    }

    @Test
    public void checkForBusinessButton() {
        Boolean displayedCorrectly = mainPage.goToForBusiness()
                .isBusinessCardOffered();
        Assert.assertTrue(displayedCorrectly);
    }

    @Test
    public void checkCardOffers() {

    }

    @Test
    public void checkInternetBankButton() {
        Boolean displayedCorrectly = mainPage.goToInternetBank()
                .loginButtonDisplayed();
        Assert.assertTrue(displayedCorrectly);
    }


}
