package com.example.backend.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@Setter
public class BaseEntity implements Serializable {

    //private LocalDateTime addDate;
}
