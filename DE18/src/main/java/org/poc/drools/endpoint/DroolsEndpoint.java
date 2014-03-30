package org.poc.drools.endpoint;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;
import org.poc.drools.model.DroolsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DroolsEndpoint {

    private KnowledgeBase kbase;
    private String location;

    private static final Logger LOG = LoggerFactory.getLogger(DroolsEndpoint.class);

    // OK NCSS|ReturnCountCheck {
    public void executeProductSortOrderProcess(DroolsModel droolsModel) {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newFileResource(location), ResourceType.DTABLE);
        kbase = kbuilder.newKnowledgeBase();
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        ksession.insert(droolsModel);
        ksession.fireAllRules();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // }
}
