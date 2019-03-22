package com.example.userlist;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
class User {
    @JsonProperty("badge_counts")
    UserBadgeCount badge_counts;
    @JsonProperty("display_name")
    String display_name;
    @JsonProperty("profile_image")
    String profile_image;
    public User() {

    }
}
