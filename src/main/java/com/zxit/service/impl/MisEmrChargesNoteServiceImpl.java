package com.zxit.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zxit.model.MisEmrChargesNote;
import com.zxit.service.MisEmrChargesNoteService;

@Service("misEmrChargesNoteService")
public class MisEmrChargesNoteServiceImpl extends ABaseServiceImpl implements
        MisEmrChargesNoteService {

    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrChargesNote> findMisEmrChargesNoteByEmrId(String emrId) {
        List<MisEmrChargesNote> list = this.findByHQL(" from MisEmrChargesNote t where t.emrId = '" + emrId + "'").list();
        return list;
    }

}
