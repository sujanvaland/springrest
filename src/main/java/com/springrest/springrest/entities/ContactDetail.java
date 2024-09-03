package com.springrest.springrest.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="contactDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;
    private String phone;
    private String email;

    public ContactDetail(String email, String phone, Contact contact) {
        this.email = email;
        this.phone = phone;
        this.contact = contact;
    }
}
