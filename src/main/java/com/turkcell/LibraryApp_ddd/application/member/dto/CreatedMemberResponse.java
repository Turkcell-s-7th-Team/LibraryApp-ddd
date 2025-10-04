package com.turkcell.LibraryApp_ddd.application.member.dto;

import java.time.LocalDate;
import java.util.UUID;

public record CreatedMemberResponse(UUID id,
                                    String name,
                                    String surname,
                                    String email,
                                    String phone,
                                    String address,
                                    LocalDate membershipDate,
                                    String membershipLevel) {
}
