package org.example.aemtraining.services.osgi.utils;

import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;

import java.util.Dictionary;
import java.util.Properties;

/**
 * tests props with LDAP expression, can also be used to test ServiceReference
 * filter.match(ServiceReference serviceRefernce)
 */

public class LdapTester {
    public static void test() {
        try {

            Filter filter = FrameworkUtil.createFilter("(testProp=testValue)");
            Properties props = new Properties();
            props.put("key1", "val1");
            props.put("key2", "val2");
            props.put("testProp", "testValue");
            filter.match(props);
            System.out.println("q");
        } catch (InvalidSyntaxException e) {
        }
    }
}
