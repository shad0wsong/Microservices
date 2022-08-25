package com.kuzin.customer.requests;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
