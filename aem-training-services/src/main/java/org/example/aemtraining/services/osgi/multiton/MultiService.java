package org.example.aemtraining.services.osgi.multiton;


import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;

import java.util.Map;

/**
 *
 */
@Component(immediate = true, metatype = true, configurationFactory = true, policy = ConfigurationPolicy.REQUIRE)
@Service(MultiService.class)
public class MultiService {
    @Property(value = "test1")
    public static final String TEST_PROP = "singleTestProp";
    @Property(value = {"testArrEl1", "testArrEl2"}, unbounded = PropertyUnbounded.ARRAY)
    public static final String TEST_PROP_Array = "testArray";
    private String testProp;

    @Activate
    protected void activate(Map<String, Object> params) {
        testProp = PropertiesUtil.toString(params.get(TEST_PROP), "");
    }
}
