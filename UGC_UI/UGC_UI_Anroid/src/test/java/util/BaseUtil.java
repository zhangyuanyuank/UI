package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseUtil extends BaseTest {

    public boolean ifExist(IOSDriver driver,String name){
        try {
            Object object=driver.findElement(By.name(name));
            if (object != null){
                System.out.println("步骤：找到"+name+"按钮，并点击");
                driver.findElement(By.name(name)).click();
                Thread.sleep(3000);
                return true;

            }else {
                System.out.println("步骤：没找到"+name+"按钮");
                return false;
            }
        }catch (Exception e){
           e.printStackTrace();
           return false;
        }

    }

    public static void sleep(){
        try{

            Thread.sleep(5000);

        }catch (Exception e) {

        }
    }
    public static void sleep(long timeInMillis){
        try{
            Thread.sleep(timeInMillis);
        }catch (Exception e) {

        }
    }
    public static boolean isControlHere(AndroidDriver driver, String controlName, long maxWaitTimeInSecond){
        for(int i=0; i<maxWaitTimeInSecond; ++i){
            WebElement control = driver.findElement(By.id(controlName));
            if(control != null){
                return true;
            }
            BaseUtil.sleep(1000);
        }
        return false;
    }

    public static void takeScreenShot(AndroidDriver driver)
    {
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("/Users/ae-sz-test/test/takeScreen/autoscreen" + getCurrentDateTime()+ ".jpg"));
        }
        catch (IOException e) {e.printStackTrace();}
    }


    public static String getCurrentDateTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");//设置日期格式
        return df.format(new Date());
    }




}
