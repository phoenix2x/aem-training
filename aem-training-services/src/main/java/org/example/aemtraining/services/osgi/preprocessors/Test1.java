package org.example.aemtraining.services.osgi.preprocessors;

import org.apache.felix.scr.annotations.*;

/**
 */
@Component(immediate = true, metatype = true)
@Service
@Properties({
        @Property(name="testProp", value = "test1")
})
public class Test1 implements TestInter {

    @Property(value = "test1")
    public static final String TEST_PROP = "singleTestProp";
    @Property(value = {"testArrEl1", "testArrEl2"}, unbounded = PropertyUnbounded.ARRAY)
    public static final String TEST_PROP_Array = "testArray";
    @Override
    public void test() {

    }

}
