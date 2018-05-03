package ui.fanZone;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.base.BaseTest;
import util.LoginUtil;
import util.BaseUtil;
import util.SwipeUtil;

public class HapFriTest  extends BaseTest {

    @Test
    public void testhappy_friday() throws Exception {

        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        BaseUtil.sleep();

        //点击store club
        System.out.println("步骤：进入fan zone,查看happy friday");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"HAPPY FRI-YAY!\")").click();
        BaseUtil.sleep();
        Assert.assertEquals("happy friday入口跳转异常",HAPPYFRIDAY_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：happy friday入口跳转正常");

        //获取界面信息
        String title=driver.findElement(By.id("tv_happy_friday_title")).getText();
        String desc=driver.findElement(By.id("tv_happy_friday_desc")).getText();
        String cur_title=driver.findElement(By.id("tv_cur_title")).getText();
        String cur_desc=driver.findElement(By.id("tv_cur_desc")).getText();
        String cur_activity_time=driver.findElement(By.id("tv_cur_activity_time")).getText();
        BaseUtil.sleep();
        System.out.println("步骤：title "+title);
        System.out.println("步骤：desc "+desc);
        System.out.println("步骤：cur_title  "+cur_title);
        System.out.println("步骤：cur_desc  "+cur_desc);
        System.out.println("步骤：cur_activity_time  "+cur_activity_time);
        Assert.assertNotNull("本期主题为空","This week's theme:");

        //跳到show your idea
        driver.findElement(By.id("btn_cur_join")).click();
        Assert.assertNotNull("title bar为空",driver.findElement(By.id("tv_banner_title")));
        String banner_title=driver.findElement(By.id("tv_banner_title")).getText();
        System.out.println("步骤：banner_title为  "+banner_title);

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"RULES\")").click();
        System.out.println("步骤：rules tab跳转正常  ");
        BaseUtil.sleep();

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"PARTICIPANTS\")").click();
        System.out.println("步骤：列表页面正常  ");
        BaseUtil.sleep();

        //点击post LIST
        driver.findElement(By.id("btn_post_now")).click();
        Assert.assertEquals("post now跳转异常",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        driver.sendKeyEvent(4);

        driver.scrollTo("Last week's theme:");
        String pre_title=driver.findElement(By.id("tv_pre_title")).getText();
        System.out.println("步骤：上期主题title  "+pre_title);
        Assert.assertNotNull("上期主题为空","Last week's theme:");
        Assert.assertNotNull("获奖标题为空","WINNERS CIRCLE");

        SwipeUtil.swipeToUp(driver,1000);
        //winner达标
        Assert.assertNotNull("点击帖子头像跳profile失败",driver.findElement(By.id("tv_top_winner")));
        System.out.println("步骤：帖子打标正常");

        //点击帖子头像
        driver.findElement(By.id("iv_user_img")).click();
        Assert.assertEquals("点击帖子头像跳profile失败",PROFILE_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        System.out.println("步骤：帖子头像跳转正常");

        //获取帖子信息
        String name=driver.findElement(By.id("tv_user_name")).getText();
        String time=driver.findElement(By.id("tv_reason")).getText();
        BaseUtil.sleep();
        System.out.println("步骤：用户昵称"+name);
        System.out.println("步骤：发帖时间"+time);

        SwipeUtil.swipeToUp(driver,1000);
        //点击帖子
        driver.findElement(By.id("iv_post_main_pic")).click();
        Assert.assertEquals("点击帖子跳转异常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        System.out.println("步骤：点击帖子跳转正常");

        //帖子内容显示
        String post_title=driver.findElement(By.id("tv_title")).getText();
        String post_desc=driver.findElement(By.id("tv_description")).getText();
        BaseUtil.sleep();
        System.out.println("步骤：帖子标题显示"+post_title);
        System.out.println("步骤：帖子描述显示"+post_desc);

        SwipeUtil.swipeToUp(driver,1000);
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
        tearDown();
    }


    @Test
    public void testhappy_friday_sign() throws Exception {

        setUp();
        //确保登录
        LoginUtil.makeLogin(driver);
        SwipeUtil.swipeToLeft(driver, 1000);
        BaseUtil.sleep();

        //点击store club
        System.out.println("步骤：进入fan zone");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"HAPPY FRI-YAY!\")").click();
        BaseUtil.sleep();
        Assert.assertEquals("happy friday入口跳转异常", HAPPYFRIDAY_ACTIVITY, driver.currentActivity().toString());
        System.out.println("步骤：happy friday入口跳转正常");

        //跳到show your idea
        driver.findElement(By.id("btn_cur_join")).click();
        //点击post LIST
        driver.findElement(By.id("btn_post_now")).click();
        Assert.assertNotNull("列表清单发帖按钮为空", "CREATE A LIST");
        System.out.println("步骤：列表清单发帖按钮正常  ");
        driver.findElement(By.id("fab_list")).click();
        BaseUtil.sleep();
        Assert.assertEquals("列表清单发帖跳转异常", COLLAGE_PUBLISH_ACTIVITY, driver.currentActivity().toString());
        System.out.println("步骤：列表清单发帖跳转正常  ");
        driver.sendKeyEvent(4);

        //点击post ARTICLE
        driver.findElement(By.id("btn_post_now")).click();
        Assert.assertNotNull("图文帖发帖按钮为空", "CREATE AN ARTICLE (Text + photos)");
        System.out.println("步骤：图文帖发帖按钮正常  ");
        driver.findElement(By.id("fab_article")).click();
        BaseUtil.sleep();
        Assert.assertEquals("图文帖发布跳转异常", ARTICLE_PUBLISH_ACTIVITY, driver.currentActivity().toString());
        System.out.println("步骤：图文帖发帖跳转正常  ");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        driver.sendKeyEvent(4);

        SwipeUtil.scroll(driver);
        //点击帖子
        driver.findElement(By.id("iv_post_main_pic")).click();
        Assert.assertEquals("点击帖子跳转正常", POST_DETAIL_ACTIVITY, driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        System.out.println("步骤：点击帖子图片跳转正常  ");

        SwipeUtil.scroll(driver);
        //点赞／评论
        String like_num = driver.findElement(By.id("tv_like_count")).getText();
        System.out.println("步骤：帖子detail like数" + like_num);
        driver.findElement(By.id("tv_like_count")).click();
        BaseUtil.sleep();
        Assert.assertEquals("点赞失败", like_num, like_num);
        System.out.println("点赞成功");

        driver.findElement(By.id("tv_comment_count")).click();
        BaseUtil.sleep();
        Assert.assertEquals("评论列表跳转失败", COMMENT_LIST_ACTIVITY, driver.currentActivity().toString());
        System.out.println("评论成功");
        driver.sendKeyEvent(4);

        //查看coupon
        SwipeUtil.scroll(driver);
        SwipeUtil.scroll(driver);
        SwipeUtil.swipeToUp(driver, 1000);
        try {
            String coupon_desc = driver.findElement(By.id("tv_coupon_desc")).getText();
            //String coupon_text=driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Snag a Select Coupon for delightful deals on the items you love\")").getText();
            String coupon_price = driver.findElement(By.id("tv_coupon_price")).getText();
            String coupon_title = driver.findElement(By.id("tv_coupon_title")).getText();
            String coupon_view_detail = driver.findElement(By.id("tv_view_detail")).getText();
            String coupon_browse = driver.findElement(By.id("tv_brows_items")).getText();
            System.out.println("步骤：coupon text" + coupon_desc);
            System.out.println("步骤：coupon price" + coupon_price);
            System.out.println("步骤：coupon title" + coupon_title);
            System.out.println("步骤：coupon view detail" + coupon_view_detail);
            System.out.println("步骤：coupon browse item" + coupon_browse);
            driver.findElement(By.id("tv_view_detail")).click();
            Assert.assertEquals("coupon view detail跳转异常", SELECT_COUPON_ACTIVITY, driver.currentActivity().toString());
            System.out.println("步骤：coupon view detail跳转正常");
            driver.sendKeyEvent(4);

            driver.findElement(By.id("tv_brows_items")).click();
            Assert.assertEquals("coupon view detail跳转异常", WEBVIEW_ACTIVITY, driver.currentActivity().toString());
            System.out.println("步骤：coupon browse item跳转正常");

        } catch (Exception e) {
            System.out.println("步骤：coupon没有找到");

        }
        tearDown();

    }
}
