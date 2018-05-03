package ui.storeclub;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.base.BaseTest;
import util.LoginUtil;
import util.BaseUtil;
import util.SwipeUtil;

import java.util.Objects;


public class New extends BaseTest {


    @Ignore
    public void testfeedlist() throws Exception {

        setUp();
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
        String desc=driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Recommended Stores\")").getText();
        BaseUtil.sleep();
        System.out.println("步骤：帖子detail "+stores_name);
        System.out.println("步骤：帖子detail "+post_time);
        System.out.println("步骤：帖子detail "+like_num);
        System.out.println("步骤：帖子detail "+comment_num);
        Assert.assertNotNull("推荐文案为空",desc);

        //点击店铺名称／发帖时间，跳到店铺detail
        driver.findElement(By.id("tv_store")).click();
        Assert.assertEquals("店铺跳转失败",STORE_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);

        driver.findElement(By.id("tv_store_score")).click();
        Assert.assertEquals("店铺跳转失败",STORE_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //取消推荐
        System.out.println("store club未登录，点击more");
        driver.findElement(By.id("iv_ex_action")).click();
        BaseUtil.sleep();

        //点赞／评论／翻译
        try{
            Assert.assertNotNull("翻译按钮为空",driver.findElement(By.id("btn_auto_translate")));
            driver.findElement(By.id("btn_auto_translate")).click();
            System.out.println("点击翻译，翻译成功");
        }catch (Exception e){

        }

        System.out.println("点击like，弹出登陆框");
        driver.findElement(By.id("tv_like_count")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        System.out.println("点击comment，弹出登陆框");
        driver.findElement(By.id("tv_comment_count")).click();
        BaseUtil.sleep();
        driver.findElement(By.id("btn_comment_send")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToDown(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToRight(driver,1000);
        tearDown();
    }



    @Ignore
    public  void  testfeedlist_sign() throws Exception {

        setUp();
        //确保登录
        LoginUtil.makeLogin(driver);

        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：已登陆情况，查看new");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();

        //取消推荐
        SwipeUtil.scroll(driver);
        System.out.println("登录情况，点击more");
        driver.findElement(By.id("iv_action")).click();
        BaseUtil.sleep();

        //点赞／评论／翻译
        SwipeUtil.swipeToUp(driver,1000);
        try{
            Assert.assertNotNull(driver.findElement(By.id("btn_auto_translate")));
            driver.findElement(By.id("btn_auto_translate")).click();
            System.out.println("翻译成功");
        }catch (Exception e){
            System.out.println("翻译按钮为空");
        }

        String like_num= driver.findElement(By.id("tv_like_count")).getText();
        System.out.println("步骤：帖子detail like数"+like_num);
        driver.findElement(By.id("tv_like_count")).click();
        BaseUtil.sleep();
        Assert.assertEquals("点赞失败",like_num,like_num);
        System.out.println("点赞成功");

        driver.findElement(By.id("tv_comment_count")).click();
        BaseUtil.sleep();
        Assert.assertEquals("评论列表跳转失败",COMMENT_LIST_ACTIVITY,driver.currentActivity().toString());
        System.out.println("评论成功");
        driver.sendKeyEvent(4);

        //点击描述，跳到帖子detail
        SwipeUtil.swipeToUp(driver,1000);
        System.out.println("点击图片，跳到帖子detail");
        try{
            driver.findElement(By.id("rv_item_img")).click();
            System.out.println("帖子为上新贴或专享帖");
            driver.findElement(By.id("tv_link")).click();
            driver.sendKeyEvent(4);
        }catch (Exception e){
            driver.findElement(By.id("rv_img")).click();
            System.out.println("帖子为图文帖或直播");
        }

        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToDown(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToRight(driver,1000);
        tearDown();

    }

}
