package com.green.org.demomapstruct.entity;

import com.green.org.demomapstruct.entity.identity.BaseIdentity;
import com.green.org.demomapstruct.entity.identity.CategoryIdentity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity implements Serializable {

    @EmbeddedId
    private CategoryIdentity id;

    private String name;

    private String type;

    @Override
    public BaseIdentity getIdentity() {
        return this.id;
    }
}

