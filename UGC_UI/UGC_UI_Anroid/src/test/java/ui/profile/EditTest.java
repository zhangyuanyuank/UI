package ui.profile;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import util.LoginUtil;
import util.BaseUtil;
import util.SwipeUtil;

public class EditTest  extends BaseTest {

    @Test
    public void testedit_account() throws Exception {

        setUp();
        //确保登录
        LoginUtil.makeLogin(driver);
        BaseUtil.sleep();

        System.out.println("步骤：点击跳到my account页面");
        driver.findElement(By.id("left_action")).click();
        driver.findElement(By.id("profile_name_text")).click();
        BaseUtil.sleep();
        driver.findElement(By.id("profile_text_info")).click();
        BaseUtil.sleep();

        driver.findElement(By.id("ll_myprofile_contact_name")).click();
        driver.findElement(By.id("et_first_name")).sendKeys("firstname");
        driver.findElement(By.id("et_last_name")).sendKeys("lastname");
        BaseUtil.sleep();
        driver.findElement(By.id("buttonDefaultPositive")).click();
        Assert.assertEquals("contact name修改失败","firstname lastname", driver.findElement(By.id("tv_myprofile_contact_name")).getText());
        System.out.println("步骤：contact name修改成功");

        System.out.println("步骤：查看用户等级");
        driver.findElement(By.id("ll_myprofile_reward_name")).click();
        driver.sendKeyEvent(4);

        System.out.println("步骤：查看用户email");
        String e_mail=driver.findElement(By.id("tv_myprofile_email")).getText();
        System.out.println("步骤：email"+e_mail);

        driver.findElement(By.id("ll_myprofile_gender")).click();
        driver.findElement(By.id("control")).click();
        System.out.println("步骤：修改性别正常");

        driver.findElement(By.id("ll_myprofile_birth")).click();
        driver.sendKeyEvent(4);
        String birth=driver.findElement(By.id("tv_myprofile_birth")).getText();
        System.out.println("步骤：出生时间跳转正常");
        System.out.println("步骤：出生时间为"+birth);

        driver.findElement(By.id("tv_shipping_address")).click();
        System.out.println("步骤：地址跳转正常");
        tearDown();

    }



