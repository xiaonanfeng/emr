package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrChargesNote;

public interface MisEmrChargesNoteService extends ABaseService {

    List<MisEmrChargesNote> findMisEmrChargesNoteByEmrId(String emrId);

}
