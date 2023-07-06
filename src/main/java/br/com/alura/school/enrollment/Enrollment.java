package br.com.alura.school.enrollment;

import br.com.alura.school.course.Course;
import br.com.alura.school.user.User;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.*;

@Entity
@Table
public class Enrollment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrollment() {
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", enrollmentDate=" + enrollmentDate +
                ", user=" + user +
                ", course=" + course +
                '}';
    }
}
