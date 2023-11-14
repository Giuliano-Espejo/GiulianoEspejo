package com.facu.restfake.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

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
public class Rating extends Base {

    @NotNull
    @Column(name = "rating", precision = 10, scale = 2)
    private BigDecimal rate;

    @Column(name = "contador")
    private int count;







}
