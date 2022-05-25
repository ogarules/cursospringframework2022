package com.example.demo.ejercicio18.beans;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.demo.ejercicio18.SecretaryAssistantQualifier;

import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
@Named("ACME")
public class Corporation {
    
    @Inject
    @Qualifier("generalDirectorBean")
    private IDirector generalDirector;

    @Inject
    private IDirector itDirector;

    @Inject
    @Qualifier("generalSecretaryBean")
    private Optional<Secretary> generalSecretary;

    @Inject
    @SecretaryAssistantQualifier
    private Secretary secretaryAssistant;

    @Inject
    private Manager manager;
    
}
