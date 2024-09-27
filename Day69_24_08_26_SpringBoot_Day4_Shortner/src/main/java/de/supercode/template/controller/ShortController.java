package de.supercode.template.controller;

import de.supercode.template.dtos.UserUrlDto;
import de.supercode.template.service.ShortService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ShortController {

    ShortService shortService;

    public ShortController(ShortService shortService) {
        this.shortService = shortService;
    }

    @PostMapping("/short")
    public String setUrl(@RequestBody UserUrlDto userUrlDto){
        return shortService.makeItShort(userUrlDto);
    }

    @GetMapping("{shortUrl}")
    public void getUrl(@PathVariable String shortUrl, HttpServletResponse response){
        UserUrlDto existURL = shortService.getUserUrl(shortUrl);
        if(existURL == null) {
            response.setStatus(404);
        } else {
            response.setHeader("Location", existURL.getLongUrl());
            response.setStatus(302);
        }
    }
}
