package nextstep.courses.domain;

import static nextstep.courses.domain.SessionBuilder.aSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import nextstep.users.domain.NsUser;
import nextstep.users.domain.NsUserTest;
import nextstep.users.domain.NsUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionTest {
    @Test
    @DisplayName("강의 생성")
    void create() {
        assertThat(aSession().build())
                .isInstanceOf(Session.class);
    }

    @Test
    @DisplayName("강의 생성시 가격 타입 & 가격 매칭 실패 에러 던짐")
    void create_throw_exception_sessionPaymentType_price() {
        assertThatThrownBy(() ->
                aSession().withCourse(CourseTest.C1)
                        .withSessionPaymentType(SessionPaymentType.PAID)
                        .withAmountOfPrice(0L).build()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Enrollment의 nsUsers를 새 NsUsers로 교체")
    void replaceEnrollmentNsUsers() {
        List<NsUser> userList = new ArrayList<>(List.of(NsUserTest.JAVAJIGI));
        Session session = aSession()
                .withCourse(CourseTest.C1)
                .withUserList(userList).build();
        NsUsers users = new NsUsers(List.of(NsUserTest.JAVAJIGI, NsUserTest.SANJIGI));
        session.replaceEnrollmentNsUsers(e -> users);
        assertThat(userList).contains(NsUserTest.JAVAJIGI, NsUserTest.SANJIGI);
    }
}
