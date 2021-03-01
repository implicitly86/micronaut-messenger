package com.implicitly.messenger.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emil Murzakaev.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class MessageDto {

    private String message;

}
