package com.rmauction.roomservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ranajit Roy on 3/29/2023
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No such User found!")
public class UserNotFoundException extends RuntimeException {

}
