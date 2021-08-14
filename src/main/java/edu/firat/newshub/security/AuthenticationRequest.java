package edu.firat.newshub.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "AuthenticationRequest [username=" + username + ", password=" + password + "]";
    }

}
