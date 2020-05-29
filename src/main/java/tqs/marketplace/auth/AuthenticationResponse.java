package tqs.marketplace.auth;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    private final String jwt;
    private final long id;

    public AuthenticationResponse(String jwt,long id) {
        this.jwt = jwt;
        this.id = id;
    }
    public String getJwt() {
        return jwt;
    }

    public long getId() {
        return id;
    }
}
