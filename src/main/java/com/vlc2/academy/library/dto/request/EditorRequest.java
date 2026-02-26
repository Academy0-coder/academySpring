package com.vlc2.academy.library.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



// Dto that represents an editor passed as a request
// This Dto is only meant for creation of new records


@Getter
@Setter
@AllArgsConstructor
public class EditorRequest {

    private String name;
    private String email;
}
