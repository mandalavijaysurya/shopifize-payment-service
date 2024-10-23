package org.scaler.ecommercepaymentservice.services.paymentgateways;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.scaler.ecommercepaymentservice.dto.PaymentRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */


@Component
public class StripePaymentGateway implements PaymentGateway {

    @Value("${stripe.key.id}")
    private String stripeSecretKey;

    @Override
    public String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) {
        try{
            Stripe.apiKey = this.stripeSecretKey;
            Price price = getPrice(Long.parseLong(paymentRequestDTO.getAmount()));

            PaymentLinkCreateParams params =
                    PaymentLinkCreateParams.builder()
                            .addLineItem(
                                    PaymentLinkCreateParams.LineItem.builder()
                                            .setPrice(price.getId())
                                            .setQuantity(1L)
                                            .build()
                            ).setAfterCompletion(
                                    PaymentLinkCreateParams.AfterCompletion.builder()
                                    .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                    .setRedirect(
                                            PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                            .setUrl("https://google.com?ref_id=" + "1234").build()
                                    ).build()
                            ).build();
            PaymentLink paymentLink = PaymentLink.create(params);
            return paymentLink.getUrl();
        }catch (StripeException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    private Price getPrice(Long productAmount){
        try{
            PriceCreateParams params = PriceCreateParams.builder()
                    .setCurrency("inr")
                    .setUnitAmount(productAmount)
                    .setProductData(
                            PriceCreateParams
                                    .ProductData
                                    .builder()
                                    .setName("PS5")
                                    .build()
                    )
                    .build();
            return Price.create(params);
        }catch(StripeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

}
