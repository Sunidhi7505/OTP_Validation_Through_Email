package com.example.EmailOTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmailOTP.model.OtpModel;

public interface OtpRepository extends JpaRepository<OtpModel, Long> {

    // REQUIRED to fetch OTP by email


	OtpModel findByEmail(String email); 
}