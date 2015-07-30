package org.example.aemtraining.services.osgi.bindings;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.HashMap;

/**
 */
@Component(immediate = true)
@Service
public class TestMapValuesProvider extends HashMap<String, Object> {
    public TestMapValuesProvider() {
        super();
        put("testMapVar", "testMapValue");
    }
}
