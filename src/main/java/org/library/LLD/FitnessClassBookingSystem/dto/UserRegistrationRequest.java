package org.library.LLD.FitnessClassBookingSystem.dto;

import org.library.LLD.FitnessClassBookingSystem.enums.UserTier;

public class UserRegistrationRequest {
    private String name;
    private String email;
    private String password;
    private UserTier tier;

    public UserRegistrationRequest(String name, String email, String password, UserTier tier) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserTier getTier() {
        return tier;
    }
}
