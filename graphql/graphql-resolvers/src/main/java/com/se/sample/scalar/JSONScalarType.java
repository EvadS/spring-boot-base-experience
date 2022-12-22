package com.se.sample.scalar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.Coercing;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

@Component
public class JSONScalarType extends GraphQLScalarType {

    public JSONScalarType() {
        super("JSON", "JSON value", new Coercing<String, JsonNode>()
        {
            @Override
            public JsonNode serialize(Object input)
            {
                JsonNode serializedValue = null;
                try
                {
                    if(input instanceof String) {
                        serializedValue = new ObjectMapper().readTree((String)input);
                    }
                    else
                    {
                        throw new CoercingSerializeException("Unsupported input type.");
                    }
                }
                catch(Exception e)
                {
                    throw new CoercingSerializeException(e);
                }

                return serializedValue;
            }

            @Override
            public String parseValue(Object input)
            {
                // not used
                return null;
            }

            @Override
            public String parseLiteral(Object input)
            {
                // not used
                return null;
            }

        });
    }
}
