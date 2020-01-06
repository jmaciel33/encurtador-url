package com.encurtador.mseventrefresher.config;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.policies.RoundRobinPolicy;
import com.datastax.driver.core.policies.TokenAwarePolicy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Cassandra configuration.
 */
@Configuration
@Lazy
@ConfigurationProperties(prefix = "spring.data.cassandra")
public class CassandraSettings extends AbstractCassandraConfiguration {

    /**
     * Cassandra contact points.
     */
    private String contactPoints;

    /**
     * Cassandra port.
     */
    private String port;

    /**
     * Cassandra keyspace name.
     */
    private String keyspaceName;

    /**
     * Cassandra username.
     */
    private String username;

    /**
     * Cassandra password.
     */
    private String password;

    /**
     * When using the `DCAwareRoundRobin` or `RequestDCAwareRoundRobin` load balancing policy,
     * you must specify the name of the local (closest) datacenter for this Kong node.
     */
    private String localDc;

    /**
     * Consistency setting to use when reading/writing to the Cassandra cluster.
     */
    private String consistencyLevel;


    /**
     * Setter contact-points.
     *
     * @param contactPoints the contact points
     */
    public void setContactPoints(String contactPoints) {
        this.contactPoints = contactPoints;
    }

    /**
     * Setter Port.
     *
     * @param port the port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Setter keyspace name.
     *
     * @param keyspaceName the keyspace name
     */
    public void setKeyspaceName(String keyspaceName) {
        this.keyspaceName = keyspaceName;
    }

    /**
     * Getter username.
     *
     * @return username username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter password.
     *
     * @return password password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the keyspace name.
     *
     * @return The keyspace name.
     */
    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    /**
     * Gets local dc.
     *
     * @return the local dc
     */
    public String getLocalDc() {
        return localDc;
    }

    /**
     * Sets local dc.
     *
     * @param localDc the local dc
     */
    public void setLocalDc(String localDc) {
        this.localDc = localDc;
    }

    /**
     * Gets consistency level.
     *
     * @return the consistency level
     */
    public String getConsistencyLevel() {
        return consistencyLevel;
    }

    /**
     * Sets consistency level.
     *
     * @param consistencyLevel the consistency level
     */
    public void setConsistencyLevel(String consistencyLevel) {
        this.consistencyLevel = consistencyLevel;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    /**
     * Sets up the cluster configuration.
     *
     * @return An instance of CassandraClusterFactoryBean.
     */
    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {

        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();

        cluster.setMetricsEnabled(false);
        cluster.setKeyspaceCreations(getKeyspaceCreations());
        cluster.setJmxReportingEnabled(false);
        cluster.setContactPoints(this.contactPoints);
        cluster.setPort(Integer.parseInt(this.port));
        cluster.setUsername(this.username);
        cluster.setPassword(this.password);
        cluster.setRetryPolicy(DefaultRetryPolicy.INSTANCE);
        cluster.setPoolingOptions(new PoolingOptions().setIdleTimeoutSeconds(60));

        if (this.localDc != null && !this.localDc.isEmpty()) {
            cluster.setLoadBalancingPolicy(new TokenAwarePolicy(new DCAwareRoundRobinPolicy.Builder()
                    .withLocalDc(this.localDc)
                    .build()));
        } else {
            cluster.setLoadBalancingPolicy(new TokenAwarePolicy(new RoundRobinPolicy()));
        }

        if (this.consistencyLevel != null && !this.consistencyLevel.isEmpty()) {
            cluster.setQueryOptions(new QueryOptions()
                    .setConsistencyLevel(ConsistencyLevel.valueOf(this.consistencyLevel)));
        } else {
            cluster.setQueryOptions(new QueryOptions().setConsistencyLevel(ConsistencyLevel.LOCAL_QUORUM));
        }


        return cluster;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Arrays.asList(CreateKeyspaceSpecification.createKeyspace(keyspaceName).ifNotExists());
    }

    @Override
    protected List<String> getStartupScripts() {
        return Collections.singletonList("CREATE TABLE IF NOT EXISTS " + keyspaceName + ".short_url (\n" +
                "  short_url text,\n" +
                "  original_url text,\n" +
                "  PRIMARY KEY (short_url)\n" +
                ")");
    }
}
