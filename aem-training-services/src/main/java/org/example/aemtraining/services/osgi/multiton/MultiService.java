package org.example.aemtraining.services.osgi.multiton;


import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;

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

    @Property(description = "Off - do not use versioned libs, Versioned - use versioned libs w/o minimization, Minimized - use versioned libs with minimization",
                label = "Transformation", value = "Versioned", options  = {
                        @PropertyOption(name = "OFF", value = "Off"),
                        @PropertyOption(name = "VERSIONED", value = "Versioned"),
                        @PropertyOption(name = "MINIMIZED", value = "Minimized")
                    })
    private static final String PROP_MINIFY = "versionedClientlibsTransformerFactory.minify";
    private TransformationType transformationType;
    public enum TransformationType {
        OFF, VERSIONED, MINIMIZED;
        public boolean isTransform() {
            return this == VERSIONED || this == MINIMIZED;
        }
        public boolean isMinify() {
            return this == MINIMIZED;
        }
    }

    @Activate
    protected void activate(ComponentContext context) {
        //test change after push 2
        transformationType = TransformationType.valueOf(PropertiesUtil.toString(context.getProperties().get(PROP_MINIFY), "OFF"));
        testProp = PropertiesUtil.toString(context.getProperties().get(TEST_PROP), "");
    }
}
