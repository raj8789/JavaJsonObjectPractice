package com.json.practice;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ObjectMapperSerialization extends StdSerializer<Date> {
    protected ObjectMapperSerialization(Class<Date> t) {
        super(t);
    }

    public ObjectMapperSerialization() {
        this(null);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formatteDate=inputFormat.format(date);
        jsonGenerator.writeString(formatteDate);
    }
}
