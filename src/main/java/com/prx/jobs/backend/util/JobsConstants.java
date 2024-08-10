package com.prx.jobs.backend.util;

public final class JobsConstants {
    public static final String ENTITY_PACKAGE = "com.prx.jobs.backend.jpa.entity";
    public static final String REPOSITORY_PACKAGE = "com.prx.jobs.backend.jpa.repository";
    public static final String NOT_IMPLEMENTED = "Not implemented yet";
    public static final String JOB_OFFER_CONTENT_DETAIL = """ 
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
                jobs.job_offer pp
                INNER JOIN jobs.job_offer_detail pd ON pd.fk_job_offer = pp.id
                INNER JOIN jobs.job_offer_detail pd1 ON pd1.datetime = ( SELECT MIN ( pd1.datetime ) FROM jobs.job_offer_detail pd1 WHERE pd1.fk_job_offer = pp.id )
                INNER JOIN jobs.job_offer_detail pd2 ON pd2.datetime = ( SELECT MAX ( pd2.datetime ) FROM jobs.job_offer_detail pd2 WHERE pd2.fk_job_offer = pp.id )
                INNER JOIN (
                        SELECT
                            fk_job_offer,
                            mount_rate
                        FROM
              ( SELECT fk_job_offer, mount_rate, ROW_NUMBER ( ) OVER ( PARTITION BY fk_job_offer ORDER BY datetime DESC ) rn FROM jobs.job_offer_detail WHERE mount_rate > 0.00 ) tmp
                        WHERE rn = 1
                        ) pd3 ON pd3.fk_job_offer = pp.id 
                INNER JOIN jobs.status st ON st.id = pd2.fk_status
                INNER JOIN jobs.company co ON co.id = pp.fk_company
                INNER JOIN jobs.position po ON po.id = pp.fk_position
                INNER JOIN jobs.term te ON te.id = pp.fk_term
                INNER JOIN jobs.mode mo ON mo.id = pp.fk_mode
                INNER JOIN jobs.source so ON so.id = pp.fk_source
            WHERE
              pd2.fk_job_offer = pp.id
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

    public static final String JOB_REPORT_BY_DATE_RANGE = """
            SELECT
            	pp.ID,
            	pd3.mount_rate AS "mount",
            	pd1.datetime AS "created_date",
            	pd2.datetime AS "last_modified_date",
            	st.NAME AS "status",
            	co.NAME AS "company",
            	po.NAME AS "position",
            	te.NAME AS "term",
            	mo.NAME AS "mode",
            	so.NAME AS "source"
            FROM
            	jobs.job_offer pp
            	INNER JOIN jobs.job_offer_detail pd ON pd.fk_job_offer = pp.ID
            	INNER JOIN jobs.job_offer_detail pd1 ON pd1.datetime = ( SELECT MIN ( pd1.datetime ) FROM jobs.job_offer_detail pd1 WHERE pd1.fk_job_offer = pp.ID )
            	INNER JOIN jobs.job_offer_detail pd2 ON pd2.datetime = ( SELECT MAX ( pd2.datetime ) FROM jobs.job_offer_detail pd2 WHERE pd2.fk_job_offer = pp.ID )
            	INNER JOIN (
            	SELECT
            		fk_job_offer,
            		mount_rate
            	FROM
            		( SELECT fk_job_offer, mount_rate, ROW_NUMBER ( ) OVER ( PARTITION BY fk_job_offer ORDER BY datetime DESC ) rn FROM jobs.job_offer_detail WHERE mount_rate > 0.00 ) tmp
            	WHERE
            		rn = 1
            	) pd3 ON pd3.fk_job_offer = pp.ID
            	INNER JOIN jobs.status st ON st.ID = pd2.fk_status
            	INNER JOIN jobs.company co ON co.ID = pp.fk_company
            	INNER JOIN jobs.position po ON po.ID = pp.fk_position
            	INNER JOIN jobs.term te ON te.ID = pp.fk_term
            	INNER JOIN jobs.mode mo ON mo.ID = pp.fk_mode
            	INNER JOIN jobs.source so ON so.ID = pp.fk_source
            WHERE
            	pd2.fk_job_offer = pp.ID
            	AND pd.datetime BETWEEN :startDate AND :endDate
            GROUP BY
            	pp.ID,
            	pd3.mount_rate,
            	pd1.datetime,
            	pd2.datetime,
            	st.NAME,
            	co.NAME,
            	po.NAME,
            	te.NAME,
            	mo.NAME,
            	so.NAME
            """;


    private JobsConstants() {
    }
}
