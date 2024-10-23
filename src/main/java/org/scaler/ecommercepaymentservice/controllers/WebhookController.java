package org.scaler.ecommercepaymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@RestController
public class WebhookController {
    @PostMapping("/webhook")
    private void webhook(@RequestBody Object o){
        System.out.println("DEBUG");
    }
}
