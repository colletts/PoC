package org.poc.aggregator;

import org.apache.camel.Exchange;
import org.apache.camel.Property;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: cam
 * Date: 28/03/14
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class BodyInAggregatingStrategy implements AggregationStrategy{


    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);
        oldExchange.getIn().setBody(oldBody + "+" + newBody);
        return oldExchange;
    }

    /**
     * An expression used to determine if the aggregation is complete
     */
    public boolean isCompleted(@Property(Exchange.AGGREGATED_SIZE) Integer aggregated) {
        if (aggregated == null) {
            return false;
        }

        return aggregated == 3;
    }

}
