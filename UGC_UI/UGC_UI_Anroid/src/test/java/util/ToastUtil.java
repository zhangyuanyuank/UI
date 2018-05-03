package util;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.base.BaseTest;

public class ToastUtil extends BaseTest {
    public static boolean toast(String toast) {
        try {
            final WebDriverWait wait = new WebDriverWait(driver, 3);
            Assert.assertNotNull(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'" + toast + "')]"))));
            System.out.println("查找toast成功！");
            return true;

        } catch (Exception e) {

            throw new AssertionError("找不到"+ toast);
        }
    }

}
