package com.Serialize;

import com.dao.model.Group;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.util.Set;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2018-05-10
 * Copyright  "Commercegate LTD"
 */
public class GroupSerialie extends JsonSerializer<Set<Group>> {

    @Override
    public void serialize(Set<Group> groups, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        for (Group group: groups) {
            System.out.print("ljk");
        }
    }
}
