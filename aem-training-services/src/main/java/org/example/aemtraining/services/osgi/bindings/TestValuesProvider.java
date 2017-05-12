package org.example.aemtraining.services.osgi.bindings;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.scripting.api.BindingsValuesProvider;
import org.example.aemtraining.services.osgi.nashorn.TestNashorn;


import javax.script.Bindings;

/**
 */
@Component(immediate = true)
@Service
@Properties({
        @Property(name = "javax.script.name", value = "velocity")
})
public class TestValuesProvider implements BindingsValuesProvider{

    @Reference
    private TestNashorn testNashorn;
    @Override
    public void addBindings(Bindings bindings) {
//        bindings.put("testVar", "testValue");
//        bindings.put("testNashorn", testNashorn);
    }

}
