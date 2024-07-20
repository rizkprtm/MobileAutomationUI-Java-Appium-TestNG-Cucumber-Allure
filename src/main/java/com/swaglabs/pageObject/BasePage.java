package com.swaglabs.pageObject;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.swaglabs.utils.TestUtils;
import com.swaglabs.manager.DriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public static AppiumDriver driver;
    static TestUtils utils = new TestUtils();

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void click(WebElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.click();

    }

    public void click(By e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        driver.findElement(e).click();
    }

    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void sendKeys(WebElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }

    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public String getText(WebElement e, String msg) throws IllegalStateException {
        String txt = getAttribute(e, "text");
        utils.log().info(msg + txt);
        return txt;
    }

    public boolean isElementDisplayed(WebElement e) {
        try {
            waitForVisibility(e);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public void swipe(Point start, Point end, Duration duration) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger1, 0);
        swipe.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger1, Duration.ofMillis(100)));
        swipe.addAction(finger1.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(ImmutableList.of(swipe));
    }

    public void scroll(double scrollSpace, String direction) {
        Duration dur = Duration.ofMillis(400);
        Dimension size = driver.manage().window().getSize();
        if (scrollSpace <= 0 || scrollSpace >= 1)
            throw new Error("scrollSpace should be between 0 to 1!");
        System.out.println("Size: " + size);
        Point midPoint = new Point(size.getWidth() / 2, size.getHeight() / 2);
        System.out.println("MidPoint: " + midPoint);
        if (direction.equalsIgnoreCase("down")) {
            Point upPoint = new Point(midPoint.x, (int) (midPoint.y - (midPoint.y) * scrollSpace));
            swipe(new Point(midPoint.x, midPoint.y), new Point(upPoint.x, upPoint.y), dur);

        } else if (direction.equalsIgnoreCase("up")) {
            Point downPoint = new Point(midPoint.x, (int) (midPoint.y + (midPoint.y) * scrollSpace));
            swipe(new Point(midPoint.x, midPoint.y), new Point(downPoint.x, downPoint.y), dur);

        } else if (direction.equalsIgnoreCase("left")) {
            Point downPoint = new Point((int) (midPoint.x + (midPoint.x) * scrollSpace), midPoint.y);
            swipe(new Point(midPoint.x, midPoint.y), new Point(downPoint.x, downPoint.y), dur);

        } else if (direction.equalsIgnoreCase("right")) {
            Point downPoint = new Point((int) (midPoint.x - (midPoint.x) * scrollSpace), midPoint.y);
            swipe(new Point(midPoint.x, midPoint.y), new Point(downPoint.x, downPoint.y), dur);
        }
    }

    public void scrollToView(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"" + text + "\"));"));
    }

    public void scrollUntilVisible(String text, String direction) throws InterruptedException {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                        + text + "\").instance(0))"));
        scroll(.3, direction);
        Thread.sleep(200);
    }
}

