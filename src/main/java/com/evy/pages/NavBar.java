package com.evy.pages;

import com.evy.enums.NavBarType;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import static com.evy.utils.SeleniumUtils.click;


public class NavBar {


    @SneakyThrows
    public <T> T setNavBar(String navBarValue, Class<T> cls) {
        String m = "//div[@id='navbarColor01']//li//a[text()='%s']";
        String value = String.format(m, navBarValue);
        click(By.xpath(value), navBarValue);
        return cls.getDeclaredConstructor().newInstance();
    }

}
