package com.kun.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity @IdClass(value = AuthorityId.class)
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "authority")
    private String authority;

    @Id
    @ManyToOne
    @JoinColumn(name = "username")
    private Credential credential;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}

    class AuthorityId implements Serializable {

        private static final int serialID = 1;

        @Id
        @Column(name = "authority")
        private String authority;

        @Id
        @ManyToOne
        @JoinColumn(name = "username")
        private Credential credential;

        public String getSecurity() {
            return authority;
        }

        public void setSecurity(String security) {
            this.authority = security;
        }

        public Credential getCredential() {
            return credential;
        }

        public void setCredential(Credential credential) {
            this.credential = credential;
        }

        public static int getSerialID() {
            return serialID;
        }

    }