    @Ignore
    public void edit_profile() throws Exception {

        setUp();
       //确保登录
       LoginUtil.makeLogin(driver);

       //跳到my post页面
       System.out.println("步骤：进入my account页面");
       System.out.println("步骤：进入my profile页面");
       driver.findElement(By.id("left_action")).click();
       String name=driver.findElement(By.id("profile_name_text")).getText();
       System.out.println("步骤：登录帐号为 "+name);
       driver.findElement(By.id("profile_name_text")).click();
       driver.findElement(By.id("profile_text_info")).click();
       BaseUtil.sleep();
       driver.findElement(By.id("ll_my_posts")).click();
        BaseUtil.sleep();

       //点击edit profile
       System.out.println("步骤：1");
       driver.findElement(By.id("btn_edit_profile")).click();
       //driver.findElement(By.id("tv_edit_profile")).click();
       //driver.tap(1,540,630,1000);
       System.out.println("步骤：2");
       driver.findElement(By.id("rl_myprofile_photo")).click();
       BaseUtil.sleep();
       //上传黄图提醒
       driver.findElement(By.id("buttonDefaultNegative")).click();
       try{
           driver.findElement(By.id("rl_myprofile_photo")).click();
           //相册选图
           driver.findElement(By.id("tiv_album_photo")).click();
           driver.findElement(By.id("ll_save_photo")).click();
           driver.findElement(By.id("btn_done")).click();
           System.out.println("步骤：头像修改成功");
       }catch (Exception e){
           System.out.println("步骤：相册中没有图片");
       }


       driver.findElement(By.id("tv_myprofile_nick_name")).click();
       driver.findElement(By.id("tv_myprofile_nick_name")).sendKeys("THIS_IS_A_test");
       driver.findElement(By.id("action_done")).click();
       BaseUtil.sleep();
       String nick_name=driver.findElement(By.id("tv_myprofile_email")).getText();
       System.out.println("步骤：昵称"+nick_name);
       System.out.println("步骤：昵称修改成功");

       driver.findElement(By.id("ll_myprofile_country")).click();
       driver.findElement(By.id("rl_select_item")).click();
        BaseUtil.sleep();
       System.out.println("步骤：国家修改成功");

       driver.findElement(By.id("tv_myprofile_bio")).click();
       driver.findElement(By.id("tv_myprofile_bio")).sendKeys("write bio");
       driver.findElement(By.id("action_done")).click();
        BaseUtil.sleep();
       String bio=driver.findElement(By.id("tv_myprofile_bio")).getText();
       System.out.println("步骤：email"+bio);
       System.out.println("步骤：简介修改成功");

       driver.findElement(By.id("ll_myprofile_mycomments")).click();
        BaseUtil.sleep();
       driver.findElement(By.id("ll_follow_action")).click();
        BaseUtil.sleep();
       driver.sendKeyEvent(4);
       driver.findElement(By.id("tv_view_all")).click();
        BaseUtil.sleep();
       SwipeUtil.swipeToDown(driver,1000);
       SwipeUtil.swipeToDown(driver,1000);
       driver.tap(1,50,107,1000);
       System.out.println("步骤：my comment正常");


       System.out.println("步骤：查看block");
       driver.findElement(By.id("ll_myprofile_myblock")).click();
       BaseUtil.takeScreenShot(driver);
       try{
           String block_name= driver.findElement(By.id("tv_user_name")).getText();
           WebElement block_sex= driver.findElement(By.id("iv_sex"));
           WebElement block_country= driver.findElement(By.id("iv_country"));
           WebElement block_img= driver.findElement(By.id("riv_avatar"));

           System.out.println("步骤：block name"+block_name);
           if(block_img !=null && block_sex !=null && block_country !=null){
               System.out.println("步骤：block数据正常" );
           }
       }catch (Exception e){
           System.out.println("步骤：block数据不正常" );
       }
       driver.findElement(By.id("btn_unBlock")).click();
       driver.sendKeyEvent(4);
       driver.findElement(By.id("ll_myprofile_myblock")).click();
       BaseUtil.takeScreenShot(driver);
       driver.sendKeyEvent(4);
       driver.sendKeyEvent(4);
       System.out.println("步骤：返回到my profile");

       System.out.println("步骤：profile follow列表");
       driver.findElement(By.id("tv_follower_count")).click();
       try{

           String follow_name= driver.findElement(By.id("tv_user_name")).getText();
           WebElement follow_sex= driver.findElement(By.id("iv_sex"));
           WebElement follow_country= driver.findElement(By.id("iv_country"));
           WebElement follow_img= driver.findElement(By.id("riv_avatar"));

           System.out.println("步骤：follow name"+follow_name);
           if(follow_sex !=null && follow_country !=null && follow_img !=null){
               System.out.println("步骤：follow数据正常" );
           }
       }catch (Exception e){
           System.out.println("步骤：follow数据不正常" );
       }
       driver.sendKeyEvent(4);


       System.out.println("步骤：profile following列表");
       driver.findElement(By.id("tv_following_count")).click();
       try{

           String following_name= driver.findElement(By.id("tv_user_name")).getText();
           WebElement following_sex= driver.findElement(By.id("iv_sex"));
           WebElement following_country= driver.findElement(By.id("iv_country"));
           WebElement following_img= driver.findElement(By.id("riv_avatar"));

           System.out.println("步骤：following name"+following_name);
           if(following_sex !=null && following_country !=null && following_img !=null){
               System.out.println("步骤：following数据正常" );
           }
       }catch (Exception e){
           System.out.println("步骤：following数据不正常" );
       }
       driver.sendKeyEvent(4);
        tearDown();


    }



    @Ignore
    public void post_list() throws Exception {

        setUp();
        LoginUtil.doLogin();

        System.out.println("步骤：进入my account页面");
        System.out.println("步骤：进入my profile页面");
        driver.findElement(By.id("left_action")).click();
        driver.findElement(By.id("profile_name_text")).click();
        driver.findElement(By.id("profile_text_info")).click();
        BaseUtil.sleep();
        driver.findElement(By.id("ll_my_posts")).click();
        BaseUtil.sleep();

        String post_time=driver.findElement(By.id("tv_send_time")).getText();
        System.out.println("步骤：帖子发布时间"+post_time);
        System.out.println("步骤：发帖时间显示正常");

        driver.findElement(By.id("iv_post_main_pic")).click();
        Assert.assertEquals("帖子图片跳转正常",POST_DETAIL_ACTIVITY,driver.currentActivity().toString());
        System.out.println("步骤：帖子跳转正常");

        SwipeUtil.swipeToDown(driver,1000);
        SwipeUtil.swipeToDown(driver,1000);
        driver.sendKeyEvent(4);
        System.out.println("步骤：帖子数据正常");

        SwipeUtil.swipeToUp(driver,1000);
        String like_count=driver.findElement(By.id("tv_like_count")).getText();
        System.out.println("步骤：帖子like数"+like_count);
        String comment_count=driver.findElement(By.id("tv_comment_count")).getText();
        System.out.println("步骤：帖子comment数"+comment_count);

        tearDown();
    }


}
