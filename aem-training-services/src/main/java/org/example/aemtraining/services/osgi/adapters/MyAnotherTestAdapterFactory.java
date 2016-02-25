package org.example.aemtraining.services.osgi.adapters;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;

import java.util.Map;

/**
 */
@Component
@Service
@Properties({
        @Property(name = "adapters", value = {MyTestAdapterFactory.MY_TEST_BEAN}),
        @Property(name = "adaptables", value = {"java.util.Map"})
})
public class MyAnotherTestAdapterFactory implements AdapterFactory {
    public static final String MY_TEST_BEAN = "org.example.aemtraining.services.osgi.adapters.MyTestBean";

    @Override
    public <AdapterType> AdapterType getAdapter(Object o, Class<AdapterType> adapterTypeClass) {
        Map<String, Object> adapteeMap = (Map<String, Object>) o;
        String adaptTo = (String) adapteeMap.get("adaptTo");
//        if (adaptTo != null && MY_TEST_BEAN.equals(adaptTo)) {
//            MyTestBean bean = new MyTestBean();
//            bean.setProp1((String) adapteeMap.get("prop1"));
//            bean.setProp2(this.getClass().getName());
//            return (AdapterType) bean;
//        }
        return null;
    }
}
