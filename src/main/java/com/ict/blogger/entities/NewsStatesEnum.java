/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.entities;

/**
 *
 * @author tseke
 */
public enum NewsStatesEnum {
    EXPECTED(1L),
    FAIL(2L),
    SUCCESS(3L);

    private Long id;

    NewsStatesEnum(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
