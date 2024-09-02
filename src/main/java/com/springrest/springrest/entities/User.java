package com.springrest.springrest.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    public long Id;
    @Column(unique = true)
    @NonNull
    @JsonProperty("Username")
    public String Username;
    @NonNull
    @JsonProperty("Password")
    public String Password;

}
