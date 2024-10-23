package org.scaler.ecommercepaymentservice.services.paymentgateways;

import org.scaler.ecommercepaymentservice.dto.PaymentRequestDTO;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public interface PaymentGateway {
    public String generatePaymentLink(PaymentRequestDTO paymentRequestDTO);

}
