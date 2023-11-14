package com.proma.demopro3ma.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.swing.text.StyledEditorKit;
import java.io.Serializable;

@Entity//la clase va a ser manejada por un motor de persistencia
@Data//de lombok,genera gets,sets,contructores, equals y hascode
@NoArgsConstructor//no hace constructor vacio
@AllArgsConstructor //hace el contructor lleno
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;


    private int dni;

    @OneToOne
    private Domicilio domicilio;

    private Boolean deleted = Boolean.TRUE;

    private Boolean status = Boolean.TRUE;
}
