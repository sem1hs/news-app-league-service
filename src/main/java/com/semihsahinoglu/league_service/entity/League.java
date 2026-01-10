package com.semihsahinoglu.league_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "league")
@DynamicUpdate
public class League extends Auditable {

    @NotBlank(message = "League name cannot be blank")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "League country cannot be blank")
    @Column(nullable = false)
    private String country;

    @Column(name = "logo_url")
    private String logoUrl;

    protected League() {
    }

    private League(Builder builder) {
        this.name = builder.name;
        this.country = builder.country;
        this.logoUrl = builder.logoUrl;
    }

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

        public League build() {
            return new League(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
