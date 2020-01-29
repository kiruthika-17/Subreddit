package com.onedirect.reddit.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonErrorClass {

    private int ErrorCode;
    private String ErrorMessage;

}
