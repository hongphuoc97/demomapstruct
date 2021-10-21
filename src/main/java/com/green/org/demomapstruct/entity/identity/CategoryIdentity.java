package com.green.org.demomapstruct.entity.identity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryIdentity extends BaseIdentity {

    @Column(name = "id", insertable = false, nullable = false)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryIdentity that = (CategoryIdentity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        String s = new String("sss");
        s.hashCode();
        return Objects.hash(id);
    }
}
