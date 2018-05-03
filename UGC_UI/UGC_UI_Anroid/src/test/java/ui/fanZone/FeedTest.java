package ui.fanZone;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import util.LoginUtil;
import util.BaseUtil;
import util.SwipeUtil;
import util.ToastUtil;

import java.util.Set;

public class FeedTest extends BaseTest {

    @Test
    public void testfeed() throws Exception {

        //setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        BaseUtil.sleep();

        //点击store club
        System.out.println("步骤：进入fan zone，查看feed流");
        driver.scrollTo("Fan Zone").tap(1,1000);
        //driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();

        //确保banner不为空

        //确保4个入口不为空
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"BLOGGER PROGRAM\")").click();
        BaseUtil.sleep();
        Assert.assertEquals("造星计划入口跳转异常",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.tap(1,102,174,1000);
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
        driver.sendKeyEvent(4);
        driver.context("NATIVE_APP");
        System.out.println("步骤：造星计划入口跳转正常");
        BaseUtil.sleep();


        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Star Blogger\")").click();
        BaseUtil.sleep();
        Assert.assertEquals("达人秀入口跳转异常",HOME_SPOT_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        System.out.println("步骤：达人秀入口跳转正常");

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"PEOPLE'S FAVORITE\")").click();
        BaseUtil.sleep();
        Assert.assertEquals("人气榜入口跳转异常",PEPOLE_FAVORITE,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        System.out.println("步骤：人气榜入口跳转正常");

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALIEXPRESS LIVE\")").click();
        BaseUtil.sleep();
        //切换webview模式
        for (String contextName : contextNames) {
            System.out.println(contextName); //输出 NATIVE_APP \n WEBVIEW_1

            // 设置当前 context 为 WEBVIEW_1
            if (contextName.contains("WEBVIEW")){
                driver.context(contextName);

            }

        }
        //执行web测试
        BaseUtil.sleep();
//        driver.findElementById("skip").click();
        driver.context("NATIVE_APP");

        BaseUtil.sleep();
        Assert.assertEquals("直播入口跳转异常",LIVELANDING_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：直播入口跳转正常");
        driver.sendKeyEvent(4);

        //发帖按钮
//        Assert.assertNotNull("发帖按钮异常", driver.findElement(By.id("fab_publish")));
//        System.out.println("步骤：发帖按钮正常");
        //点发帖弹登录框
//        driver.findElement(By.id("fab_publish")).click();
//        Assert.assertEquals("点发帖弹登录框异常",LOGIN_ACTIVITY,driver.currentActivity().toString());
//        System.out.println("步骤：点发帖按钮弹登录框正常");
//        driver.sendKeyEvent(4);

//        //登录提示
//        Assert.assertNotNull("登录提示1为空","You are not logged in");
//        Assert.assertNotNull("登录提示2为空","After logging in, you can view new content posted by users you are following");
//        System.out.println("步骤：登录提示正常");
//
//        SwipeUtil.swipeToUp(driver,1000);
//        //推荐文案
//        String text=driver.findElement(By.id("tv_recommend_title")).getText();
//        System.out.println("步骤：推荐文案"+text);
//        driver.findElement(By.id("tv_recommend_title")).click();
//        Assert.assertEquals("推荐跳转错误",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
//        driver.sendKeyEvent(4);
//        BaseUtil.sleep();

        //点击用户头像
        SwipeUtil.scroll(driver);
        driver.findElement(By.id("iv_user_img")).click();
        Assert.assertEquals("点击帖子头像跳profile失败",PROFILE_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        System.out.println("步骤：帖子头像跳转正常");

        //点击帖子
        driver.findElement(By.id("iv_post_main_pic")).click();
        Assert.assertEquals("点击帖子跳转正常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);

        //点赞／评论／follow
        driver.findElement(By.id("tv_comment_count")).click();
        BaseUtil.sleep();
        driver.findElement(By.id("btn_comment_send")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        System.out.println("点击comment，弹登陆框正常");

        driver.findElement(By.id("tv_like_count")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        System.out.println("点击like，弹出登陆框正常");

        SwipeUtil.swipeToUp(driver,1000);
        driver.findElement(By.id("iv_add_follow")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击follow，弹登陆框正常");
        driver.sendKeyEvent(4);
        SwipeUtil.swipeToUp(driver,1000);

        for(int i=0;i<3;i++){
            SwipeUtil.scroll(driver);
        }
        tearDown();

    }


    @Test
    public void testfeedsign() throws Exception {

        setUp();
        //确保登录
        LoginUtil.makeLogin(driver);
        BaseUtil.sleep();

        //点击store club
        System.out.println("步骤：进入fan zone");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();

        //发帖按钮
        Assert.assertNotNull("发帖按钮异常", driver.findElement(By.id("fab_publish")));
        System.out.println("步骤：发帖按钮正常");

        //获取用户信息
        SwipeUtil.swipeToUp(driver,1000);
        String name=driver.findElement(By.id("tv_user_name")).getText();
        BaseUtil.sleep();
        System.out.println("步骤：用户昵称"+name);

        //点击帖子
        driver.findElement(By.id("iv_post_main_pic")).click();
        Assert.assertEquals("点击帖子跳转正常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);

        //点赞／评论
        String like_num= driver.findElement(By.id("tv_like_count")).getText();
        System.out.println("步骤：帖子detail like数"+like_num);
        driver.findElement(By.id("tv_like_count")).click();
        //ToastUtil.toast("You've liked too many post.Please wait and try again later.[8002501_1]");
        System.out.println("点赞成功");

        driver.findElement(By.id("tv_comment_count")).click();
        BaseUtil.sleep();
        Assert.assertEquals("评论列表跳转失败",COMMENT_LIST_ACTIVITY,driver.currentActivity().toString());
        System.out.println("评论成功");
        driver.sendKeyEvent(4);
        tearDown();

    }

    @Test
    public void testpopualr() throws Exception {

        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        BaseUtil.sleep();

        //点击store club
        System.out.println("步骤：进入fan zone，查看feed流");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();

        //popular
        SwipeUtil.swipeToUp(driver,1000);
        String pop_title=driver.findElement(By.id("tv_popular_title")).getText();
        String pop_desc=driver.findElement(By.id("tv_popular_desc")).getText();
        System.out.println("步骤：popular标题"+pop_title);
        System.out.println("步骤：popular描述"+pop_desc);
        driver.findElement(By.id("tv_view_more")).click();
        BaseUtil.sleep();
        //查看popular列表
        String post_desc=driver.findElement(By.id("tv_content")).getText();
        String post_name=driver.findElement(By.id("tv_usr_name")).getText();
        System.out.println("步骤：popular列表帖子描述"+post_desc);
        System.out.println("步骤：popular列表用户昵称"+post_name);
        driver.findElement(By.id("riv_post_img")).click();
        Assert.assertEquals("点击帖子跳转正常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //点评论
        driver.findElement(By.id("tv_comment_count")).click();
        Assert.assertEquals("跳到detail异常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点评论跳到帖子detail正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        driver.findElement(By.id("avatar")).click();
        Assert.assertEquals("跳到detail异常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点头像跳到帖子detail正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //点like
        driver.findElement(By.id("tv_like_count")).click();
        Assert.assertEquals("跳到detail异常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击like，弹出登陆框正常");
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        for(int i=0;i<3;i++){
            SwipeUtil.scroll(driver);
        }
        tearDown();
    }

}


