package org.scaler.ecommercepaymentservice.services.paymentgateways;

import org.scaler.ecommercepaymentservice.dto.PaymentRequestDTO;
import org.springframework.stereotype.Component;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */


@Component
public class StripePaymentGateway implements PaymentGateway {

    @Override
    public String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) {
        return "";
    }

}
