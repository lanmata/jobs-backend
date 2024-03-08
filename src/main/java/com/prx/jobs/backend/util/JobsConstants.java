package com.prx.jobs.backend.util;

public final class JobsConstants {
    public static final String POST_CONTENT_DETAIL = """ 
            SELECT
                    pp.id,
                    pd3.mount_rate AS "mount",
                    pd1.datetime AS "createdDate",
                    pd2.datetime AS "lastModifiedDate",
                    st.name AS "status",
                    co.name AS "company",
                    po.name AS "position",
                    te.name AS "term",
                    mo.name AS "mode",
                    so.name AS "source"
            FROM
                jobs.post pp
                INNER JOIN jobs.post_detail pd ON pd.fk_post = pp.id
                INNER JOIN jobs.post_detail pd1 ON pd1.datetime = ( SELECT MIN ( pd1.datetime ) FROM jobs.post_detail pd1 WHERE pd1.fk_post = pp.id )
                INNER JOIN jobs.post_detail pd2 ON pd2.datetime = ( SELECT MAX ( pd2.datetime ) FROM jobs.post_detail pd2 WHERE pd2.fk_post = pp.id )
                INNER JOIN (
                        SELECT
                            fk_post,
                            mount_rate
                        FROM
              ( SELECT fk_post, mount_rate, ROW_NUMBER ( ) OVER ( PARTITION BY fk_post ORDER BY datetime DESC ) rn FROM jobs.post_detail WHERE mount_rate > 0.00 ) tmp
                        WHERE rn = 1
                        ) pd3 ON pd3.fk_post = pp.id 
                INNER JOIN jobs.status st ON st.id = pd2.fk_status
                INNER JOIN jobs.company co ON co.id = pp.fk_company
                INNER JOIN jobs.position po ON po.id = pp.fk_position
                INNER JOIN jobs.term te ON te.id = pp.fk_term
                INNER JOIN jobs.mode mo ON mo.id = pp.fk_mode
                INNER JOIN jobs.source so ON so.id = pp.fk_source
            WHERE
              pd2.fk_post = pp.id
            GROUP BY
                pp.id,
                pd3.mount_rate,
                pd1.datetime,
                pd2.datetime,
                st.name,
                co.name,
                po.name,
                te.name,
                mo.name,
                so.name
            """;


    private JobsConstants() {
    }
}
