package nextstep.courses.domain;

import nextstep.courses.dto.NsUserLimitDTO;

public class NsUserLimit {
    private final int count;
    private final SessionPaymentType sessionPaymentType;

    public NsUserLimit(Integer count, SessionPaymentType sessionPaymentType) {
        this.count = count;
        this.sessionPaymentType = sessionPaymentType;
    }

    public boolean isLessThan(int size){
        return count < size;
    }

    public boolean isFull(int size){
        return count <= size && sessionPaymentType == SessionPaymentType.PAID;
    }

    public NsUserLimitDTO toDto() {
        return new NsUserLimitDTO(count);
    }
}
