package com.markswell.orchestrator.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.markswell.orchestrator.adapter.out.message.SaleMessage;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.isNull;

public class CustomDeserializer implements Deserializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SaleMessage deserialize(String topic, byte[] data) {
        try{
            if(isNull(data)) {
                return null;
            }
            return objectMapper.readValue(new String(data, UTF_8), SaleMessage.class);
        } catch(Exception e) {
            throw new SerializationException("Error when try deserialize SaleMessage");
        }
    }
}
