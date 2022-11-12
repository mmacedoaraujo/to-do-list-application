package com.mmacedo.todolist.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "todo_db")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Todo implements Serializable {
    private static final long serialVersionUID = 8879313863115671402L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Please insert a title")
    private String title;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateToFinishTask;
    private Boolean finished;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Todo todo = (Todo) o;
        return id != null && Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
