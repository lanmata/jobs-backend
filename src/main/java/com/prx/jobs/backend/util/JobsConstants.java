package com.prx.jobs.backend.util;

public final class JobsConstants {
    public static final String POST_CONTENT_DETAIL = "SELECT pp.id, pd3.mount_rate AS mount, " +
            "pd1.datetime, pd2.datetime, st.name AS status, co.name AS company, po.name AS position, " +
            "te.name AS term, mo.name AS mode, so.name AS source " +
            "FROM jobs.post pp " +
            "INNER JOIN jobs.post_detail pd ON pd.fk_post = pp.id " +
            "INNER JOIN jobs.post_detail pd1 ON pd1.datetime = (SELECT  MIN(pd1.datetime) FROM jobs.post_detail pd1 where pd1.fk_post = pp.id) " +
            "INNER JOIN jobs.post_detail pd2 ON pd2.datetime = (SELECT  MAX(pd2.datetime) FROM jobs.post_detail pd2 where pd2.fk_post = pp.id) " +
            "INNER JOIN jobs.post_detail pd3 ON pd3.mount_rate = (SELECT  pd3.mount_rate FROM jobs.post_detail pd3 where pd3.fk_post = pp.id AND pd3.mount_rate > 0.00 " +
            "ORDER BY pd2.datetime DESC LIMIT 1) " +
            "INNER JOIN jobs.status st ON st.id = pd2.fk_status " +
            "INNER JOIN jobs.company co ON co.id = pp.fk_company " +
            "INNER JOIN jobs.position po ON po.id = pp.fk_position " +
            "INNER JOIN jobs.term te ON te.id = pp.fk_term " +
            "INNER JOIN jobs.mode mo ON mo.id = pp.fk_mode " +
            "INNER JOIN jobs.source so ON so.id = pp.fk_source " +
            "WHERE pp.id = :postId  AND pd.id = pd1.id LIMIT 1";

    private JobsConstants() {}
}
