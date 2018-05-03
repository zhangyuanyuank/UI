package ui.home;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.base.BaseTest;
import util.BaseUtil;
import util.LoginUtil;
import util.SwipeUtil;

public class TrendTalkTest extends BaseTest {

    @Test
    public void testtrend() throws Exception {

        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        BaseUtil.sleep();

        //点击trend talk
        System.out.println("步骤：查看首页数据");
        System.out.println("步骤：首页trend talk");
        driver.scrollTo("TREND TALK").tap(1,1000);
        BaseUtil.sleep();
        String desc=driver.findElement(By.id("tv_content")).getText();
        String name=driver.findElement(By.id("tv_usr_name")).getText();
        System.out.println("步骤：描述正常"+desc);
        System.out.println("步骤：昵称正常"+name);

        //点图片
        driver.findElement(By.id("riv_post_img")).click();
        Assert.assertEquals("点图片跳detail异常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击图片，跳到帖子detail");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //点评论
        driver.findElement(By.id("tv_comment_count")).click();
        Assert.assertEquals("点评论跳detail异常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击comment，跳到帖子detail");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        //点like
        driver.findElement(By.id("tv_like_count")).click();
        Assert.assertEquals("点评论跳detail异常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("点击like，跳到帖子detail");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        SwipeUtil.swipeToUp(driver,1000);
        String title=driver.findElement(By.id("tv_inspiration_horiz_badge")).getText();
        String comment=driver.findElement(By.id("tv_inspiration_horiz_text_1")).getText();
        String like=driver.findElement(By.id("tv_inspiration_horiz_text_2")).getText();
        System.out.println("trend talk"+title);
        System.out.println("trend talk"+comment);
        System.out.println("trend talk"+like);
        Assert.assertNotNull("trend talk封面为空", driver.findElement(By.id("iv_inspiration_horiz_cover")));
        Assert.assertNotNull("trend talk头像为空", driver.findElement(By.id("iv_inspiration_horiz_avatar")));
        Assert.assertNotNull("trend talk评论icon为空", driver.findElement(By.id("iv_inspiration_horiz_icon_1")));
        Assert.assertNotNull("trend talk点赞icon为空", driver.findElement(By.id("iv_inspiration_horiz_icon_2")));

        tearDown();

    }
}
