package com.vlc2.academy.negozio.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public record CustomerCreateDTO(String name, String surname) { }
