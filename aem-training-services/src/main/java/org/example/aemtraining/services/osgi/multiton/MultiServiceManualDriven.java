package org.example.aemtraining.services.osgi.multiton;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;

import java.util.Map;

/**
 */
@Component(name=MultiServiceManualDriven.MULTITON_NAME, immediate = true, metatype = true, policy = ConfigurationPolicy.REQUIRE)
@Properties({
        @Property(name = MultiServiceManualDriven.TEST_PROP_NAME, value = "testPropVal")
})
public class MultiServiceManualDriven {
    public static final String MULTITON_NAME = "org.example.aemtraining.services.osgi.multiton.MultiServiceManualDriven";
    public static final String TEST_PROP_NAME = "testProp";

    private String testProp;

    @Activate
    protected void activate(Map<String, Object> params) {
        testProp = PropertiesUtil.toString(params.get(TEST_PROP_NAME), "defValue");
    }

}
