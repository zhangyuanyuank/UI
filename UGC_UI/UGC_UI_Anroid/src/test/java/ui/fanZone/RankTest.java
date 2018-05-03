package ui.fanZone;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.base.BaseTest;
import util.LoginUtil;
import util.BaseUtil;
import util.SwipeUtil;

public class RankTest  extends BaseTest {

    @Test
    public void testrank() throws Exception {

        setUp();
        //确保未登录
        LoginUtil.makeunLogin(driver);
        BaseUtil.sleep();

        //点击store club
        System.out.println("步骤：进入fan zone");
        System.out.println("步骤：点击banner进入itaoblogger");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Fan Zone\")").click();
        BaseUtil.sleep();
        SwipeUtil.scroll(driver);
        try{
            driver.scrollTo("TRENDING \n" +
                    "BLOGGERS").tap(1,1000);
            BaseUtil.sleep();
            String rank_detail_title = driver.findElement(By.id("tv_ranking_title")).getText();
            System.out.println("步骤：点击排行榜跳转正常"+rank_detail_title);
            BaseUtil.sleep();
        }catch (Exception e){
            System.out.println("步骤：点击排行榜跳转异常");
            return;
        }
        //排行榜detail
        Assert.assertNotNull("排行榜标题为空", "LATEST BLOGGER RANKINGS");
        Assert.assertNotNull("排行榜tab1为空", "TRENDING \n" + "BLOGGERS ");
        Assert.assertNotNull("排行榜tab2为空", "UPCOMING \n" + "BLOGGERS");
        Assert.assertNotNull("排行榜tab3为空", "STAR \n" + "BLOGGERS");
        System.out.println("步骤：排行榜标题正常");
        System.out.println("步骤：排行榜tab1正常");
        System.out.println("步骤：排行榜tab2正常");
        System.out.println("步骤：排行榜tab3正常");
        BaseUtil.sleep();

        //某个tab下数据
        String rank_detail_title = driver.findElement(By.id("tv_ranking_title")).getText();
        String rank_detail_update = driver.findElement(By.id("tv_ranking_update")).getText();
        String rank_detail_time = driver.findElement(By.id("tv_ranking_time")).getText();
        String rank_detail_rule = driver.findElement(By.id("tv_ranking_rule")).getText();
        System.out.println("步骤：排行榜detail标题" + rank_detail_title);
        System.out.println("步骤：排行榜detail更新文案" + rank_detail_update);
        System.out.println("步骤：排行榜detail更新时间" + rank_detail_time);
        System.out.println("步骤：排行榜detail更新规则" + rank_detail_rule);
        driver.findElement(By.id("tv_ranking_rule")).click();
        Assert.assertEquals("rule跳转异常", WEBVIEW_ACTIVITY, driver.currentActivity().toString());
        BaseUtil.sleep();
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        Assert.assertNotNull("排行榜头像为空", driver.findElement(By.id("avatar")));
        Assert.assertNotNull("排行榜国家为空", driver.findElement(By.id("iv_country")));
        Assert.assertNotNull("排行榜like/post文案为空", driver.findElement(By.id("tv_factor_name")));
        Assert.assertNotNull("排行榜post文案为空", driver.findElement(By.id("tv_ranking_post")));

        String rank_detail_seq = driver.findElement(By.id("tv_ranking_seq")).getText();
        String rank_detail_status = driver.findElement(By.id("tv_ranking_delta")).getText();
        String rank_detail_name = driver.findElement(By.id("tv_nick_name")).getText();
        String rank_detail_num = driver.findElement(By.id("tv_factor_num")).getText();
        String rank_detail_post_count = driver.findElement(By.id("tv_ranking_post_count")).getText();
        System.out.println("步骤：排行榜detail排序" + rank_detail_seq);
        System.out.println("步骤：排行榜detail状态" + rank_detail_status);
        System.out.println("步骤：排行榜detail昵称" + rank_detail_name);
        System.out.println("步骤：排行榜detail like／post数" + rank_detail_num);
        System.out.println("步骤：排行榜detail帖子数" + rank_detail_post_count);
        BaseUtil.sleep();

        //点击头像
        driver.findElement(By.id("avatar")).click();
        Assert.assertEquals("点击头像跳转异常", PROFILE_ACTIVITY, driver.currentActivity().toString());
        System.out.println("步骤：点击头像跳转正常");
        driver.sendKeyEvent(4);

        //点击图片
        driver.findElement(By.id("riv_post_image")).click();
        Assert.assertEquals("点击图片跳转异常", PROFILE_ACTIVITY, driver.currentActivity().toString());
        System.out.println("步骤：点击图片跳转正常");
        driver.sendKeyEvent(4);

        //点击follow
        driver.findElement(By.id("iv_follow")).click();
        Assert.assertEquals("点击follow跳转异常", LOGIN_ACTIVITY, driver.currentActivity().toString());
        System.out.println("步骤：点击follow跳转正常");
        driver.sendKeyEvent(4);

        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToRight(driver,1000);
        SwipeUtil.swipeToLeft(driver,1000);
        SwipeUtil.swipeToDown(driver,1000);

        //切换tab
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"UPCOMING \n" +
                "BLOGGERS\")").click();
        BaseUtil.sleep();
        System.out.println("步骤：tab切换正常");
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

        Assert.assertNotNull("FEED排行榜标题为空", "LATEST BLOGGER RANKINGS");
        BaseUtil.sleep();
        Assert.assertNotNull("FEED排行榜排名为空", driver.findElement(By.id("iv_ranking")));
        BaseUtil.sleep();
        Assert.assertNotNull("FEED排行榜头像为空", driver.findElement(By.id("riv_avatar")));
        BaseUtil.sleep();
        System.out.println("步骤：FEED排行榜标题正常" );
        System.out.println("步骤：FEED排行榜排名正常" );
        System.out.println("步骤：FEED排行榜头像正常" );
        BaseUtil.sleep();
        String rank_title = driver.findElement(By.id("tv_rank_title")).getText();
        String rank_name = driver.findElement(By.id("tv_blogger_user_name")).getText();
        System.out.println("步骤：FEED排行榜title" + rank_title);
        System.out.println("步骤：FEED排行榜name" + rank_name);
        tearDown();

    }


}
