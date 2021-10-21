package com.green.org.demomapstruct.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@RequiredArgsConstructor
@AllArgsConstructor
public class CategoryResDto extends BaseDto{

    private Long id;
    private String name;
}