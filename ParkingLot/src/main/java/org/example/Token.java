package org.example;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Token {
    private UUID tokenUUID;

    public Token(){
        tokenUUID = UUID.randomUUID();
    }

    public boolean isUUIDEqual(UUID uuid){
        return uuid.equals(this.tokenUUID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(tokenUUID, token.tokenUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenUUID);
    }
}
