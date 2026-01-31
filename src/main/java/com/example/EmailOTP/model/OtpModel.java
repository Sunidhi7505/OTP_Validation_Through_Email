package com.example.EmailOTP.model;
import jakarta.persistence.*;

@Entity
@Table(name = "otp_details")

public class OtpModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String otp;
    
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getOtp() {
		return this.otp;
	}
}