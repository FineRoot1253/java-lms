package nextstep.courses.domain;

import nextstep.courses.dto.SessionPaymentDTO;

public class SessionPayment {
    private final SessionPaymentType type;
    private final Long amount;

    public SessionPayment() {
        this(SessionPaymentType.FREE, 0L);
    }


    public SessionPayment(SessionPaymentType type, Long amount) {
        validatePrice(type, amount);
        this.type = type;
        this.amount = amount;
    }

    private void validatePrice(SessionPaymentType sessionPaymentType, Long price) {
        if (sessionPaymentType == SessionPaymentType.PAID && price <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.SESSION_PAYMENT_NEED_PRICE.getMessage());
        }
    }

    public boolean isPaid() {
        return type == SessionPaymentType.PAID;
    }

    public SessionPaymentDTO toDto(){
        return new SessionPaymentDTO(type, amount);
    }
}
