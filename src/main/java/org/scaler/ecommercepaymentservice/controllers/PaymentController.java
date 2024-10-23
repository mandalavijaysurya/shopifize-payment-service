package org.scaler.ecommercepaymentservice.controllers;

import org.scaler.ecommercepaymentservice.dto.PaymentRequestDTO;
import org.scaler.ecommercepaymentservice.services.PaymentGatewaySelector;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@RestController
public class PaymentController {
    private final PaymentGatewaySelector selector;

    public PaymentController(PaymentGatewaySelector selector){
        this.selector = selector;
    }

    @PostMapping("/payment")
    public String initiatePayment(@RequestBody PaymentRequestDTO paymentDTO){
        return selector
                .getPaymentGateway(paymentDTO
                        .getPGateway()
                        .toString()
                        .toLowerCase()
                )
                .generatePaymentLink(paymentDTO);
    }
}
