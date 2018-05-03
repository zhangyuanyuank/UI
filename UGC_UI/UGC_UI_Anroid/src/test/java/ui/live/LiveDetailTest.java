package ui.live;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import util.BaseUtil;
import util.LoginUtil;
import util.SwipeUtil;

import java.util.Set;

public class LiveDetailTest extends BaseTest {


    @Ignore
    public  void  livedetail_upcome() throws Exception{

        //setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        BaseUtil.sleep();

        //点击store club
        System.out.println("步骤：查看首页数据");
        System.out.println("步骤：fanzone进入live");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALIEXPRESS LIVE\")").click();
        //切换webview模式
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //输出 NATIVE_APP \n WEBVIEW_1

            // 设置当前 context 为 WEBVIEW_1
            if (contextName.contains("WEBVIEW")){
                driver.context(contextName);

            }

        }
        //执行web测试
        driver.findElementById("skip").click();
        driver.context("NATIVE_APP");

        System.out.println("步骤：点击封面，跳到直播detail");
        SwipeUtil.swipeToUp(driver,1000);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"UPCOMING\")").click();
        //driver.findElement(By.id("iv_cover")).click();
        BaseUtil.sleep();

        String live_time= driver.findElement(By.id("tv_count_down")).getText();
        String live_name= driver.findElement(By.id("tv_nick_name")).getText();
        String live_feedback= driver.findElement(By.id("tv_store_feedback")).getText();
        System.out.println("步骤：直播倒计时"+live_time);
        System.out.println("步骤：直播间名称"+live_name);
        System.out.println("步骤：直播间好评"+live_feedback);

        System.out.println("步骤：查看法务文案");
        driver.findElement(By.id("tv_statement")).click();
        String content=driver.findElement(By.id("content")).getText();
        System.out.println("步骤：法务文案"+content);
        driver.findElement(By.id("buttonDefaultPositive")).click();
        BaseUtil.sleep();

        System.out.println("步骤：设置提醒");
        driver.findElement(By.id("tv_remind_action")).click();
        Assert.assertEquals("点击提醒弹出登录异常",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("步骤：点击follow");
        driver.findElement(By.id("btn_follow")).click();
        Assert.assertEquals("点击follow弹出登录异常",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("步骤：点击商品");
        driver.findElement(By.id("riv_product")).click();
        Assert.assertEquals("点击商品跳转detail异常",PRODUCT_DETAIL_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("步骤：加购物车");
        driver.findElement(By.id("rl_add_cart")).click();
        Assert.assertEquals("点击购物车跳转detail异常",PRODUCT_DETAIL_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("步骤：切换到comment");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"COMMENTS\")").click();
        //driver.tap(1,190,365,1000);
        BaseUtil.sleep();
        Assert.assertNotNull("comment为空提示异常","Be the first to write a comment");

        System.out.println("步骤：切换到update");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"UPDATES\")").click();
        BaseUtil.sleep();
        Assert.assertNotNull("comment为空提示异常","Be the first to write a comment");

        System.out.println("步骤：点赞");
        String like_count= driver.findElement(By.id("tv_like_count")).getText();
        System.out.println("步骤：直播间点赞数"+like_count);
        driver.findElement(By.id("iv_like")).click();
        System.out.println("步骤：直播间点赞正常");
        BaseUtil.sleep();
        tearDown();

    }



    @Ignore
    public  void  livedetail_live() throws Exception{

        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        BaseUtil.sleep();

        //点击store club
        System.out.println("步骤：查看首页数据");
        System.out.println("步骤：fanzone进入live");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALIEXPRESS LIVE\")").click();

        System.out.println("步骤：切换到all tab下");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALL\")").click();
        //driver.tap(1,30,380,1000);
        BaseUtil.sleep();

        System.out.println("步骤：点击封面，跳到直播detail");
        driver.scrollTo("UPCOMING").tap(1,1000);
        //driver.findElement(By.id("iv_cover")).click();
        BaseUtil.sleep();

    }



    @Ignore
    public  void  livedetail_again() throws Exception{

        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        BaseUtil.sleep();

        //点击store club
        System.out.println("步骤：查看首页数据");
        System.out.println("步骤：fanzone进入live");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALIEXPRESS LIVE\")").click();

        System.out.println("步骤：切换到all tab下");
        driver.tap(1,76,769,1000);
        BaseUtil.sleep();

        System.out.println("步骤：点击封面，跳到直播detail");
        driver.scrollTo("WATCH AGAIN").tap(1,1000);
        BaseUtil.sleep();

        String live_status= driver.findElement(By.id("tv_live_type")).getText();
        String live_time= driver.findElement(By.id("tv_count_down")).getText();
        String live_name= driver.findElement(By.id("tv_nick_name")).getText();
        String live_feedback= driver.findElement(By.id("tv_store_feedback")).getText();
        String live_number= driver.findElement(By.id("tv_live_watch")).getText();
        System.out.println("步骤：直播状态"+live_status);
        System.out.println("步骤：直播倒计时"+live_time);
        System.out.println("步骤：直播间名称"+live_name);
        System.out.println("步骤：直播间好评"+live_feedback);
        System.out.println("步骤：直播观看人数"+live_number);

        System.out.println("步骤：查看法务文案");
        driver.findElement(By.id("tv_statement")).click();
        String content=driver.findElement(By.id("content")).getText();
        System.out.println("步骤：法务文案"+content);
        driver.findElement(By.id("buttonDefaultPositive")).click();
        BaseUtil.sleep();

        System.out.println("步骤：切换到all tab下");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALL\")").click();
        //driver.tap(1,30,380,1000);
        BaseUtil.sleep();

        System.out.println("步骤：点击follow");
        driver.findElement(By.id("btn_follow")).click();
        Assert.assertEquals("点击follow弹出登录异常",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("步骤：查看play区域");
        driver.findElement(By.id("iv_action_play")).click();
        System.out.println("步骤：播放正常");

    }


}
