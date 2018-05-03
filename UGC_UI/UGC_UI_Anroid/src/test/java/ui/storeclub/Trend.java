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

public class Trend extends BaseTest {


    @Ignore
    public void testtrend_feed() throws Exception {

        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);

        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：未登录情况下，查看图文帖");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);

        //点击sign in
        driver.findElement(By.id("btn_login")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        System.out.println("点击sign in，弹出登陆框正常");

        //banner
//        try{
//
//        }catch (Exception e){
//
//        }

        //获取feed信息
        SwipeUtil.scroll(driver);
        String stores_name= driver.findElement(By.id("tv_store")).getText();
        String post_time= driver.findElement(By.id("tv_store_score")).getText();
        String post_title=driver.findElement(By.id("tv_item_title")).getText();
        String post_des=driver.findElement(By.id("tv_item_desc")).getText();
        System.out.println("步骤：进入trend lp，查看店铺名称 "+stores_name);
        System.out.println("步骤：进入trend lp，查看发帖时间 "+post_time);
        System.out.println("步骤：进入trend lp，查看帖子title "+post_title);
        System.out.println("步骤：进入trend lp，查看帖子描述 "+post_des);

        try{
            String floor_tag= driver.findElement(By.id("tv_floor_tag")).getText();
            System.out.println("步骤：进入deals lp，floor标志存在 "+floor_tag);
        }catch (Exception e){
            System.out.println("步骤：进入deals lp，floor标志不存在 ");
        }

        //点击like／comment/翻译／follow
        driver.findElement(By.id("tv_item_title")).click();
        Assert.assertEquals("点上新描述跳转错误",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击图文描述跳转正常");
        driver.sendKeyEvent(4);

        driver.findElement(By.id("tv_like_count")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        System.out.println("点击like，弹出登陆框正常");

        driver.findElement(By.id("tv_comment_count")).click();
        BaseUtil.sleep();
        driver.findElement(By.id("btn_comment_send")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        System.out.println("点击comment，弹登陆框正常");

        driver.findElement(By.id("iv_action")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击follow，弹出登陆框");
        driver.sendKeyEvent(4);
        SwipeUtil.swipeToUp(driver,1000);
        tearDown();
    }


    @Ignore
    public void testtrend_detail_sign() throws Exception {

        setUp();
        //确保登录
        LoginUtil.makeLogin(driver);
        SwipeUtil.scroll(driver);
        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：登录情况下，查看图文帖");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);

        //查看帖子detail
        //翻译／评论／点赞

        System.out.println("步骤：点击查看帖子detail");
        driver.findElement(By.id("tv_item_desc")).click();
        String stores_name= driver.findElement(By.id("tv_store_name")).getText();
        String post_time= driver.findElement(By.id("tv_store_update_time")).getText();
        String like_num= driver.findElement(By.id("tv_like_count")).getText();
        String comment_num= driver.findElement(By.id("tv_comment_count")).getText();
        BaseUtil.sleep();
        BaseUtil.takeScreenShot(driver);
        System.out.println("步骤：帖子detail "+stores_name);
        System.out.println("步骤：帖子detail "+post_time);
        System.out.println("步骤：帖子detail "+like_num);
        System.out.println("步骤：帖子detail "+comment_num);
        BaseUtil.sleep();

        //detail banner
        Assert.assertNotNull("图文帖banner不存在",driver.findElement(By.id("riv_banner")));

        //点击头像
        driver.findElement(By.id("riv_store_logo")).click();
        Assert.assertEquals("点击店铺头像跳店铺detail失败",STORE_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);
        System.out.println("店铺头像跳转正常");

        //翻译
        driver.findElement(By.id("btn_auto_translate")).click();
        System.out.println("翻译成功");

        //title正常
        String title=driver.findElement(By.id("tv_title")).getText();
        System.out.println("帖子title正常"+title);
        try{
            String text=driver.findElement(By.id("expandable_text")).getText();
            System.out.println("帖子副标题正常"+text);
            BaseUtil.sleep();
        }catch (Exception e){
            System.out.println("帖子副标题为空");
            BaseUtil.sleep();
        }

        //view detail
        System.out.println("点击跳商品detail");
        driver.scrollTo("View Detail").tap(1,1000);
        //driver.findElementByAndroidUIAutomator("new UiSelector().text(\"View Detail\")").click();
        BaseUtil.sleep();
        Assert.assertEquals("商品跳转错误",PRODUCT_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("商品跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //view more
        driver.scrollTo("VIEW MORE").tap(1,1000);
        //driver.findElementByAndroidUIAutomator("new UiSelector().text(\"VIEW MORE\")").click();
        SwipeUtil.swipeToUp(driver,2000);
        System.out.println("帖子view more跳转正常");
        driver.sendKeyEvent(4);

        //查看跳转和follow
        driver.scrollTo(stores_name).tap(1,1000);
        Assert.assertEquals("店铺跳转失败1",STORE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击店铺logo跳转正常");
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        String follow_count=driver.findElement(By.id("tv_store_follow_count")).getText();
        System.out.println("店铺粉丝数"+follow_count);

        driver.findElement(By.id("tv_visit_store")).click();
        Assert.assertEquals("店铺跳转失败2",STORE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击visit store跳转正常");
        BaseUtil.sleep();
        driver.sendKeyEvent(4);

        //comment
        if(!Objects.equals(comment_num, String.valueOf(0)))
        {
            try {
                driver.findElement(By.id("btn_post_comment_list")).click();
                Assert.assertEquals("帖子comment 列表跳转错误",COMMENT_LIST_ACTIVITY,driver.currentActivity().toString());
                SwipeUtil.swipeToUp(driver, 2000);
                System.out.println("帖子comment列表正常");
                driver.sendKeyEvent(4);
            } catch (Exception e) {
                System.out.println("帖子comment小于5");
                driver.findElement(By.id("tv_comment_content")).click();
                Assert.assertEquals("帖子comment 列表跳转错误",COMMENT_LIST_ACTIVITY,driver.currentActivity().toString());
                SwipeUtil.swipeToUp(driver, 2000);
                System.out.println("帖子comment列表正常");
                driver.sendKeyEvent(4);
            }
        }else{
            System.out.println("帖子comment为空");
        }

        //like
        SwipeUtil.swipeToDown(driver,1000);
        if(like_num.equals(0)){
            System.out.println("帖子like列表为空");
        }else{
            try{
                driver.findElement(By.id("riv_avatar")).click();
                Assert.assertEquals("帖子like列表跳转错误",LIKE_LIST_ACTIVITY,driver.currentActivity().toString());
                SwipeUtil.swipeToUp(driver,2000);
                System.out.println("帖子like列表正常");
                driver.sendKeyEvent(4);
            }catch (Exception e){
                System.out.println("帖子like列表异常");
            }
        }
        tearDown();

    }
}
