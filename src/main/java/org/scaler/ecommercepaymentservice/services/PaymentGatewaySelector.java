package org.scaler.ecommercepaymentservice.services;

import org.scaler.ecommercepaymentservice.services.paymentgateways.PaymentGateway;
import org.scaler.ecommercepaymentservice.services.paymentgateways.RazorpayPaymentGateway;
import org.scaler.ecommercepaymentservice.services.paymentgateways.StripePaymentGateway;
import org.springframework.stereotype.Service;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Service
public class PaymentGatewaySelector {
    private final RazorpayPaymentGateway razorpayPaymentGateway;
    private final StripePaymentGateway stripePaymentGateway;

    public PaymentGatewaySelector(RazorpayPaymentGateway razorpayPaymentGateway, StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getPaymentGateway(String paymentGateway) {
        if (paymentGateway.equals("razorpay")) {
            return razorpayPaymentGateway;
        }
        return stripePaymentGateway;
    }
}
