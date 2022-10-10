package pro.sky.skypro2.demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController()
public class InvalidInputException extends RuntimeException {
}