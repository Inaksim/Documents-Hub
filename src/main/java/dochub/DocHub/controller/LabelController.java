package dochub.DocHub.controller;

import dochub.DocHub.dto.form.NewLabelForm;
import dochub.DocHub.service.LabelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/label")
@AllArgsConstructor
public class LabelController {

    private  LabelService labelService;
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<String> saveLabel(@RequestBody NewLabelForm form) {
        return labelService.saveLabel(form);
    }
}
