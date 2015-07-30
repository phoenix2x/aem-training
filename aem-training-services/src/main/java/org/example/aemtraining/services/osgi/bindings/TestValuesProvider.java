package org.example.aemtraining.services.osgi.bindings;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.scripting.api.BindingsValuesProvider;


import javax.script.Bindings;

/**
 */
@Component(immediate = true)
@Service
@Properties({
        @Property(name = "javax.script.name", value = "velocity")
})
public class TestValuesProvider implements BindingsValuesProvider{
    @Override
    public void addBindings(Bindings bindings) {
//        bindings.put("testVar", "testValue");
    }

}
