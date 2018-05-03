package ui.storeclub;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.base.BaseTest;
import util.BaseUtil;
import util.LoginUtil;
import util.SwipeUtil;

public class followTest extends BaseTest {

    @Test
    public void testfollow() throws Exception {

        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：未登录情况，查看new");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"FOLLOWING\")").click();
        BaseUtil.sleep();

        //点击follow
        driver.findElement(By.id("iv_action")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点follow弹登陆框正常 ");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //点击登录
//        Assert.assertNotNull("登录文案显示失败","Login to see more updates from your favorite stores!");
//        System.out.println("步骤：登录文案显示正常");
//        //driver.findElement(By.id("btn_login")).click();
//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"SIGN IN\")").click();
//        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
//        System.out.println("步骤：点击登录按钮，弹登陆框正常");
//        driver.sendKeyEvent(4);
//        BaseUtil.sleep();

//        SwipeUtil.scroll(driver);
//        String stores_name= driver.findElement(By.id("tv_store")).getText();
//        String follow_count= driver.findElement(By.id("tv_store_score")).getText();
//        String like_num= driver.findElement(By.id("tv_item_fav")).getText();
//        String comment_num= driver.findElement(By.id("tv_item_cm")).getText();
//        String title= driver.findElement(By.id("tv_item_title")).getText();
//        BaseUtil.sleep();
//        System.out.println("步骤：帖子名称 "+stores_name);
//        System.out.println("步骤：帖子follow数 "+follow_count);
//        System.out.println("步骤：帖子like数 "+like_num);
//        System.out.println("步骤：帖子comment数 "+comment_num);
//        System.out.println("步骤：帖子标题 "+title);


        tearDown();


    }

}
