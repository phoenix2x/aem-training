package org.example.aemtraining.services.osgi.nashorn;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.script.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 */

@Component(immediate = true)
@Service(TestNashorn.class)
public class TestNashorn {

    private static final String DEFAULT_NASHORN_ENGINR_FACTORY_CLASS = "jdk.nashorn.api.scripting.NashornScriptEngineFactory";
    private static final Logger LOG = LoggerFactory.getLogger(TestNashorn.class);

    @Reference
    private ResourceResolverFactory factory;

    public String render() throws ScriptException, NoSuchMethodException, LoginException, RepositoryException {
        ScriptEngine engine = new jdk.nashorn.api.scripting.NashornScriptEngineFactory().getScriptEngine();
//        engine.eval("function test(){return 'Hello';}");
        engine.eval(new InputStreamReader(getFile("/etc/designs/aem-training/scripts/gnav.js")));

        Invocable invocable = (Invocable) engine;

        Object result = invocable.invokeFunction("gnav", getData());
        LOG.error("QQ", result);
        return (String) result;
    }

    public String getGnav() throws LoginException, NoSuchMethodException, RepositoryException, ScriptException {
        return render();
    }

    @Activate
    public void activate() {

    }

    private Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("config", new HashMap<String, Object>());
        data.put("prop", "val");
        return data;
    }

    public InputStream getFile(String path) throws LoginException, RepositoryException {
        return factory.getAdministrativeResourceResolver(null)
                .getResource(path)
                .adaptTo(Node.class)
                .getNode("jcr:content")
                .getProperty("jcr:data")
                .getBinary()
                .getStream();
    }


}
