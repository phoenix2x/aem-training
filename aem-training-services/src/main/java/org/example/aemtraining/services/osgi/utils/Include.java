package org.example.aemtraining.services.osgi.utils;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScript;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.api.servlets.ServletResolver;

import javax.script.Bindings;

/**
 */

public class Include {
    private Bindings itsBuindings;
    public Include(Bindings slingBindings) {
        itsBuindings = slingBindings;
    }

    public String getScript() {
        SlingScriptHelper slingScriptHelper = (SlingScriptHelper) itsBuindings.get("sling");
        ServletResolver servletResolver = slingScriptHelper.getService(ServletResolver.class);
        Resource suffixResource = ((SlingHttpServletRequest) itsBuindings.get("request")).getRequestPathInfo().getSuffixResource();
        SlingBindings slingBindings = new SlingBindings();
//        slingBindings.putAll(itsBuindings);
//        slingBindings.remove(SlingBindings.SLING);
//        slingBindings.remove(SlingBindings.OUT);
        slingBindings.setRequest(slingScriptHelper.getRequest());
        slingBindings.setResponse(slingScriptHelper.getResponse());
        suffixResource.adaptTo(SlingScript.class).eval(slingBindings);
        System.out.println("q");
        return "q";
    }
}
