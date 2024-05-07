package dochub.DocHub.dto.form;

import lombok.Data;

@Data
public class CheckVerificationCodeForm {
    private String email;
    private String verificationCode;
}
