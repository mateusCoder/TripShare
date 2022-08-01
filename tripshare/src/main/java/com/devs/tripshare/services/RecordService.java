package com.devs.tripshare.services;

import com.devs.tripshare.dto.record.RecordDto;
import com.devs.tripshare.dto.record.RecordForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecordService {

    RecordDto findAll(RecordForm form);
}
