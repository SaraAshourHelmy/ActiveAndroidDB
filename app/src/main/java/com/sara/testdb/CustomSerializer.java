package com.sara.testdb;

import com.activeandroid.serializer.TypeSerializer;

import java.util.Date;

/**
 * Created by Bassem on 7/14/2016.
 */
public class CustomSerializer extends TypeSerializer {

    // this class for simplify date to long to make easy save and retrieve from db

    // this will retrieve from db
    @Override
    public  Class<?> getDeserializedType() {
        return Date.class;
    }

    // this will save in db
    @Override
    public Class<?> getSerializedType() {
        return Long.class;
    }

    @Override
    public Long serialize(Object data) {
        if (data == null) {
            return null;
        }
        return ((Date) data).getTime();
    }

    @Override
    public Date deserialize(Object data) {
        if (data == null) {
            return null;
        }
        return new Date((Long) data);
    }
}
