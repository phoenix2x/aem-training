package org.example.aemtraining.services.osgi.queries;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.facets.Bucket;
import com.day.cq.search.facets.Facet;
import com.day.cq.search.result.SearchResult;
import com.google.common.collect.Maps;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;
import java.util.Map;

/**
 */
@Component(immediate = true)
@Service(QueryBuilderTest.class)
public class QueryBuilderTest {

    public void testBuilder(SlingHttpServletRequest request) throws RepositoryException {
        QueryBuilder queryBuilder = request.getResourceResolver().adaptTo(QueryBuilder.class);
        Map<String, String> predicates = Maps.newHashMap();
        predicates.put("type", "cq:Page");
        predicates.put("path", "/content/aem-training");
        predicates.put("property", "jcr:content/sling:resourceType");
        Query query = queryBuilder.createQuery(PredicateGroup.create(predicates), request.getResourceResolver().adaptTo(Session.class));
        SearchResult searchResult = query.getResult();
        for (Map.Entry<String, Facet> entry: searchResult.getFacets().entrySet()) {
            String key = entry.getKey();
            Facet facet = entry.getValue();
            if (facet.getContainsHit()) {
                List<Bucket> buckets = facet.getBuckets();
                Bucket bucket = buckets.get(0);
                bucket.getValue();
                bucket.getPredicate();
            }
            System.out.println("w");
        }
    }
}
