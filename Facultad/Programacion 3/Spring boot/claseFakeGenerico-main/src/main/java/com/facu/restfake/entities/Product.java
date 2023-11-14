package com.facu.restfake.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product  extends Base {


    @NotNull
    @Column(name = "titulo")
    private String title;
        @NotNull
        @Column(name = "precio_compra", precision = 10, scale = 2)
        private BigDecimal price;


        @Column(name = "description")
        private String description;

        @Column(name = "categoria")
        private String category;

        @Column(name = "url_imagen")
        private String image;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
       @JoinColumn(name = "rating_id")
       private Rating rating;
}
