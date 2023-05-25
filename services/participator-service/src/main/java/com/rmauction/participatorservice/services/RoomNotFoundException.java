package com.rmauction.participatorservice.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ranajit Roy on 3/29/2023
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No such Room or User found!")
public class RoomNotFoundException extends RuntimeException {

}
