package edu.umich.its.cpm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonRawValue;

@Entity
@Table(name = "MIGRATION")
public class Migration {

	private static final Logger log = LoggerFactory.getLogger(Migration.class);
	
	/**
	 * primary key field
	 * a migration is for a single tool (i.e. Resources tool) in a single CTools site
	 */
	@Id
	@Column(name = "MIGRATION_ID", columnDefinition = "VARCHAR(99) NOT NULL")
	@Getter
	@Setter
	private String migration_id;

	/**
	 * bulk migration id 
	 * null for self-migrated (non-batch) site migration
	 */
	@Column(name = "BULK_MIGRATION_ID", columnDefinition = "VARCHAR(99)")
	@Getter
	@Setter
	private String bulk_migration_id;

	/**
	 * user entered name for a bulk migration process
	 */
	@Column(name = "BULK_MIGRATION_NAME", columnDefinition = "VARCHAR(99)")
	@Getter
	@Setter
	private String bulk_migration_name;

	@Column(name = "SITE_ID", columnDefinition = "VARCHAR(99) NOT NULL")
	@Getter
	@Setter
	private String site_id;

	@Column(name = "SITE_NAME", columnDefinition = "VARCHAR(99) NOT NULL")
	@Getter
	@Setter
	private String site_name;

	@Column(name = "TOOL_NAME", columnDefinition = "VARCHAR(99) NOT NULL")
	@Getter
	@Setter
	private String tool_name;

	@Column(name = "TOOL_ID", columnDefinition = "VARCHAR(99) NOT NULL")
	@Getter
	@Setter
	private String tool_id;

	@Column(name = "MIGRATED_BY", columnDefinition = "VARCHAR(99) NOT NULL")
	@Getter
	@Setter
	private String migrated_by;

	@Column(name = "START_TIME", columnDefinition = "TIMESTAMP NOT NULL")
	@Getter
	@Setter
	private Timestamp start_time;

	@Column(name = "END_TIME", columnDefinition = "TIMESTAMP")
	@Getter
	@Setter
	private Timestamp end_time;

	@Column(name = "DESTINATION_TYPE", columnDefinition = "VARCHAR(99) NOT NULL")
	@Getter
	@Setter
	private String destination_type;

	@Column(name = "DESTINATION_URL", columnDefinition = "VARCHAR(99)")
	@Getter
	@Setter
	private String destination_url;

	@Column(name = "STATUS", columnDefinition = "LOB")
	@Getter
	@Setter
	@JsonRawValue
	private String status;

	protected Migration() {
	}

	public Migration(String site_id, String site_name, String tool_id,
			String tool_name, String migrated_by, Timestamp start_time,
			Timestamp end_time, String destination_type,
			String destination_url, String status) {
		this.migration_id = UUID.randomUUID().toString();
		log.info(this.migration_id);
		this.site_id = site_id;
		this.site_name = site_name;
		this.tool_id = tool_id;
		this.tool_name = tool_name;
		this.migrated_by = migrated_by;
		this.start_time = start_time;
		this.end_time = end_time;
		this.destination_type = destination_type;
		this.destination_url = destination_url;
		this.status = status;
	}

	public Migration(String bulk_migration_id, String bulk_migration_name,
			String site_id, String site_name, String tool_id, String tool_name,
			String migrated_by, Timestamp start_time, Timestamp end_time,
			String destination_type, String destination_url, String status) {
		this.migration_id = UUID.randomUUID().toString();
		log.info(this.migration_id);
		this.bulk_migration_id = bulk_migration_id;
		this.bulk_migration_name = bulk_migration_name;
		this.site_id = site_id;
		this.site_name = site_name;
		this.tool_id = tool_id;
		this.tool_name = tool_name;
		this.migrated_by = migrated_by;
		this.start_time = start_time;
		this.end_time = end_time;
		this.destination_type = destination_type;
		this.destination_url = destination_url;
		this.status = status;
	}

	@Override
	public String toString() {
		String s = String
				.format("Migration[migration_id=%d, "
						+ "bulk_migration_id='%s',"
						+ "bulk_migration_name='%s'," + "site_id='%s',"
						+ "site_name='%s'," + "tool_id='%s',"
						+ "tool_name='%s'," + "migrated_by='%s',"
						+ "start_time='%s'," + "end_time='%s',"
						+ "destination_type='%s'," + "destination_url='%s'"
						+ "status='%s'" + "]", migration_id, site_id,
						site_name, tool_id, tool_name, migrated_by, start_time,
						end_time, destination_type, destination_url, status);
		return s;
	}
}
