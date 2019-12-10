package com.demoPackage.restapi.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT t FROM User t")
})
public class User implements Serializable{
	
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    
	    public String firstName;
		public String lastname;
		public String email;
		public String dob;
		public String password;
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		@Override
		public String toString() {
			return "User [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", email=" + email
					+ ", dob=" + dob + ", password=" + password + "]";
		}
		
	
}