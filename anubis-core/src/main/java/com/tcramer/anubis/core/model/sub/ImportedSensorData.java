package com.tcramer.anubis.core.model.sub;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ImportedSensorData implements Imported {

    @Column(name = "importDate", nullable = false)
    private Date importDate;

    public ImportedSensorData(Date importDate) {
        this.importDate = importDate;
    }

    @Override
    public Date getImportDate() {
        return importDate;
    }

    @Override
    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }
}
