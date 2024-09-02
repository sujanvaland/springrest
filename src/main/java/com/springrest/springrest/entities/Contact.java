package com.springrest.springrest.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "contact")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    public long Id;

    @JsonProperty("Name")
    public String Name;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ContactDetail> contactDetailList = new ArrayList<>();

    public Contact(String name) {
        this.Name = name;
    }

    public void setContactDetails(List<ContactDetail> contactDetailsList) {
        this.contactDetailList = contactDetailsList;
    }
}
