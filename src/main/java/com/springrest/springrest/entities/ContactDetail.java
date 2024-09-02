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
    private String Phone;
    private String Email;

    public ContactDetail(String email, String phone, Contact contact) {
        this.Email = email;
        this.Phone = phone;
        this.contact = contact;
    }
}
