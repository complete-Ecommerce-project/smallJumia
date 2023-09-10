package com.example.jumia_Ecommerce_version2.service.implementation;

import com.example.jumia_Ecommerce_version2.data.repository.JumiaUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JumiaUserIMPL implements JumiaUserService  {
    private final JumiaUserRepository jumiaUserRepository;
    private final Tools tools;




}
