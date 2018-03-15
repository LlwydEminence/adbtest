package ru.nemchinov.main;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface AppiumTaskPerformer<T extends Performable> {
    String APP_PACKAGE = "com.instagram.android";
    String APP_ACTIVITY = ".activity.MainTabActivity";

    default InstagramRouter createInstagramRouter(Device device) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = createAndroidDriver(device);
        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(60));
        return new InstagramRouter(driver, wait);
    }

    default AndroidDriver<AndroidElement> createAndroidDriver(Device device) throws MalformedURLException {
        final DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.NO_RESET, "true");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "any");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.getPlatformVersion());
        caps.setCapability(MobileCapabilityType.UDID, device.getUdid());
        caps.setCapability("appPackage", APP_PACKAGE);
        caps.setCapability("appActivity", APP_ACTIVITY);

        String url = "http://127.0.0.1:" + device.getServerPort() + "/wd/hub";
        return new AndroidDriver<>(new URL(url), caps);
    }

    default boolean wasAccountChanged(InstagramRouter router, LinkedList<String> waitedAccounts)
            throws InterruptedException {
        if (waitedAccounts.size() == 1) {
            return false;
        }

        String previousAccount = router.changeAccount(waitedAccounts);
        waitedAccounts.remove(previousAccount);
        return true;
    }

    void perform(T task);
}
