package com.queue.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by liusong on 2018/4/9.
 */
public class ChooseDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {
        return HandleDataSource.getDataSource();
    }
}
