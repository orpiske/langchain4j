package dev.langchain4j.ingestion.camel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.query.Query;
import org.apache.camel.Component;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

public class CamelContentRetriever implements ContentRetriever {

    @Override
    public List<Content> retrieve(Query query) {
        return null;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static EndpointBuilder endpointBuilder() {
        return new EndpointBuilder();
    }

    public static class Builder {
        private Component component;
        private EndpointBuilder endpointBuilder;

        public Builder withComponent(Component component) {
            this.component = component;
            return this;
        }

        public Builder withEndpoints(Map<String, EndpointRouteBuilder> endpoints) {
            for (Map.Entry<String, EndpointRouteBuilder> entry : endpoints.entrySet()) {
                final String routeId = entry.getKey();
                final EndpointRouteBuilder routeBuilder = entry.getValue();

            }

            return this;
        }

        public Builder withEndpointBuilder(EndpointBuilder endpointBuilder) {
            this.endpointBuilder = endpointBuilder;
            return this;
        }


//        public Builder withFromEndpoint(String routeId, EndpointConsumerBuilder endpointConsumerBuilder) {
//            EndpointRouteBuilder routeBuilder = routes.get(routeId);
//
//            routeBuilder.from(endpointConsumerBuilder);
//            return this;
//        }
    }

    public static class EndpointBuilder {
        private Map<String, EndpointRouteBuilder> source = new HashMap<>();

        public EndpointRouteBuilder newSource(String routeId) {
            EndpointRouteBuilder routeBuilder = new EndpointRouteBuilder() {
                @Override
                public void configure() throws Exception {

                }
            };

            source.put(routeId, routeBuilder);
            return routeBuilder;
        }

        public EndpointBuilder withSource(String routeId, EndpointConsumerBuilder endpointConsumerBuilder) {
            EndpointRouteBuilder routeBuilder = source.get(routeId);

            routeBuilder.from(endpointConsumerBuilder);

            return this;
        }

        Map<String, EndpointRouteBuilder> build() {
            return source;
        }
    }


}
