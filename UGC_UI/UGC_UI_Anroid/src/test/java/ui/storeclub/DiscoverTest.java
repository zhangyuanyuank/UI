package ui.storeclub;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.base.BaseTest;
import util.BaseUtil;
import util.LoginUtil;
import util.SwipeUtil;

import java.util.Objects;

public class DiscoverTest  extends BaseTest {

    @Test
    public void testdiscover() throws Exception {

        //setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);

        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：未登录情况，查看new");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();

        //获取官方帖子
        String stores_name= driver.findElement(By.id("tv_store")).getText();
        if(Objects.equals(stores_name, "Store Club Official Account")){
            System.out.println("第一个帖子为官方帐号图文帖");
            BaseUtil.sleep();
        }else{
            System.out.println("没有官方帐号帖子");
            BaseUtil.sleep();
        }

        //获取feed 帖子数据
        SwipeUtil.scroll(driver);
        String post_time= driver.findElement(By.id("tv_store_score")).getText();
        String like_num= driver.findElement(By.id("tv_like_count")).getText();
        String comment_num= driver.findElement(By.id("tv_comment_count")).getText();
        BaseUtil.sleep();
        System.out.println("步骤：帖子detail "+stores_name);
        System.out.println("步骤：帖子detail "+post_time);
        System.out.println("步骤：帖子detail "+like_num);
        System.out.println("步骤：帖子detail "+comment_num);


        //点击店铺名称／发帖时间，跳到店铺detail
        driver.findElement(By.id("tv_store")).click();
        Assert.assertEquals("店铺跳转失败",STORE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点击店铺名称跳转成功 ");
        driver.sendKeyEvent(4);

        driver.findElement(By.id("tv_store_score")).click();
        Assert.assertEquals("店铺跳转失败",STORE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点击店铺发帖时间跳转成功 ");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //点赞／评论／翻译
        try{
            Assert.assertNotNull("翻译按钮为空",driver.findElement(By.id("btn_auto_translate")));
            driver.findElement(By.id("btn_auto_translate")).click();
            System.out.println("点击翻译，翻译成功");
        }catch (Exception e){
            System.out.println("无翻译按钮");
        }

        System.out.println("点击comment，弹出登陆框");
        driver.findElement(By.id("tv_comment_count")).click();
        BaseUtil.sleep();
        driver.findElement(By.id("btn_comment_send")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击评论，弹登陆框正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        BaseUtil.sleep();


        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToDown(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToRight(driver,1000);
        //tearDown();

    }

    @Test
    public void testdiscover_sign() throws Exception {

        //setUp();
        //确保登录
        LoginUtil.makeLogin(driver);

        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：已登陆情况，查看new");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();

        //获取feed 帖子数据
        SwipeUtil.scroll(driver);
        String stores_name= driver.findElement(By.id("tv_store")).getText();
        String post_time= driver.findElement(By.id("tv_store_score")).getText();
        String like_num= driver.findElement(By.id("tv_like_count")).getText();
        String comment_num= driver.findElement(By.id("tv_comment_count")).getText();
        BaseUtil.sleep();
        System.out.println("步骤：帖子detail "+stores_name);
        System.out.println("步骤：帖子detail "+post_time);
        System.out.println("步骤：帖子detail "+like_num);
        System.out.println("步骤：帖子detail "+comment_num);


        //点击店铺名称／发帖时间，跳到店铺detail
        driver.findElement(By.id("tv_store")).click();
        Assert.assertEquals("店铺跳转失败",STORE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点击店铺名称跳转成功 ");
        driver.sendKeyEvent(4);

        driver.findElement(By.id("tv_store_score")).click();
        Assert.assertEquals("店铺跳转失败",STORE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点击店铺发帖时间跳转成功 ");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("点击like，弹出登陆框");
        driver.findElement(By.id("tv_like_count")).click();
        BaseUtil.sleep();

        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToDown(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToRight(driver,1000);
        //tearDown();
    }
}
