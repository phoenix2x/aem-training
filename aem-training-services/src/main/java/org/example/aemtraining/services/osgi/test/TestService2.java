package org.example.aemtraining.services.osgi.test;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.scripting.api.BindingsValuesProvider;

import javax.script.Bindings;

/**
 */
@Component(immediate = true)
@Service
public class TestService2 extends TestService1 implements BindingsValuesProvider {

    @Reference
    private SlingRepository resolverFactory;

    @Override
    public void addBindings(Bindings bindings) {
//        if (resolverFactory != null) {
//            System.out.println("qw");
//        }
//        System.out.println("qw");
        //test1_1
    }
}
