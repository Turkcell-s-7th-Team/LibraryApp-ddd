package com.turkcell.LibraryApp_ddd.application.member.dto;

import java.time.LocalDate;

public record MemberResponse(String name,
                             String surname,
                             String email,
                             String phone,
                             String address,
                             LocalDate membershipDate,
                             String membershipLevel) {
}
