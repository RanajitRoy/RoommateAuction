package com.rmauction.roomservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No such Room was found!")
public class RoomNotFoundException extends RuntimeException {

}
