package ui.fanZone;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.base.BaseTest;
import util.LoginUtil;
import util.BaseUtil;
import util.SwipeUtil;


public class ItaoBlogTest  extends BaseTest {

    @Test
    public void testItaoblogger() throws Exception {

        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        BaseUtil.sleep();

        //获取首页数
        String fanzone_count=driver.findElement(By.id("tv_1")).getText();
        System.out.println("步骤：fanzone首页粉丝数 "+fanzone_count);

        //点击store club
        System.out.println("步骤：进入fan zone");
        System.out.println("步骤：点击banner进入itaoblogger");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"STAR BLOGGER\")").click();

        //获取页面信息
        String name=driver.findElement(By.id("tv_user_name")).getText();
        String followers=driver.findElement(By.id("tv_followers")).getText();
        String post_count=driver.findElement(By.id("tv_btn_see_all")).getText();
        BaseUtil.sleep();
        System.out.println("步骤：昵称 "+name);
        System.out.println("步骤：follower数 "+followers);
        System.out.println("步骤：post数 "+post_count);

        //点击头像
        driver.findElement(By.id("iv_user_img")).click();
        Assert.assertEquals("点击头像跳profile失败",PROFILE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点击头像跳转正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //获取标签，点击标签
        String tag1=driver.findElement(By.id("tv_tag1")).getText();
        String tag2=driver.findElement(By.id("tv_tag2")).getText();
        System.out.println("步骤：标签1 "+tag1);
        System.out.println("步骤：标签2 "+tag2);

        driver.findElement(By.id("tv_tag1")).click();
        BaseUtil.sleep();
        Assert.assertEquals("点击标签1跳转失败",HOME_SPOTLIST_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：标签1 跳转正常 ");
        driver.sendKeyEvent(4);

        driver.findElement(By.id("tv_tag2")).click();
        BaseUtil.sleep();
        Assert.assertEquals("点击标签2跳转失败",HOME_SPOTLIST_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：标签2 跳转正常");
        driver.sendKeyEvent(4);

        //点击图片，跳到帖子
        driver.findElement(By.id("riv_spotlight_pix")).click();
        BaseUtil.sleep();
        Assert.assertEquals("跳到帖子detail失败",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点击图片跳到帖子detail正常 ");
        SwipeUtil.swipeToUp(driver,1000);
        driver.sendKeyEvent(4);

        //推荐理由
        String reason=driver.findElement(By.id("tv_tag1")).getText();
        System.out.println("步骤：帖子推荐理由 "+reason);

        //点击see all post
        driver.findElement(By.id("tv_btn_see_all")).click();
        Assert.assertEquals("跳到profile失败",PROFILE_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：点击all post跳转正常 ");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        for(int i=0;i<5;i++){
            SwipeUtil.swipeToUp(driver,1000);
        }

        //点击算法推荐
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Women's Clothing\")").click();
        BaseUtil.sleep();
        System.out.println("步骤：算法标签1跳转正常 ");
        SwipeUtil.scroll(driver);
        driver.sendKeyEvent(4);

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fashion Jewelry\")").click();
        BaseUtil.sleep();
        System.out.println("步骤：算法标签2跳转正常 ");
        SwipeUtil.scroll(driver);
        driver.sendKeyEvent(4);

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Accessories\")").click();
        BaseUtil.sleep();
        System.out.println("步骤：算法标签3跳转正常 ");
        SwipeUtil.scroll(driver);
        driver.sendKeyEvent(4);

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Beauty\")").click();
        BaseUtil.sleep();
        System.out.println("步骤：算法标签4跳转正常 ");
        SwipeUtil.scroll(driver);
        driver.sendKeyEvent(4);

        //点击explore more
        BaseUtil.sleep();
        driver.findElement(By.id("btn_explore_more")).click();
        Assert.assertEquals("explore more跳转失败",HOME_SPOTLIST_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：explore more跳转正常 ");

//        for(int i=0;i<26;i++){
//            List<WebElement> tab_list=driver.findElements(By.className("android.widget.TextView"));
//            WebElement tab =tab_list.get(i);
//            tab.click();
//            SwipeUtil.swipeToUp(driver,1000);
//            SwipeUtil.swipeToUp(driver,1000);
//            try{
//                System.out.println("步骤：运营tab切换正常 "+i);
//            }catch (Exception e){
//                System.out.println("步骤：运营tab切换异常 "+i);
//            }
//            driver.sendKeyEvent(4);
//        }
        tearDown();

        }

}
