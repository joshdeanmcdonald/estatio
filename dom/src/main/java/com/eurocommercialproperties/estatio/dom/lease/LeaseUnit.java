package com.eurocommercialproperties.estatio.dom.lease;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.runtimes.dflt.objectstores.jdo.applib.annotations.Auditable;
import org.joda.time.LocalDate;

import com.eurocommercialproperties.estatio.dom.asset.Unit;

@PersistenceCapable
@Auditable
public class LeaseUnit extends AbstractDomainObject {

    // TODO: LeaseUnit is an ugly name. Some applications use the word Demise.
    // Occupating/Occupation mayby?
    // {{ Lease (property)
    private Lease lease;

    // TODO: Fix title since this displays
    @Title(sequence = "1")
    @MemberOrder(sequence = "1")
    public Lease getLease() {
        return lease;
    }

    public void setLease(final Lease lease) {
        this.lease = lease;
    }

    // }}

    // {{ Unit (property)
    private Unit unit;

    //@Title(sequence = "2")
    @MemberOrder(sequence = "2")
    public Unit getUnit() {
        return unit;
    }

    public void setUnit(final Unit unit) {
        this.unit = unit;
    }

    // }}

    // {{ StartDate (property)
    private LocalDate startDate;

    @Persistent
    @Optional
    @MemberOrder(sequence = "3")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
    }

    // }}

    // {{ EndDate (property)
    // TODO: startDate vs startDate and endDate vs endDate have the same
    // meaning, all meant to bound an item to a period.
    private LocalDate endDate;

    @Persistent
    @Optional
    @MemberOrder(sequence = "4")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
    }
    // }}

}