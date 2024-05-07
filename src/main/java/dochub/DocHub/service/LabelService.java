package dochub.DocHub.service;

import dochub.DocHub.dto.form.NewLabelForm;
import dochub.DocHub.entity.Document;
import dochub.DocHub.entity.Label;
import dochub.DocHub.entity.User;
import dochub.DocHub.repository.DocumentRepository;
import dochub.DocHub.repository.LabelRepository;
import lombok.AllArgsConstructor;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Collections;

@Service
@AllArgsConstructor
public class LabelService {

   private final LabelRepository labelRepository;
   private final DocumentRepository documentRepository;

   public ResponseEntity<String> saveLabel(NewLabelForm form) {
       if(documentRepository.existsById(form.getDocumentId())) {
           Document doc = documentRepository.findById(form.getDocumentId()).orElseThrow(()
                   -> new ExecutionException("Document not found", (Throwable) Collections.singletonMap("email", form.getDocumentId())));

           User user = new User();
           Label label = Label.builder()
                   .labelName(form.getName())
                   .color(form.getColor())
                   .user(user)
                   .build();
           labelRepository.save(label);
           return ResponseEntity.ok("Label created");
       }
       return (ResponseEntity<String>) ResponseEntity.badRequest();
   }
}
