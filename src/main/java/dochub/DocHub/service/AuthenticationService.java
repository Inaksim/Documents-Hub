package dochub.DocHub.service;

import dochub.DocHub.dto.form.CheckVerificationCodeForm;
import dochub.DocHub.dto.form.SendVerificationCodeForm;
import dochub.DocHub.entity.User;
import dochub.DocHub.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationService {

    private  UserRepository userRepository;

    private  EmailService emailService;


    public void sendVerificationEmail( @NonNull SendVerificationCodeForm model) {
        User user = userRepository.findByEmail(model.getEmail()).orElseThrow(() -> new ExecutionException("User not found", (Throwable) Collections.singletonMap("email", model.getEmail())));
        int code = generateVerificationCode();
        emailService.sendEmail(user.getEmail(), "Verification code", "Your verification code is: " + code);
        user.setVerifyCode(String.valueOf(code));
        userRepository.saveAndFlush(user);
    }


    public void checkVerificationCode(@NonNull CheckVerificationCodeForm model) {
        User user = userRepository.findByEmail(model.getEmail()).orElseThrow(()-> new ExecutionException("User not found", (Throwable) Collections.singletonMap("email", model.getEmail())));
        if (!user.getVerifyCode().equals(model.getVerificationCode())) {
            throw new ExecutionException("Verification code not match");
        }
    }

    public static int generateVerificationCode() {
        return (int) (Math.random() * (9999 - 1000) + 1000);
    }
}
