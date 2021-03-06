package org.estatio.dom.lease.status;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;

import javax.inject.Inject;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import org.estatio.dom.lease.Lease;
import org.estatio.dom.lease.LeaseItem;
import org.estatio.dom.lease.LeaseItemStatus;
import org.estatio.dom.lease.LeaseStatus;
import org.estatio.services.clock.ClockService;

public class LeaseStatusServiceTest {

    private Lease lease;

    @Inject
    private LeaseStatusService service;

    @Before
    public void setUp() throws Exception {
        lease = new Lease();
        service = new LeaseStatusService();
        service.clockService = new ClockService();

    }

    @Test
    public void terminated() {
        tester(
                LeaseStatus.TERMINATED,
                new LocalDate(2014, 1, 1), new LocalDate(2014, 3, 31), testItem(null, LeaseItemStatus.ACTIVE));
    }

    @Test
    public void active() {
        tester(
                LeaseStatus.ACTIVE,
                new LocalDate(2014, 1, 1), new LocalDate(2015, 3, 31), testItem(null, LeaseItemStatus.ACTIVE));
    }
    
    @Test
    public void partiallySuspended() {
        tester(
                LeaseStatus.SUSPENDED_PARTIALLY,
                new LocalDate(2014, 1, 1), new LocalDate(2015, 3, 31), testItem(null, LeaseItemStatus.ACTIVE), testItem(null, LeaseItemStatus.SUSPENDED));
    }

    @Test
    public void suspended() {
        tester(
                LeaseStatus.SUSPENDED,
                new LocalDate(2014, 1, 1), new LocalDate(2015, 3, 31), testItem(null, LeaseItemStatus.SUSPENDED));
        tester(
                LeaseStatus.SUSPENDED,
                new LocalDate(2014, 1, 1), new LocalDate(2015, 3, 31), testItem(null, LeaseItemStatus.SUSPENDED), testItem(null, LeaseItemStatus.SUSPENDED));
    }
    

    void tester(LeaseStatus expectedStatus, LocalDate tenancyStartDate, LocalDate tenancyEndDate, LeaseItem... items) {
        lease.setTenancyStartDate(tenancyStartDate);
        lease.setTenancyEndDate(tenancyEndDate);
        int seq = 1;
        for (LeaseItem item : items) {
            item.setSequence(BigInteger.valueOf(seq));
            lease.getItems().add(item);
            seq++;
        }
        assertThat(lease.getItems().size(), is(items.length));
        assertThat(service.statusOf(lease), is(expectedStatus));
    }

    LeaseItem testItem(LocalDate startDate, LeaseItemStatus status) {
        LeaseItem item = new LeaseItem();
        item.setStartDate(startDate);
        item.setStatus(status);
        return item;
    }

}
