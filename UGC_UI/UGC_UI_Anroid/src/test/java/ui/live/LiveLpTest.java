package ui.live;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import util.LoginUtil;
import util.BaseUtil;
import util.SwipeUtil;

import java.util.Set;

public class LiveLpTest extends BaseTest {

    @Test
    public  void  testlp_entry() throws Exception{

        setUp();
        System.out.println("步骤：查看首页数据");
        System.out.println("步骤：首页live入口");

        //String live_stream=driver.findElementByAndroidUIAutomator("new UiSelector().text(\"LIVE STREAM\")").getText();
//        driver.scrollTo("LIVE STREAM").tap(1,1000);
//        BaseUtil.sleep();
//        driver.sendKeyEvent(4);

        System.out.println("步骤：fanzone中live入口");
        SwipeUtil.swipeToDown(driver,1000);
        SwipeUtil.swipeToDown(driver,1000);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALIEXPRESS LIVE\")").click();
        tearDown();

    }


    @Test
    public  void  testlp() throws Exception{

        setUp();
        BaseUtil.sleep();

        //从fanzone进入lp
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALIEXPRESS LIVE\")").click();
        //driver.tap(1,1209,213,1000);
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

        String store_name=driver.findElement(By.id("tv_nick_name")).getText();
        String language=driver.findElement(By.id("tv_live_lang")).getText();
        String livetime=driver.findElement(By.id("tv_live_start")).getText();
        System.out.println("步骤：直播名称"+store_name);
        System.out.println("步骤：直播语言"+language);
        System.out.println("步骤：直播时间"+livetime);

        driver.findElement(By.id("tv_nick_name")).click();
        System.out.println("步骤：点击名称跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        driver.findElement(By.id("tv_live_lang")).click();
        System.out.println("步骤：点击直播语言跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        driver.findElement(By.id("tv_live_start")).click();
        System.out.println("步骤：点击直播时间跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"All\")").click();
//        System.out.println("步骤：切换lp语言到all正常");
//        BaseUtil.sleep();
//        SwipeUtil.swipeToUp(driver,1000);
        tearDown();

    }


    @Test
    public  void  testlp_showschedule() throws Exception{

        setUp();
        //从fanzone到lp
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALIEXPRESS LIVE\")").click();
        Thread.sleep(6000);
        //driver.tap(1,295,948,1000);
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

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Show Schedule\")").click();
        System.out.println("步骤：Show Schedule跳转正常");
        BaseUtil.sleep();

        driver.findElement(By.id("tv_nick_name")).click();
        try{
            driver.currentActivity().equals(STORE_ACTIVITY);
            System.out.println("步骤：点击名称跳到店铺页");
        }catch (Exception e){
            System.out.println("步骤：点击名称跳到profile页");
        }
        System.out.println("步骤：点击直播名称跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        driver.findElement(By.id("tv_live_lang")).click();
        try{
            driver.currentActivity().equals(STORE_ACTIVITY);
            System.out.println("步骤：点击语言跳到店铺页");
        }catch (Exception e){
            System.out.println("步骤：点击语言跳到profile页");
        }
        System.out.println("步骤：点击直播语言跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        driver.findElement(By.id("tv_live_start")).click();
        try{
            driver.currentActivity().equals(STORE_ACTIVITY);
            System.out.println("步骤：点击时间跳到店铺页");
        }catch (Exception e){
            System.out.println("步骤：点击时间跳到profile页");
        }
        System.out.println("步骤：点击直播时间跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("步骤：show schedule滑动正常");
        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToRight(driver,1000);
        SwipeUtil.swipeToRight(driver,1000);

        tearDown();
    }


    @Test
    public  void  testlp_reply() throws Exception{

        setUp();
        //滑动到live banner页
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALIEXPRESS LIVE\")").click();
        Thread.sleep(6000);
        //driver.tap(1,775,931,1000);
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

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Featured Replay\")").click();
        System.out.println("步骤：feature replay跳转正常");
        driver.findElement(By.id("sp_language")).click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Russian\")").click();
        System.out.println("步骤：latest切换到俄语正常");
        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToUp(driver,1000);
        BaseUtil.sleep();

        SwipeUtil.swipeToLeft(driver,1000);
        System.out.println("步骤：popular跳转正常");
        driver.findElement(By.id("sp_language")).click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Russian\")").click();
        System.out.println("步骤：popular切换到俄语正常");
        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToUp(driver,1000);
        BaseUtil.sleep();

        System.out.println("步骤：点击名称，跳到直播detail");
        BaseUtil.sleep();
        driver.findElement(By.id("tv_nick_name")).click();
        System.out.println("步骤：返回lp页面");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("步骤：点击语言，跳到直播detail");
        BaseUtil.sleep();
        driver.findElement(By.id("tv_live_lang")).click();
        System.out.println("步骤：返回lp页面");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("步骤：点击时间，跳到直播detail");
        BaseUtil.sleep();
        driver.findElement(By.id("tv_live_start")).click();
        System.out.println("步骤：返回lp页面");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("步骤：点击商品，跳转正常");
        driver.findElement(By.id("riv_product")).click();
        BaseUtil.sleep();
        driver.sendKeyEvent(4);

        System.out.println("步骤：点击follow按钮");
        try{
            driver.findElement(By.id("btn_follow")).click();
            WebElement sign=driver.findElement(By.id("btn_sign_in"));
            if(sign !=null){
                LoginUtil.loginApp(driver,"xxxhhh@163.com","hello1234");
                BaseUtil.sleep();
            }

        }catch (Exception e){
            System.out.println("步骤：已经关注");
        }

        SwipeUtil.scroll(driver);
        System.out.println("步骤：feature reply数据正常");

        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToRight(driver,1000);
        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToDown(driver,1000);
        tearDown();

    }

}
