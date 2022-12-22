package com.example.json.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
@Getter
@Entity
@Table(name = "USER_REDIS")
@NoArgsConstructor
@AllArgsConstructor
public class UserRedis implements Serializable {

    private static final long serialVersionUID = -1541408164202572383L;


    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    private Long age;
}
