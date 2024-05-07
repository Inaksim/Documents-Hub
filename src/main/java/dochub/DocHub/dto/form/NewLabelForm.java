package dochub.DocHub.dto.form;

import lombok.Data;

@Data
public class NewLabelForm {
    private String name;
    private Long documentId;
    private String color;
}
