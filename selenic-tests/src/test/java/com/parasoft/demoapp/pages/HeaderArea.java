package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.ElementUtils;
import com.parasoft.demoapp.common.GlobalUtils;
import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class HeaderArea {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='account']")
    public WebElement nickNameInPurchaser;

    @FindBy(xpath = "//*[@id='approver_account']")
    public WebElement nickNameInApprover;

    @FindBy(linkText = "Sign out")
    public WebElement signOutLink;

    @FindBy(xpath = "//*[@id='to_demo_admin_button']/a")
    public WebElement settingButton;

    @FindBy(xpath = "//*[@id='title_text']/a")
    public WebElement titleInPurchaserPage;

    @FindBy(xpath = "//*[@id='title_text']")
    public WebElement titleInApproverPage;

    @FindBy(xpath = "//*[@id='requisition_order_img']")
    public WebElement ordersButton;

    @FindBy(xpath = "//*[@id='right_bar']")
    public WebElement cartButton;

    @FindBy(xpath = "//*[@id='requisition_cross']/div[2]")
    public WebElement closeCart;

    @FindBy(xpath = "//*[@id='requisition_amount']/div[@class='amount_text common_text']/p/span")
    public WebElement quantityInCart;

    @FindBy(xpath = "//*[@id='requisition_order_amount']/div/p/span")
    public WebElement ordersNeedToView;

    public HeaderArea(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void clickSettingButton() {
        ElementUtils.clickElementUseJs(driver,settingButton);
    }

    public void clickOrdersButton() {
        ElementUtils.clickElementUseJs(driver,ordersButton);
    }

    public void openCartPopup() {
        ElementUtils.clickElementUseJs(driver,cartButton);
    }

    public void clickNickNameInPurchaser() throws InterruptedException, AWTException {
        ElementUtils.clickElementUseJs(driver,nickNameInPurchaser);
        GlobalUtils.waiting();
    }

    public void clickNickNameInApprover() throws InterruptedException, AWTException {
        ElementUtils.clickElementUseJs(driver,nickNameInApprover);
        GlobalUtils.waiting();
    }

    public void clickSignOutLink() { ElementUtils.clickElementUseJs(driver,signOutLink); }

    public void closeCartPopup() {
        ElementUtils.clickElementUseJs(driver,closeCart);
    }

    public void clickProductName() {
        ElementUtils.clickElementUseJs(driver,titleInPurchaserPage);
    }
}
