package school.volnenko.tm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.volnenko.tm.enumerated.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "app_task")
public class Task {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String name = "";

    @Column
    private String description = "";

    @Column
    private Date dateStart;

    @Column
    private Date dateFinish;

    @ManyToOne
    private Project project;

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.NOT_STARTED;

    public Task(String name) {
        this.name = name;
    }

}
