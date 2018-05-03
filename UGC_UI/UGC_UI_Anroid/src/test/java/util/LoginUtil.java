package util;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;

import java.util.Objects;


public class LoginUtil extends BaseTest {


    public static void doLogin() {
        System.out.println("检查App是否登录，若没登录测试账号，执行登录操作");
        try {
            driver.findElement(By.id("left_action")).click();
            BaseUtil.sleep();
            driver.findElement(By.id("profile_name_text")).click();

            WebElement sign_in_btn = driver.findElement(By.id("btn_sign_in"));
            if (sign_in_btn != null) {
                System.out.println("app没有登录，执行登录操作");
                //登录页面的sign in文案，stroe club的sign in按钮
                driver.findElement(By.id("btn_sign_in")).click();
                BaseUtil.sleep();
            }

        } catch (Exception e) {
            System.out.println("app已经登录");
            return;

        }


//		if(!driver.getCurrentActivity().getActivityName().equals(MYACCOUNT_ACTIVITY)){
//			log.info("当前没有登录账号，登录测试账号");
//
//		}
        try {
            //Thread.sleep(3000);
//            driver.findElement(By.name("xxxhhh@163.com")).clear();
//            Thread.sleep(5000);

            System.out.println("步骤：输入帐号");
            driver.findElement(By.name("Email")).sendKeys("xxxhhh@163.com");
            BaseUtil.sleep();
            System.out.println("步骤：输入密码");
            driver.findElement(By.name("Password")).sendKeys("hello1234");

            System.out.println("步骤：点击登录");
            driver.findElement(By.name("login_btn")).click();
            BaseUtil.sleep();

            String login_name = driver.findElement(By.id("tv_profile_mail")).getText();
            System.out.println("步骤：获取当前登录账户信息" + login_name);
            BaseUtil.sleep();

            if (Objects.equals(login_name, "xxxhhh@163.com")) {
                System.out.println("步骤：自动化账号已经登录，无需进行登录");
            } else {
                System.out.println("步骤：登录的账号不是自动化账号登录，先登出，再进行登录操作");
                // 先登出
                LoginUtil.logoutApp(driver);
                // 未登录情况下，进行登录操作
                try {
                    BaseUtil.sleep();
                    LoginUtil.loginApp(driver, "xxxhhh@163.com", "hello1234");
                } catch (Exception e) {

                    BaseUtil.sleep();
                }

                // 判断是否登录成功
                LoginUtil.isLoginSuccess(driver);
                BaseUtil.sleep();
            }


        } catch (Exception e) {

            System.out.println("当前没有登录账号，登录测试账号");
            LoginUtil.loginApp(driver, "xxxhhh@163.com", "hello1234");
        }

    }


    public static void logoutApp(AndroidDriver driver) {
        System.out.println("My Account页面logout账号");
        try {
            System.out.println("步骤：首页左滑，点击退出");
            driver.findElement(By.id("left_action")).click();
            BaseUtil.sleep();

        } catch (Exception e) {
            System.out.println("步骤：当前为my account页面");
        }


//        System.out.println("步骤：左滑到设置页面");
//        driver.tap(1,55,100,1000);
//        BaseUtil.sleep(3000);
        //点击跳到设置
        BaseUtil.sleep();
        //driver.tap(1,60,109,1000);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Settings\")").click();
//        SwipeUtil.swipeToUp(driver,1000);
//        driver.tap(1,300,990,1000);

        SwipeUtil.swipeToUp(driver, 1000);
        driver.findElement(By.id("btn_login_out")).click();
        BaseUtil.sleep();

        driver.findElement(By.id("buttonDefaultPositive")).click();
        System.out.println("步骤：点击确认登出");
        BaseUtil.sleep();

    }


    public static void loginApp(AndroidDriver driver, String account, String password) {


        System.out.println("步骤：输入账号密码进行登录");
        System.out.println("步骤：判断登录popup是否弹出");
        try {
            System.out.println("步骤：左滑登录my account");
            driver.findElement(By.id("btn_sign_in")).click();
        } catch (Exception e) {
            System.out.println("步骤：没有找到my account");
        }


        try {
//            driver.findElement(By.name("xxxhhh@163.com")).clear();
//            Thread.sleep(3000);
            driver.findElement(By.id("et_email")).sendKeys(account);

            driver.findElement(By.id("et_password")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("et_password")).sendKeys(password);
            System.out.println("步骤：输入密码");

            driver.findElement(By.id("rl_ali_sign_in_btn")).click();
            BaseUtil.sleep();
            System.out.println("步骤：点击登录");
            System.out.println(account + "登录成功！！");
        } catch (Exception e) {
            System.out.println("系统异常");
        }


        //点击home，回到首页
        driver.sendKeyEvent(4);
        BaseUtil.sleep();


//        try
//        {
//            driver.getCurrentActivity().popup(0).button(By.id("button2")).click();
//        }
//        catch(Exception e)
//        {
//            info("新手引导没有了");
//        }

    }

    public static void isLoginSuccess(AndroidDriver driver) {
        System.out.println("步骤：登录成功后返回首页，进入My AliExpress,判断是否登录成功");
        System.out.println("步骤：进入首页，查看my account");

        driver.findElement(By.id("left_action")).click();
        BaseUtil.sleep();


        if (driver.findElement(By.id("profile_email_text")).getText() == "xxxhhh@163.com") {
//		if (driver.getCurrentActivity().textView(By.text("Wish List"))
//					.isVisibled()) {
            System.out.println("步骤：登录成功");
            Assert.assertTrue(true);
        } else {
            System.out.println("步骤：登录失败");
            Assert.assertTrue(true);
        }
    }


    public static void makeunLogin(AndroidDriver driver) {

        driver.findElement(By.id("left_action")).click();
        try {
            Assert.assertNotNull("未登录出错", "Sign In | Join Free");
            System.out.println("未登录帐号");
            BaseUtil.sleep();
            SwipeUtil.swipeToLeft(driver, 1000);
            BaseUtil.sleep();

        } catch (Exception e) {
            System.out.println("已登录帐号");

            LoginUtil.logoutApp(driver);
            BaseUtil.sleep();

            driver.tap(1, 560, 620, 1000);
            BaseUtil.sleep();

        }
    }


    public static void makeLogin(AndroidDriver driver) {

        //左滑确认登录
        driver.findElement(By.id("left_action")).click();
        try {
            Assert.assertNotNull("未登录出错", "Sign In | Join Free");
            System.out.println("未登录帐号");
            BaseUtil.sleep();

            driver.findElement(By.id("profile_name_text")).click();
            driver.findElement(By.id("btn_sign_in")).click();
            LoginUtil.loginApp(driver, "XXXhhh@163.com", "hello1234");
            BaseUtil.sleep();

            System.out.println("已登录帐号");
            BaseUtil.sleep();

        } catch (Exception e) {

        }
    }


    public static void click_login(AndroidDriver driver, String id, String message) {

        WebElement btn = driver.findElement(By.id(id));
        btn.click();
        Assert.assertEquals("弹登陆框失败", LOGIN_ACTIVITY, driver.currentActivity().toString());
        System.out.println(message);
        driver.sendKeyEvent(4);
        BaseUtil.sleep();

    }
}







