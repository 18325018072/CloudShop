package com.kevin.cloudshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Kevin2
 */
@Data@NoArgsConstructor@AllArgsConstructor
public class ResultPac implements Serializable {
    int state;
    ResultState msg;
    Object data;
}
