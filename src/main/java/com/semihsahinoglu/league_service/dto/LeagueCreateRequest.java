package com.semihsahinoglu.league_service.dto;

import jakarta.validation.constraints.NotBlank;

public record LeagueCreateRequest(

        @NotBlank(message = "League name cannot be blank")
        String name,

        @NotBlank(message = "League country cannot be blank")
        String country,

        String logoUrl

) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String country;
        private String logoUrl;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder logoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
            return this;
        }

        public LeagueCreateRequest build() {
            return new LeagueCreateRequest(name, country, logoUrl);
        }
    }
}
