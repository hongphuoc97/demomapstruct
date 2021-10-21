package com.green.org.demomapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDto {

    protected Date createdAt;

    protected Long creatorUserUid;

    protected String creatorUsername;

    protected Date updatedAt;

    protected Long updatorUserUid;

    protected String updatorUsername;

    protected boolean isDeleted = false;
}