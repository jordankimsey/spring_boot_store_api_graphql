package com.jordan.hplus.controller;

import com.jordan.hplus.data.SalesPerson;
import com.jordan.hplus.data.SalesPersonRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SalesPersonController {
    private final SalesPersonRepository salesPersonRepository;

    public SalesPersonController(SalesPersonRepository salesPersonRepository) {
        this.salesPersonRepository = salesPersonRepository;
    }

    @QueryMapping
    public Iterable<SalesPerson> salesPeople() {
        return this.salesPersonRepository.findAll();
    }

    @QueryMapping
    public SalesPerson salesPersonById(@Argument Long id) {
        return this.salesPersonRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public SalesPerson salesPersonByEmail(@Argument String email) {
        return this.salesPersonRepository.findSalesPersonByEmail(email);
    }
}
