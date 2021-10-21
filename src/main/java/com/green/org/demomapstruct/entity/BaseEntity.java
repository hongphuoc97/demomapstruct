package com.green.org.demomapstruct.entity;

import com.green.org.demomapstruct.entity.identity.BaseIdentity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    @Column(name = "creator_user_uid")
    public Long creatorUserUid;

    @Column(name = "creator_user_name")
    public String creatorUsername;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;

    @Column(name = "updator_user_uid")
    public Long updatorUserUid;

    @Column(name = "updator_user_name")
    public String updatorUsername;

    @Column(name = "is_deleted")
    public boolean isDeleted = false;

    /**
     * get identity
     *
     * @return
     */
    public abstract BaseIdentity getIdentity();
}
