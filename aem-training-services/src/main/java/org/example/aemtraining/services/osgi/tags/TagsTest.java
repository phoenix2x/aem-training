package org.example.aemtraining.services.osgi.tags;

import com.day.cq.tagging.JcrTagManagerFactory;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.Node;
import javax.jcr.Session;

/**
 */
@Component(immediate = true)
@Service(TagsTest.class)
public class TagsTest {

    @Reference
    private JcrTagManagerFactory managerFactory;

    public void testTags(SlingHttpServletRequest request) {
        ResourceResolver resolver = request.getResourceResolver();
        TagManager tagManager = resolver.adaptTo(TagManager.class);
        PageManager pageManager = resolver.adaptTo(PageManager.class);

        Page page = pageManager.getPage("/content/cro/en/electronics-computers/22-ways-to-go-green-for-earth-day");
//        Tag[] tags = tagManager.getTags(page.getContentResource());
        Tag[] tags = page.getTags();
        Tag tag = tags[0];
        System.out.println("q");
    }
}
