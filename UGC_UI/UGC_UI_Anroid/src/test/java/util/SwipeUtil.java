package util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;


public class SwipeUtil {


    public static void swipeToUp(AndroidDriver driver, int during){
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width/2, height*3/4, width/2 , height/4, during);
        System.out.println("完成上滑");
        BaseUtil.sleep();
    }

    //有效
    public static void swipeToDown(AndroidDriver driver, int during){
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width/2, height/4, width/2 , height*3/4, during);
        System.out.println("完成下滑");
        BaseUtil.sleep();

    }

    public static void swipeToLeft(AndroidDriver driver, int during){
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width-10 , height/2, width/4, height/2, during);
        System.out.println("完成左滑");
        BaseUtil.sleep();
    }

    //有效
    public static void swipeToRight(AndroidDriver driver, int during){
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(10, height/2, width*3/4+10, height/2, during);
        System.out.println("完成右滑");
        BaseUtil.sleep();
    }


    //有效
    public static void scrollup(AndroidDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
        System.out.println("完成上滑");
        BaseUtil.sleep();
    }


    //有效
    public static void scrolldown(AndroidDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: scroll", scrollObject);
        System.out.println("完成下滑");
        BaseUtil.sleep();
    }

    //有效
    public static void scrollright(AndroidDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "left");
        js.executeScript("mobile: scroll", scrollObject);
        System.out.println("完成右滑");
        BaseUtil.sleep();
    }

    //有效
    public static void scrollleft(AndroidDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "right");
        js.executeScript("mobile: scroll", scrollObject);
        System.out.println("完成左滑");
        BaseUtil.sleep();
    }

    public static void scroll(AndroidDriver driver){
        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToUp(driver,1000);
        SwipeUtil.swipeToUp(driver,1000);

    }

}
