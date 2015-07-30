package org.example.aemtraining.services.osgi.preprocessors;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

/**
 */
@Component(immediate = true, metatype = true)
@Service
@Properties({
        @Property(name = "testProp", value = "test2")
})
public class Test2 implements TestInter {

    @Property(value = "test2")
    public static final String TEST_PROP = "singleTestProp";
    @Override
    public void test() {

    }
}
