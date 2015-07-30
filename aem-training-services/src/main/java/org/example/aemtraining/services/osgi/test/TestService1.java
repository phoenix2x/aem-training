package org.example.aemtraining.services.osgi.test;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.scripting.api.BindingsValuesProvider;
import org.example.aemtraining.services.osgi.utils.Include;

import javax.script.Bindings;

/**
 */
@Component(immediate = true)
@Service
public class TestService1 implements BindingsValuesProvider {

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Override
    public void addBindings(Bindings bindings) {
        bindings.put("include", new Include(bindings));
//        System.out.println("q");
    }
}
