package com.markswell.payment.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.errors.SerializationException;
import com.markswell.payment.adapters.out.message.SaleMessage;

import static java.util.Objects.isNull;
import static java.nio.charset.StandardCharsets.UTF_8;

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
