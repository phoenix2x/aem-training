package org.example.aemtraining.services.osgi.reverenceproviders;

import com.day.cq.wcm.api.reference.Reference;
import com.day.cq.wcm.api.reference.ReferenceProvider;
import com.google.common.collect.ImmutableList;
import org.apache.sling.api.resource.Resource;

import java.util.List;

/**
 * used by page activation process to show all related content wich need to be activated. tags, images etc.
 */

public class TestReferenceProvider implements ReferenceProvider {
    @Override
    public List<Reference> findReferences(Resource resource) {
        return ImmutableList.of(new Reference("type", "message or name", resource, Long.MAX_VALUE));
    }
}
