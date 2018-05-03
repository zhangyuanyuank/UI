package ui.storeclub;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.base.BaseTest;
import util.BaseUtil;
import util.LoginUtil;
import util.SwipeUtil;

public class DailyTest  extends BaseTest {

    @Test
    public void testfeed() throws Exception {
        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：未登录情况，查看new");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();

        //点击第二个tab
        driver.findElement(By.id("rv_item_img2")).click();
        Assert.assertNotNull("点击编辑精选跳转失败","Editor's picks");
        BaseUtil.sleep();
        driver.sendKeyEvent(4);

        //点击tab
        driver.findElement(By.id("rv_item_img")).click();
        BaseUtil.sleep();
        String item_reason= driver.findElement(By.id("tv_item_reason")).getText();
        System.out.println("步骤：帖子推荐理由 "+item_reason);

        String stores_name= driver.findElement(By.id("tv_store")).getText();
        String follow_count= driver.findElement(By.id("tv_store_score")).getText();
        String like_num= driver.findElement(By.id("tv_item_fav")).getText();
        String comment_num= driver.findElement(By.id("tv_item_cm")).getText();
        String title= driver.findElement(By.id("tv_item_title")).getText();
        BaseUtil.sleep();
        System.out.println("步骤：帖子名称 "+stores_name);
        System.out.println("步骤：帖子follow数 "+follow_count);
        System.out.println("步骤：帖子like数 "+like_num);
        System.out.println("步骤：帖子comment数 "+comment_num);
        System.out.println("步骤：帖子标题 "+title);

        //点击follow
        driver.findElement(By.id("iv_action")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点follow弹登陆框正常 ");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        SwipeUtil.scroll(driver);
        driver.scrollTo("Be sure to come back tomorrow, we have more recommended stores coming your way!");
        System.out.println("步骤：滑动到底部 ");

        //点击图片
        driver.findElement(By.id("rv_item_img")).click();
        Assert.assertEquals("帖子detail失败",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点击图片，跳到帖子detail正常 ");
        SwipeUtil.swipeToUp(driver,1000);
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        tearDown();


    }
}
