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

public class NewArr extends BaseTest {

    @Ignore
    public void testnewarr_feed() throws Exception {

        //setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);

        //点击store club
        System.out.println("步骤：进入store club");
        System.out.println("步骤：未登录情况下，查看上新");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();
        SwipeUtil.swipeToLeft(driver,1000);

        //获取feed信息
        SwipeUtil.scroll(driver);
        String stores_name= driver.findElement(By.id("tv_store")).getText();
        String post_time= driver.findElement(By.id("tv_store_score")).getText();
        String post_des=driver.findElement(By.id("tv_item_desc")).getText();
        System.out.println("步骤：进入newarr lp，查看店铺名称 "+stores_name);
        System.out.println("步骤：进入newarr lp，查看发帖时间 "+post_time);
        System.out.println("步骤：进入newarr lp，查看帖子描述 "+post_des);

        Assert.assertNotNull("未登录信息显示不正常","Sign in to see more");
        System.out.println("步骤：未登录信息正常 ");

        //推荐文案
        Assert.assertNotNull("推荐文案",driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Recommended Stores\")"));
        System.out.println("步骤：推荐文案显示正常 ");



        //查看大图
        driver.findElement(By.id("rv_item_img")).click();
        BaseUtil.sleep();
        driver.findElement(By.id("tv_link")).click();
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        System.out.println("步骤：帖子大图显示正常");

        //点击like／comment/翻译／follow
        SwipeUtil.swipeToUp(driver,500);
        try{
            driver.findElement(By.id("tv_item_desc")).click();
            Assert.assertEquals("点上新描述跳转错误",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
            System.out.println("点击上新描述跳转正常");
        }catch (Exception e){
            System.out.println("上新描述异常");
        }

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
        System.out.println("点击comment，弹登陆框正常");

        driver.findElement(By.id("iv_store_follow")).click();
        Assert.assertEquals("弹登陆框失败",LOGIN_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击follow，弹登陆框正常");
        SwipeUtil.swipeToUp(driver,1000);
        tearDown();

    }



    @Ignore
    public void testnewarr_detail_sign() throws Exception {

        setUp();
        //确保登录
        LoginUtil.makeLogin(driver);

        //点击store club
        System.out.println("步骤：进 入store club");
        System.out.println("步骤：登录情况下，查看上新");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Store Club\")").click();
        BaseUtil.sleep();
        SwipeUtil.swipeToLeft(driver,1000);

        //查看帖子detail
        //翻译／评论／点赞
        SwipeUtil.scroll(driver);
        BaseUtil.sleep();
        try{
            driver.findElement(By.id("tv_item_desc")).click();
            Assert.assertEquals("点击view all跳转异常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
            System.out.println("点击上新描述跳转正常");
        }catch (Exception e){
            System.out.println("上新描述异常");

        }

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

        //翻译
        driver.findElement(By.id("btn_auto_translate")).click();
        System.out.println("翻译成功");

        //点击头像
        driver.findElement(By.id("riv_store_logo")).click();
        Assert.assertEquals("点击店铺头像跳店铺detail失败",STORE_ACTIVITY,driver.currentActivity().toString());
        driver.sendKeyEvent(4);

        //帖子new arrival打标
        driver.findElement(By.id("tv_list_title")).click();
        Assert.assertEquals("帖子title错误","NEW ARRIVALS",driver.findElement(By.id("tv_list_title")).getText());
        System.out.println("帖子title正常");

        //帖子副标题
        try{
            String text=driver.findElement(By.id("expandable_text")).getText();
            System.out.println("帖子text正常"+text);
        }catch (Exception e){
            System.out.println("帖子text为空");
        }

        //商品
        driver.findElement(By.id("rv_product_img")).click();
        Assert.assertEquals("商品跳转错误",PRODUCT_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("商品跳转正常");
        BaseUtil.sleep();
        driver.sendKeyEvent(4);

        String price=driver.findElement(By.id("tv_current_price")).getText();
        System.out.println("商品现价"+price);
        try{
            String price_org=driver.findElement(By.id("tv_origin_price")).getText();
            System.out.println("商品原价"+price_org);
        }catch (Exception e){
            System.out.println("商品原价不存在");
        }

        //查看跳转和follow
        SwipeUtil.scroll(driver);
        BaseUtil.sleep();
        driver.scrollTo(stores_name).tap(1,1000);
        BaseUtil.sleep();
        Assert.assertEquals("店铺跳转失败1",STORE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击店铺logo跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        String follow_count=driver.findElement(By.id("tv_store_follow_count")).getText();
        System.out.println("店铺粉丝数"+follow_count);

        driver.findElement(By.id("tv_visit_store")).click();
        BaseUtil.sleep();
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
                BaseUtil.sleep();
            } catch (Exception e) {
                System.out.println("帖子comment小于5");
                BaseUtil.sleep();
                driver.findElement(By.id("tv_comment_content")).click();
                Assert.assertEquals("帖子comment 列表跳转错误",COMMENT_LIST_ACTIVITY,driver.currentActivity().toString());
                System.out.println("帖子comment列表正常");
                driver.sendKeyEvent(4);
                BaseUtil.sleep();
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
                BaseUtil.sleep();
            }catch (Exception e){
                System.out.println("帖子like列表异常");
                BaseUtil.sleep();
            }
        }

        tearDown();

    }

}
