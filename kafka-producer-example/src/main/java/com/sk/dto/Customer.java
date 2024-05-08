package com.sk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {


    public int id;
    public String name;
    public String email;
    public String contactNo;



}
