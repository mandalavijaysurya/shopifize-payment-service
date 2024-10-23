package org.scaler.ecommercepaymentservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.scaler.ecommercepaymentservice.enums.PGateway;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentRequestDTO {
    private String orderId;
    private String email;
    private String phoneNumber;
    private String name;
    private String notes;
    private String amount;
    @JsonDeserialize
    private PGateway pGateway;
}
