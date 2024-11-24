package com.prx.jobs.backend.constant;

public enum JobReportKey {
    ID(0, "Id", 35),
    MOUNT(1, "Mount", 12),
    CREATED_DATE(2, "Created At", 20),
    LAST_MODIFIED_DATE(3, "Updated At", 20),
    STATUS(4, "Status", 15),
    COMPANY(5, "Company", 35),
    POSITION(6, "Position", 45),
    TERM(7, "Term", 12),
    MODE(8, "Mode", 12),
    SOURCE(9, "Source", 15);

    private final int index;
    private final String key;
    private final int width;

    JobReportKey(int index, String key, int width) {
        this.index = index;
        this.key = key;
        this.width = width;
    }

    public int getIndex() {
        return index;
    }

    public String getKey() {
        return key;
    }

    public int getWidth() {
        return width;
    }
}
