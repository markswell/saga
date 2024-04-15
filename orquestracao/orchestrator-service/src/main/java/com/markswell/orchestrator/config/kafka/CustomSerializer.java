package com.markswell.orchestrator.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.errors.SerializationException;
import com.markswell.orchestrator.adapter.out.message.SaleMessage;

import static java.util.Objects.isNull;

public class CustomSerializer implements Serializer<SaleMessage> {

    private final ObjectMapper objectMapper =  new ObjectMapper();

    @Override
    public byte[] serialize(String topic, SaleMessage data) {
        try {
            if(isNull(data)) {
                return null;
            }
            return  objectMapper.writeValueAsBytes(data);
        } catch (Exception exception) {
            throw new SerializationException("Error when serializing data to byte[]");
        }
    }
}
