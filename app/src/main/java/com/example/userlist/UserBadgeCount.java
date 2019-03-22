package com.example.userlist;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
class UserBadgeCount {
    @JsonProperty("bronze")
    int bronze;
    @JsonProperty("silver")
    int silver;
    @JsonProperty("gold")
    int gold;

    public UserBadgeCount() {

    }
}
