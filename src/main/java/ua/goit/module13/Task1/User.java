package ua.goit.module13.Task1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    @Data
    @Builder
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public Address(String street, String suite, String city, String zipcode, Geo geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        @Data
        @Builder
        public static class Geo {
            private String lat;
            private String lng;

            public Geo(String lat, String lng) {
                this.lat = lat;
                this.lng = lng;
            }
        }
    }

    @Data
    @Builder
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

    public User(Long id, String name, String username, String email,
                Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }
}
