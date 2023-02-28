package com.evy.config;


import com.evy.converter.BrowserTypeConverter;
import com.evy.enums.BrowserType;
import org.aeonbits.owner.Config;

@Config.Sources("file:${user.dir}/src/main/resources/config.properties")
public interface FrameworkConfig extends Config {
    @DefaultValue("CHROME")
    @ConverterClass(BrowserTypeConverter.class)
    BrowserType browserType();

    int implicitTime();

    int explicitTime();

    int pageLoadTime();

    String url();


}
