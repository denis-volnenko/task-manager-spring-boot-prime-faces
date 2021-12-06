package school.volnenko.tm.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.volnenko.tm.enumerated.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "app_project")
public class Project {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String name = "";

    @Column
    private String description = "";

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.NOT_STARTED;

    @Column
    private Date dateStart;

    @Column
    private Date dateFinish;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
    private List<Task> tasks;

    public Project(String name) {
        this.name = name;
    }
}
