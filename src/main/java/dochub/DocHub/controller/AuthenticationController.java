package dochub.DocHub.controller;

import dochub.DocHub.dto.form.CheckVerificationCodeForm;
import dochub.DocHub.dto.form.SendVerificationCodeForm;
import dochub.DocHub.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationService authService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(value = "/send-verification-code", consumes = "application/json")
    public void verifyEmail(@RequestBody SendVerificationCodeForm model) {
        authService.sendVerificationEmail(model);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(value = "/check-verification-code", consumes = "application/json")
    public void checkVerificationCode( @RequestBody CheckVerificationCodeForm model) {
        authService.checkVerificationCode(model);
    }

}
