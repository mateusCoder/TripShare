package com.devs.tripshare.controllers;

import com.devs.tripshare.config.annotations.records.GetRecordByIdDocConfig;
import com.devs.tripshare.dto.record.RecordDto;
import com.devs.tripshare.dto.record.RecordForm;
import com.devs.tripshare.services.RecordServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tripshare/records")
public class RecordController {

    private final RecordServiceImpl service;

    @GetMapping
    @GetRecordByIdDocConfig
    public ResponseEntity<RecordDto> findAll(@RequestBody RecordForm form){
        return ResponseEntity.ok().body(service.findAll(form));
    }
}
