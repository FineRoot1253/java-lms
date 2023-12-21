package nextstep.courses.domain;

import java.time.LocalDateTime;

public abstract class AuditInfo {
    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    protected AuditInfo(LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
