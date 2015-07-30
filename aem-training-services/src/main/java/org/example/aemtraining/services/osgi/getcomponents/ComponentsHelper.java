package org.example.aemtraining.services.osgi.getcomponents;

import java.io.IOException;
import java.util.Dictionary;

/**
 */

public interface ComponentsHelper {

    Dictionary getComponentsProperties(String name) throws IOException;
    Dictionary getComponentPropsUsingScr(String name);
}
