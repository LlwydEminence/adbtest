package ru.nemchinov.main;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class InstagramRouter {

    private final AndroidDriver<AndroidElement> driver;
    private final WebDriverWait wait;

    InstagramRouter(
            AndroidDriver<AndroidElement> driver,
            WebDriverWait wait
    ) {
        this.driver = driver;
        this.wait = wait;
    }

    void goToTargetAccountPage(String targetAccount) {
        waitAndClickElement(AndroidLocatorRepository.FIND_ICON_XPATH);
        waitAndPutTextToElement(
                AndroidLocatorRepository.ACTION_BAR_SEARCH_EDIT_TEXT_XPATH, targetAccount
        );

        List<AndroidElement> userNameElements =
                waitAndFindElements(
                        AndroidLocatorRepository.ROW_SEARCH_USER_USERNAME_XPATH
                );
        for (AndroidElement userNameElement : userNameElements) {
            if (targetAccount.equals(userNameElement.getText())) {
                userNameElement.click();
                break;
            }
        }
    }

    private void waitElement(
            String elementXPath
    ) {
        wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath(elementXPath)
                )
        );
    }

    private void waitAndClickElement(
            String elementXPath
    ) {
        waitElement(elementXPath);
        driver.findElementByXPath(elementXPath).click();
    }

    private void waitAndPutTextToElement(
            String elementXPath,
            String text
    ) {
        waitElement(elementXPath);
        AndroidElement element = driver.findElementByXPath(elementXPath);
        element.click();
        element.sendKeys(text);

    }

    private AndroidElement waitAndFindElement(
            String elementXPath
    ) {
        waitElement(elementXPath);
        return driver.findElementByXPath(elementXPath);
    }

    private List<AndroidElement> waitAndFindElements(
            String elementPath
    ) {
        waitElement(elementPath);
        return driver.findElementsByXPath(elementPath);
    }

    private void openLastPhoto(
            AppiumDriver driver,
            WebDriverWait wait
    ) {
        WebElement accountPhotoContainer =
                waitAndFindElement(
                        AndroidLocatorRepository.MEDIA_SET_ROW_CONTENT_IDENTIFIER_XPATH
                );

        accountPhotoContainer.findElements(
                By.className(AndroidLocatorRepository.IMAGE_VIEW_CLASS_NAME)
        ).get(0).click();
    }

    private void putLikeOnPhoto(
    ) {
        waitAndClickElement(AndroidLocatorRepository.ROW_FEED_BUTTON_LIKE_XPATH);
    }

    void subscribe() throws InterruptedException {
        Thread.sleep(2000);
        waitAndClickElement(AndroidLocatorRepository.ROW_PROFILE_HEADER_BUTTON_FOLLOW);
    }

    private void goToCurrentAccountPage() {
        waitAndClickElement(AndroidLocatorRepository.PROFILE_ICON_XPATH);
    }

    String getCurrentAccount() {
        goToCurrentAccountPage();
        AndroidElement spinner = waitAndFindElement(AndroidLocatorRepository.SPINNER_XPATH);
        return spinner.findElementByXPath(AndroidLocatorRepository.ROW_USER_TEXTVIEW_XPATH).getText();
    }

    String changeAccount(LinkedList<String> availableAccounts) throws InterruptedException {
        waitAndClickElement(AndroidLocatorRepository.PROFILE_ICON_XPATH);
        AndroidElement spinner = waitAndFindElement(AndroidLocatorRepository.SPINNER_XPATH);
        String previousAccount
                = spinner.findElementByXPath(
                AndroidLocatorRepository.ROW_USER_TEXTVIEW_XPATH
        ).getText();
        spinner.click();
        List<AndroidElement> accounts = waitAndFindElements(AndroidLocatorRepository.ROW_USER_TEXTVIEW_XPATH);

        for (AndroidElement account : accounts) {
            String accountName = account.getText();
            if (availableAccounts.contains(accountName) && !accountName.equals(previousAccount)) {
                account.click();
                break;
            }
        }
        Thread.sleep(3000);
        return previousAccount;
    }

    void finishWork() {
        driver.closeApp();
        driver.quit();
    }
}
