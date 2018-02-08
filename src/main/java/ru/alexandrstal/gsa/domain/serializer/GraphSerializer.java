package ru.alexandrstal.gsa.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.alexandrstal.gsa.domain.Graph;

import java.io.IOException;

public class GraphSerializer extends StdSerializer<Graph> {

    public GraphSerializer() {
        this(null);
    }

    public GraphSerializer(Class<Graph> t) {
        super(t);
    }

    @Override
    public void serialize(Graph value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeNumberField("from", value.getFrom().getId());
        jgen.writeNumberField("to", value.getTo().getId());
        jgen.writeStringField("code", value.getOperation().getCode());
        jgen.writeStringField("name", value.getOperation().getName());
        jgen.writeObjectField("operation", value.getOperation());
        jgen.writeEndObject();
    }
}
