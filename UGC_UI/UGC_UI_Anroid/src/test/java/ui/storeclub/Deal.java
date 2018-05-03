package ui.storeclub;

import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import util.LoginUtil;
import util.BaseUtil;
import util.SwipeUtil;

import java.util.Objects;


public class Deal extends BaseTest {

    @Ignore
    public void testdeal_feed() throws Exception {

        //setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);


        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：未登录情况下，查看");
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        BaseUtil.sleep();

        //获取feed信息
        String stores_name= driver.findElement(By.id("tv_store")).getText();
        String post_time= driver.findElement(By.id("tv_store_score")).getText();
        String price=driver.findElement(By.id("tv_item_price")).getText();
        System.out.println("步骤：进入deals lp，查看店铺名称 "+stores_name);
        System.out.println("步骤：进入deals lp，查看发帖时间 "+post_time);
        System.out.println("步骤：进入deals lp，查看商品价格 "+price);

        Assert.assertNotNull("未登录信息显示不正常","Sign in to see more");
        System.out.println("步骤：未登录信息正常 ");

        //推荐文案
        Assert.assertNotNull("推荐文案","Recommended Stores");
        System.out.println("步骤：推荐文案显示正常 ");

        //点击sign in
        LoginUtil.click_login(driver,"tv_comment_count","点击sign in，弹出登陆框正常");
        LoginUtil.click_login(driver,"btn_login","点击sign in，弹出登陆框正常");
        LoginUtil.click_login(driver,"tv_like_count","点击sign in，弹出登陆框正常");

//        WebElement sign_in=driver.findElement(By.id("btn_login"));
//        System.out.println(sign_in);
//        WebElement comment=driver.findElement(By.id("tv_comment_count"));
//        System.out.println(comment);
//        WebElement like=driver.findElement(By.id("tv_like_count"));
//        System.out.println(like);
        //sign_in.click();
//      driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'btn_login')]")).click();
//        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
//        System.out.println("点击sign in，弹出登陆框正常");
//        BaseUtil.sleep();
//        driver.sendKeyEvent(4);
//        //driver.findElement(By.id("close_btn")).click();
//        BaseUtil.sleep();

        //点击sign in
//        =driver.findElement(By.id("btn_login"));
//        System.out.println("test4: "+element1);
//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"SIGN IN\")").click();
//        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
//        System.out.println("点击sign in，弹出登陆框正常");
//        driver.sendKeyEvent(4);
//        BaseUtil.sleep();


        //WebElement elemen1=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'tv_like_count')]"));
        //System.out.println(elemen1);
        //WebElement elemen1=driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.alibaba.aliexpresshd:id/tv_like_count[1]\"]");
        //driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.alibaba.aliexpresshd:id/tv_like_count\")").click();
        //driver.findElementById("com.alibaba.aliexpresshd:id/tv_like_count").click();


        //driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'tv_comment_count')]")).click();
        //driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.alibaba.aliexpresshd:id/tv_comment_count[1]\"]").click();
        //driver.findElementById("com.alibaba.aliexpresshd:id/tv_comment_count").click();
        //driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.alibaba.aliexpresshd:id/tv_comment_count\")").click();
//        WebElement comment=driver.findElement(By.id("tv_comment_count"));
//        comment.click();
//        SwipeUtil.scroll(driver);
//        Assert.assertEquals("跳到comment列表失败",COMMENT_LIST_ACTIVITY,driver.currentActivity().toString());
//        driver.findElement(By.id("btn_comment_send")).click();
//        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
//        System.out.println("点击comment，弹出登陆框正常");
//        driver.sendKeyEvent(4);
//        BaseUtil.sleep();

        //点击follow
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ImageView[2]").click();
        //driver.findElementByXPath("//android.widget.ImageView[@resource-id=\"com.alibaba.aliexpresshd:id/iv_action[1]\"]").click();
//        driver.findElement(By.id("iv_action")).click();
//        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
//        System.out.println("点击follow，弹出登陆框正常");
//        driver.sendKeyEvent(4);
//        BaseUtil.sleep();

        tearDown();
    }


    @Ignore
    public void testdeal_detail_sign() throws Exception {

        //setUp();
        //确保登录
        LoginUtil.makeLogin(driver);

        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：登录情况下，查看专享价");
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        BaseUtil.sleep();

        //查看帖子detail
        driver.findElement(By.id("rv_item_img")).click();
        BaseUtil.sleep();

        //获取帖子detail信息
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

        driver.findElement(By.id("btn_auto_translate")).click();
        System.out.println("翻译成功");

        String detail_title= driver.findElement(By.id("tv_title")).getText();
        System.out.println("步骤：帖子detail "+detail_title);
        try{
            String detail_text= driver.findElement(By.id("expandable_text")).getText();
            System.out.println("步骤：帖子detail "+detail_text);
        }catch(Exception e){
            System.out.println("帖子副标题为空");
        }

        Assert.assertEquals("帖子title错误","Fan exclusive discount",driver.findElement(By.id("tv_list_title")).getText());
        System.out.println("帖子title正常");
        SwipeUtil.swipeToUp(driver,1000);

        //帖子点赞／评论／翻译
        driver.findElement(By.id("rv_product_img")).click();
        Assert.assertEquals("商品跳转错误",PRODUCT_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：商品跳转正常");
        driver.sendKeyEvent(4);

        String price=driver.findElement(By.id("tv_current_price")).getText();
        System.out.println("步骤：商品促销价"+price);
        try{
            String price_org=driver.findElement(By.id("tv_origin_price")).getText();
            System.out.println("步骤：商品原价"+price_org);
        }catch (Exception e){
            System.out.println("步骤：商品为原价");
        }

        //查看跳转和follow
        SwipeUtil.scroll(driver);
        driver.scrollTo(stores_name).tap(1,1000);
        BaseUtil.sleep();
        Assert.assertEquals("店铺跳转失败1",STORE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击店铺logo跳转正常");
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        String follow_count=driver.findElement(By.id("tv_store_follow_count")).getText();
        System.out.println("店铺粉丝数"+follow_count);

        driver.findElement(By.id("tv_visit_store")).click();
        Assert.assertEquals("店铺跳转失败2",STORE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击visit store跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //comment
        if(!Objects.equals(comment_num, String.valueOf(0)))
        {
            try {
                driver.findElement(By.id("btn_post_comment_list")).click();
                Assert.assertEquals("帖子comment 列表跳转错误",COMMENT_LIST_ACTIVITY,driver.currentActivity().toString());
                SwipeUtil.swipeToUp(driver, 2000);
                System.out.println("帖子comment列表正常");
                driver.sendKeyEvent(4);
                BaseUtil.sleep();
            } catch (Exception e) {
                System.out.println("帖子comment小于5");
                driver.findElement(By.id("tv_comment_content")).click();
                Assert.assertEquals("帖子comment 列表跳转错误",COMMENT_LIST_ACTIVITY,driver.currentActivity().toString());
                SwipeUtil.swipeToUp(driver, 2000);
                System.out.println("帖子comment列表正常");
                driver.sendKeyEvent(4);
                BaseUtil.sleep();
            }
        }else{
            System.out.println("帖子comment为空");
            BaseUtil.sleep();
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
                BaseUtil.sleep();
            }catch (Exception e){
                System.out.println("帖子like列表异常");
                BaseUtil.sleep();
            }
        }
        tearDown();

    }

}
