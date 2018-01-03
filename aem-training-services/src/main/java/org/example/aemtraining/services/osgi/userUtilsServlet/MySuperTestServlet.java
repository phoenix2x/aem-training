package org.example.aemtraining.services.osgi.userUtilsServlet;

import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 */
@SlingServlet(paths = {"/bin/mytestservlet"}, metatype = true)
@Properties({
        @Property(name = "testPR", value = "testVal")
})
public class MySuperTestServlet extends SlingAllMethodsServlet {

//    @Reference
//    private ComponentsHelper componentsHelper;
//
//    @Reference
//    private AdapterManager adapterManager;
//
//    @Reference
//    private ComponentTester componentTester;
//
//    @Reference
//    private ResourceResolverFactory resolverFactory;
//
//    @Reference
//    private MessageGatewayService messageGatewayService;
//
//    @Reference
//    private Scheduler scheduler;
//
//    @Reference
//    private RunMode runMode;
//
//    @Reference
//    private Externalizer externalizer;
//
//    @Reference
//    private NodeTest nodeTest;
//
//    @Reference
//    private TestQueries testQueries;
//
//    @Reference
//    private ReplicationTest replicationTest;
//
//    @Reference
//    private QueryBuilderTest queryBuilderTest;
//
//    @Reference
//    private TagsTest tagsTest;


    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
//        componentTester.testComponents();
//        LdapTester.test();
//        workingWithWCMComponent(request, response);
//        nodeTest.test(request);
//        testQueries.test(request);
//        try {
//            queryBuilderTest.testBuilder(request);
//        } catch (RepositoryException e) {
//
//        }
//        replicationTest.test(request);
//        tagsTest.testTags(request);
//        String s = "";

//        JsonFactory jsonFactory = new JsonFactory();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonGenerator jsonGenerator = jsonFactory.createGenerator(response.getWriter());
//        objectMapper.writeValue(jsonGenerator, videos.getVideos(""));
        response.getWriter().write("test");


    }

//    private void guavaExample(String str) {
//        //interesting workaround to obtain generic type at runtime, inside TypeToken
//        Type listType = new TypeToken<List<Map<String, Integer>>>() {}.getType();
//        List<String> list = new Gson().fromJson(str, listType);
//    }
//
//    private void workingWithWCMComponent(SlingHttpServletRequest request, SlingHttpServletResponse response) {
//        ResourceResolver resolver = request.getResourceResolver();
//        Resource resource = resolver.getResource("/content/cro/en");
//        Component component = WCMUtils.getComponent(resource.getChild("jcr:content"));
//        component.getDialogPath();
//
//    }
//
//    private String getTemplateTitle(ResourceResolver resolver, Node node) throws RepositoryException {
//        PageManager pageManager = resolver.adaptTo(PageManager.class);
//        Page pageResource = pageManager.getPage(node.getPath().replace(JcrConstants.JCR_CONTENT, ""));
//        if (pageResource != null) {
//            return pageResource.getTemplate().getTitle();
//        }
//        return "";
//    }
//
//    private void componentTestAndConf(SlingHttpServletRequest request) throws IOException {
//    //        components test and configurations
//        Dictionary props = componentsHelper.getComponentsProperties(this.getClass().getName());
//        Dictionary props1 = componentsHelper.getComponentPropsUsingScr(this.getClass().getName());
//        NodeHelper.doingSmthWithNodeAndProp(request);
//    }
//
//    private void adaptersTest() {
//    //        adapters test
//        Map<String, String> adaptee = ImmutableMap.of("prop1", "val1", "prop2", "val2");
//        MyTestBean myTestBean = adapterManager.getAdapter(adaptee, MyTestBean.class);
//    }
//
//    private void adaptNodeToResource(SlingHttpServletRequest request) {
//    //        adapt node to resource
//        try {
//            List<Resource> resourceList = new ArrayList<Resource>();
//            QueryManager queryManager = request.getResource().getResourceResolver().adaptTo(Session.class).getWorkspace().getQueryManager();
//            Query query = queryManager.createQuery("/jcr:root/content", Query.XPATH);
//            NodeIterator nodeIterator = query.execute().getNodes();
//            while (nodeIterator.hasNext()) {
//                resourceList.add(adapterManager.getAdapter(nodeIterator.nextNode(), Resource.class));
//            }
//        } catch (RepositoryException e) {
//
//        }
//    }
//
//    private void mails(SlingHttpServletRequest request) throws IOException {
////        mails
//        MailTemplate mailTemplate = MailTemplate.create("/etc/notification/email/default/com.day.cq.wcm.core.page/en.txt", request.getResourceResolver().adaptTo(Session.class));
//        try {
//            HtmlEmail email = mailTemplate.getEmail(StrLookup.mapLookup(ImmutableMap.of("time", new Date(), "modifications", "testMod")), HtmlEmail.class);
//            MessageGateway<HtmlEmail> messageGateway = messageGatewayService.getGateway(HtmlEmail.class);
//            messageGateway.send(email);
//            String a = "";
//        } catch (MessagingException e) {
//        } catch (EmailException e) {
//        }
//    }
}
