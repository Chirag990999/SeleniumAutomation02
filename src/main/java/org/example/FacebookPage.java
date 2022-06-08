package org.example;

import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class FacebookPage extends Utils{
    public void verifyFacebookUrlAndHandlePopUPWindow() {
        //Object create for MainWindow Handle
        String MainWindow = driver.getWindowHandle();

        //To Handle new opened child window
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase( ChildWindow )) {
                //Switching to Child Window
                driver.switchTo().window( ChildWindow );
                String URL = driver.getCurrentUrl();
                Assert.assertEquals( URL, "https://www.facebook.com/nopCommerce", "URL is not verified" );
                //Closing The Child Window
                driver.close();
            }
        }
        //Switching To The Main Window
        driver.switchTo().window( MainWindow );
    }
}
