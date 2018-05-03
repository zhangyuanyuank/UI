package ui.base;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import ui.fanZone.FeedTest;
import ui.fanZone.HapFriTest;
import ui.fanZone.ItaoBlogTest;
import ui.fanZone.RankTest;
import ui.live.LiveLpTest;
import ui.profile.EditTest;
import ui.storeclub.Deal;
import ui.storeclub.NewArr;
import ui.storeclub.New;
import ui.storeclub.Trend;


public class JunitRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(FeedTest.class,HapFriTest.class,ItaoBlogTest.class,RankTest.class,LiveLpTest.class,EditTest.class,NewArr.class, Deal.class,New.class, Trend.class);
        for (Failure fail : result.getFailures()) {
			System.out.println(fail.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests finished successfully...");
		}
	}
}