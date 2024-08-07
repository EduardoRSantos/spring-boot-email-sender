package org.eduardo.SenderEmail.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Email {

    private List<String> to = new ArrayList<>();
    private String subject;
    private String text;
}
