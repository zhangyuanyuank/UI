package ui.base;

import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.BaseUtil;
import util.SwipeUtil;

import java.net.URL;
import java.util.Set;

public class BaseTest {
    public static AndroidDriver driver;

    //所有的activity
    public static final String  LOGIN_ACTIVITY="com.aliexpress.sky.user.ui.SkyLoginActivity";
    public static final String  STORE_ACTIVITY=".module.sellerstore.SellerStoreActivity";
    public static final String  COMMENT_LIST_ACTIVITY="com.alibaba.ugc.modules.comment.view.CommentActivity";
    public static final String  PRODUCT_DETAIL_ACTIVITY=".module.product.detail.ProductDetailActivity";
    public static final String  STORE_TOPIC_ACTIVITY="com.alibaba.ugc.modules.shopnews.view.activity.StoreTopicActivity";
    public static final String  LIKE_LIST_ACTIVITY="com.alibaba.ugc.modules.like.view.activity.LikeListActivity";
    public static final String  STORE_PRODUCTLIST_ACTIVITY="com.alibaba.ugc.modules.shopnews.view.activity.StoreProductListActivity";
    public static final String  PROFILE_ACTIVITY="com.alibaba.ugc.modules.profile.view.UGCProfileActivity";
    public static final String  HOME_SPOTLIST_ACTIVITY="com.alibaba.ugc.modules.mastershow.view.HomeSpotlightListActity";
    public static final String  HOME_SPOT_ACTIVITY="com.alibaba.ugc.modules.mastershow.view.HomeSpotlightActity";
    public static final String  POST_DETAIL_ACTIVITY="com.alibaba.ugc.modules.postdetail.view.activity.UGCPostDetailActivity";
    public static final String  LIVESCHEDULE_ACTIVITY="com.alibaba.aliexpress.live.view.LiveTimeScheduleActivity";
    public static final String  LIVELANDING_ACTIVITY="com.alibaba.aliexpress.live.view.LiveLandingActivity";
    public static final String  HAPPYFRIDAY_ACTIVITY="com.alibaba.ugc.modules.happyfriday.view.HappyFridayActivity";
    public static final String  FANZONE_HONE_ACTIVITY="com.alibaba.ugc.modules.fanzone.view.FanZoneHomeActivity";
    public static final String  COLLAGE_PUBLISH_ACTIVITY="com.alibaba.ugc.modules.collection.view.activity.CollagePublishActivity";
    public static final String  ARTICLE_PUBLISH_ACTIVITY="com.alibaba.ugc.modules.article.view.activity.UGCArticlePostPublishActivity";
    public static final String  SELECT_COUPON_ACTIVITY=".module.marketing.MySelectCouponActivitiy";
    public static final String  WEBVIEW_ACTIVITY="com.alibaba.support.webview.SimpleWebViewActivity";
    public static final String  CHANNELSHELL_ACTIVITY="com.alibaba.ugc.modules.floor.channel.ChannelShellActivity";
    public static final String  PEPOLE_FAVORITE="com.alibaba.support.webview.SimpleWebViewActivity";


    @Before
    public  void  setUp() throws Exception {


        System.out.println("启动应用");
        // TODO Auto-generated method stub

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //自动化设备
//        capabilities.setCapability("deviceName", "Android Device");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "4.3");
//        capabilities.setCapability("app", "/Users/ae-sz-test/env/AndroidSDK/platform-tools/AliExpressHD-play-debug.apk");
//        capabilities.setCapability("app", "/Users/ae-sz-test/env/AndroidSDK/platform-tools/AliExpressHD-play-release.apk");
//        capabilities.setCapability("appPackage", "com.alibaba.aliexpresshd");
//        capabilities.setCapability("utdid", "Appium");
//        capabilities.setCapability("automationName", "Selendroid");



        //调试设备
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", "/Users/wb-zhangyuanyuan.k/AppData/Local/Android/Sdk/platform-tools/AliExpressApp-play-release.apk");
        capabilities.setCapability("appPackage", "com.alibaba.aliexpresshd");
        capabilities.setCapability("utdid", "Appium");



        // 根据 Desired Capabilities 打开应用
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            // 什么都不做，程序暂停5秒
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            driver.findElement(By.id("buttonDefaultNegative")).click();
            System.out.println("取消升级");
        }catch (Exception e){
            System.out.println("系统异常");
        }

        try{
            //driver.tap(1,538,1600,1000);
            driver.tap(1,728,2117,1000);
            System.out.println("点击h5弹框");
            driver.sendKeyEvent(4);

        }catch (Exception e){

        }
//
//        try{
//            //driver.tap(1,538,1600,1000);
//            driver.tap(1,1304,135,1000);
//            System.out.println("关闭h5弹框");
//
//        }catch (Exception e){
//
//        }



    }


    @After
    public void tearDown() throws Exception {
        System.out.println("关闭应用");
        driver.quit();
    }




}
