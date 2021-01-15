package com.tcramer.anubis.model;

import java.util.Arrays;

public enum KeyType {
    UP(1, "UP")
    ;

    private final Integer keyTypeId;
    private final String value;
    KeyType(Integer keyTypeId, String value) {
        this.keyTypeId = keyTypeId;
        this.value = value;
    }

    public KeyType getKeyTypeById(Integer keyTypeId) {
        KeyType keyType = null;
        for(KeyType type : KeyType.values()) {
            if (type.keyTypeId == keyTypeId) {
                keyType = type;
            }
        }
        return keyType;
    }
}
