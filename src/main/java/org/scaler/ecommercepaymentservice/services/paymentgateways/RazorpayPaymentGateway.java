package org.scaler.ecommercepaymentservice.services.paymentgateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.scaler.ecommercepaymentservice.dto.PaymentRequestDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Component
public class RazorpayPaymentGateway implements PaymentGateway {

    private final RazorpayClient razorpayClient;

    private RazorpayPaymentGateway(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) {
        try{
            JSONObject paymentLinkJson = new JSONObject();
            paymentLinkJson.put("amount", Integer.parseInt(paymentRequestDTO.getAmount()));
            paymentLinkJson.put("currency", "INR");
            paymentLinkJson.put("accept_partial", false);
            paymentLinkJson.put("expire_by", 1837182733);
            paymentLinkJson.put("reference_id", paymentRequestDTO.getOrderId());
            paymentLinkJson.put("description", "Payment for policy no #" + paymentRequestDTO.getOrderId());
            JSONObject customer = new JSONObject();
            customer.put("email", paymentRequestDTO.getEmail());
            customer.put("name", paymentRequestDTO.getName());
            customer.put("notes", paymentRequestDTO.getNotes());
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkJson.put("notify", notify);
            paymentLinkJson.put("customer", customer);
            PaymentLink paymentLink = razorpayClient.paymentLink.create(paymentLinkJson);
            System.out.println(Optional.ofNullable(paymentLink.get("short_url")));
            return paymentLink.toString();
        }catch(RazorpayException ex){
            throw new RuntimeException(ex);
        }
    }
}
